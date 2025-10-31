package Persistencia;

import Modelo.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoData {

    private Connection conex = null;

    // constructor que recibe la conexion
    public ProductoData(Conexion con) {
        this.conex = con.obtenerConexion();
    }

    // constructor vacio
    public ProductoData() {
    }

    // guarda un nuevo producto en la base de datos
    public void guardarProducto(Producto p) {
        String query = "INSERT INTO producto(nombre, tipo, precio, estado) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conex.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getTipo());
            ps.setDouble(3, p.getPrecio());
            ps.setBoolean(4, p.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                p.setCodProd(rs.getInt(1));
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("error al guardar producto: " + e.getMessage());
        }
    }

    // busca un producto por su codigo
    public Producto buscarProducto(int codProd) {
        Producto p = null;
        String query = "SELECT * FROM producto WHERE codProd = ?";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setInt(1, codProd);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                p = new Producto();
                p.setCodProd(rs.getInt("codProd"));
                p.setNombre(rs.getString("nombre"));
                p.setTipo(rs.getString("tipo"));
                p.setPrecio(rs.getDouble("precio"));
                p.setEstado(rs.getBoolean("estado"));
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("error al buscar producto: " + e.getMessage());
        }
        return p;
    }

    // busca un producto por nombre
    public Producto buscarProductoPorNombre(String nombre) {
        Producto p = null;
        String query = "SELECT * FROM producto WHERE LOWER(nombre) = LOWER(?)";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                p = new Producto();
                p.setCodProd(rs.getInt("codProd"));
                p.setNombre(rs.getString("nombre"));
                p.setTipo(rs.getString("tipo"));
                p.setPrecio(rs.getDouble("precio"));
                p.setEstado(rs.getBoolean("estado"));
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("error al buscar producto por nombre: " + e.getMessage());
        }
        return p;
    }

    // actualiza los datos de un producto
    public void actualizarProducto(Producto p) {
        String query = "UPDATE producto SET nombre = ?, tipo = ?, precio = ?, estado = ? WHERE codProd = ?";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getTipo());
            ps.setDouble(3, p.getPrecio());
            ps.setBoolean(4, p.isEstado());
            ps.setInt(5, p.getCodProd());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("error al actualizar producto: " + e.getMessage());
        }
    }

    // elimina fisicamente un producto
    public void bajaFisicaProducto(int codProd) {
        String query = "DELETE FROM producto WHERE codProd = ?";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setInt(1, codProd);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("error al eliminar producto: " + e.getMessage());
        }
    }

    // baja logica del producto
    public void bajaLogicaProducto(Producto p) {
        String query = "UPDATE producto SET estado = false WHERE codProd = ?";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setInt(1, p.getCodProd());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("error al dar de baja logica al producto: " + e.getMessage());
        }
    }

    // alta logica del producto
    public void altaLogicaProducto(Producto p) {
        String query = "UPDATE producto SET estado = true WHERE codProd = ?";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setInt(1, p.getCodProd());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("error al dar de alta logica al producto: " + e.getMessage());
        }
    }

    // lista todos los productos activos
    public List<Producto> listarProductosActivos() {
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT * FROM producto WHERE estado = 1";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
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
            ps.close();
        } catch (Exception e) {
            System.out.println("error al listar productos activos: " + e.getMessage());
        }
        return productos;
    }
}
