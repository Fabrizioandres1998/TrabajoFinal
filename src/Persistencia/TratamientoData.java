package Persistencia;

import Modelo.Producto;
import Modelo.Tratamiento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TratamientoData {

    private Connection conex = null;

    // constructor que recibe la conexion
    public TratamientoData(Conexion con) {
        this.conex = con.obtenerConexion();
    }

    // constructor vacio
    public TratamientoData() {
    }

    // guarda un nuevo tratamiento junto con sus productos
    public void guardarTratamiento(Tratamiento t) {
        String query = "INSERT INTO tratamiento (nombre, tipo, detalle, duracion, costo, activo) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conex.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getTipo());
            ps.setString(3, t.getDetalle());
            ps.setInt(4, t.getDuracion());
            ps.setDouble(5, t.getCosto());
            ps.setBoolean(6, t.isActivo());
            ps.executeUpdate();

            // Obtener el ID generado del tratamiento
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                t.setCodTratam(rs.getInt(1));
            }
            ps.close();

            // Guardar la relación tratamiento-producto
            String sqlRel = "INSERT INTO tratamiento_producto(codTratam, codProd) VALUES (?, ?)";
            for (Producto p : t.getProductos()) {
                PreparedStatement psRel = conex.prepareStatement(sqlRel);
                psRel.setInt(1, t.getCodTratam());
                psRel.setInt(2, p.getCodProd());
                psRel.executeUpdate();
                psRel.close();
            }

        } catch (Exception e) {
            System.out.println("Error al guardar tratamiento: " + e.getMessage());
        }
    }

    // actualiza los datos de un tratamiento y su relación con productos
    public void actualizarTratamiento(Tratamiento t) {
        String query = "UPDATE tratamiento SET nombre = ?, tipo = ?, detalle = ?, duracion = ?, costo = ?, activo = ? WHERE codTratam = ?";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getTipo());
            ps.setString(3, t.getDetalle());
            ps.setInt(4, t.getDuracion());
            ps.setDouble(5, t.getCosto());
            ps.setBoolean(6, t.isActivo());
            ps.setInt(7, t.getCodTratam());
            ps.executeUpdate();
            ps.close();

            // Primero, eliminar las relaciones anteriores
            String sqlDeleteRel = "DELETE FROM tratamiento_producto WHERE codTratam = ?";
            PreparedStatement psDelete = conex.prepareStatement(sqlDeleteRel);
            psDelete.setInt(1, t.getCodTratam());
            psDelete.executeUpdate();
            psDelete.close();

            // Insertar las nuevas relaciones
            String sqlInsertRel = "INSERT INTO tratamiento_producto(codTratam, codProd) VALUES (?, ?)";
            for (Producto p : t.getProductos()) {
                PreparedStatement psRel = conex.prepareStatement(sqlInsertRel);
                psRel.setInt(1, t.getCodTratam());
                psRel.setInt(2, p.getCodProd());
                psRel.executeUpdate();
                psRel.close();
            }

        } catch (Exception e) {
            System.out.println("Error al actualizar tratamiento: " + e.getMessage());
        }
    }

    // busca un tratamiento por codigo (productos no incluidos)
    public Tratamiento buscarTratamiento(int codTratam) {
        Tratamiento t = null;
        String query = "SELECT * FROM tratamiento WHERE codTratam = ?";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setInt(1, codTratam);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                t = new Tratamiento();
                t.setCodTratam(rs.getInt("codTratam"));
                t.setNombre(rs.getString("nombre"));
                t.setTipo(rs.getString("tipo"));
                t.setDetalle(rs.getString("detalle"));
                t.setDuracion(rs.getInt("duracion"));
                t.setCosto(rs.getDouble("costo"));
                t.setActivo(rs.getBoolean("activo"));

                // 🔥 Cargar los productos asociados
                t.setProductos(listarProductosDeTratamiento(t));
            }

            ps.close();
        } catch (Exception e) {
            System.out.println("Error al buscar tratamiento: " + e.getMessage());
        }
        return t;
    }

    // baja logica del tratamiento
    public void bajaLogicaTratamiento(Tratamiento t) {
        String query = "UPDATE tratamiento SET activo = false WHERE codTratam = ?";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setInt(1, t.getCodTratam());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al dar de baja tratamiento: " + e.getMessage());
        }
    }

    // alta logica del tratamiento
    public void altaLogicaTratamiento(Tratamiento t) {
        String query = "UPDATE tratamiento SET activo = true WHERE codTratam = ?";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setInt(1, t.getCodTratam());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al dar de alta tratamiento: " + e.getMessage());
        }
    }

    // lista todos los tratamientos activos
    public List<Tratamiento> listarTratamientosActivos() {
        List<Tratamiento> lista = new ArrayList<>();
        String query = "SELECT * FROM tratamiento WHERE activo = 1";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tratamiento t = new Tratamiento();
                t.setCodTratam(rs.getInt("codTratam"));
                t.setNombre(rs.getString("nombre"));
                t.setTipo(rs.getString("tipo"));
                t.setDetalle(rs.getString("detalle"));
                t.setDuracion(rs.getInt("duracion"));
                t.setCosto(rs.getDouble("costo"));
                t.setActivo(rs.getBoolean("activo"));
                lista.add(t);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al listar tratamientos activos: " + e.getMessage());
        }
        return lista;
    }

    public List<Producto> listarProductosDeTratamiento(Tratamiento t) {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT p.codProd, p.nombre, p.tipo, p.precio, p.estado "
                + "FROM producto p "
                + "INNER JOIN tratamiento_producto tp ON p.codProd = tp.codProd "
                + "WHERE tp.codTratam = ? AND p.estado = true";

        try (PreparedStatement ps = conex.prepareStatement(sql)) {
            ps.setInt(1, t.getCodTratam());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto p = new Producto();
                p.setCodProd(rs.getInt("codProd"));
                p.setNombre(rs.getString("nombre"));
                p.setTipo(rs.getString("tipo"));
                p.setPrecio(rs.getDouble("precio"));
                p.setEstado(rs.getBoolean("estado"));
                productos.add(p);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return productos;
    }
}
