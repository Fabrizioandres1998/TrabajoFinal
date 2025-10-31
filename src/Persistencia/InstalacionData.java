package Persistencia;

import Modelo.Instalacion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstalacionData {

    private Connection conex = null;

    public InstalacionData(Conexion con) {
        conex = con.obtenerConexion();
    }

    public void guardarInstalacion(Instalacion i) {
        String sql = "INSERT INTO instalacion (nombre, detalle_de_uso, precio30m, estado) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, i.getNombre());
            ps.setString(2, i.getdetalle_de_uso());
            ps.setDouble(3, i.getPrecio30m());
            ps.setBoolean(4, i.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                i.setCodInstal(rs.getInt(1));
            }
            ps.close();
            System.out.println("Instalación guardada correctamente.");
        } catch (SQLException ex) {
            System.out.println("Error al guardar instalación: " + ex.getMessage());
        }
    }

    public void actualizarInstalacion(Instalacion i) {
        String sql = "UPDATE instalacion SET nombre=?, detalle_de_uso=?, precio30m=?, estado=? WHERE codInstal=?";
        try {
            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setString(1, i.getNombre());
            ps.setString(2, i.getdetalle_de_uso());
            ps.setDouble(3, i.getPrecio30m());
            ps.setBoolean(4, i.isEstado());
            ps.setInt(5, i.getCodInstal());
            ps.executeUpdate();
            ps.close();
            System.out.println("Instalación actualizada correctamente.");
        } catch (SQLException ex) {
            System.out.println("Error al actualizar instalación: " + ex.getMessage());
        }
    }

    public Instalacion buscarInstalacion(int codInstal) {
        Instalacion i = null;
        String sql = "SELECT * FROM instalacion WHERE codInstal=?";
        try {
            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setInt(1, codInstal);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                i = new Instalacion();
                i.setCodInstal(rs.getInt("codInstal"));
                i.setNombre(rs.getString("nombre"));
                i.setdetalle_de_uso(rs.getString("detalle_de_uso"));
                i.setPrecio30m(rs.getDouble("precio30m"));
                i.setEstado(rs.getBoolean("estado"));
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar instalación: " + ex.getMessage());
        }
        return i;
    }

    public List<Instalacion> listarInstalaciones() {
        List<Instalacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM instalacion";
        try {
            PreparedStatement ps = conex.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Instalacion i = new Instalacion();
                i.setCodInstal(rs.getInt("codInstal"));
                i.setNombre(rs.getString("nombre"));
                i.setdetalle_de_uso(rs.getString("detalle_de_uso"));
                i.setPrecio30m(rs.getDouble("precio30m"));
                i.setEstado(rs.getBoolean("estado"));
                lista.add(i);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al listar instalaciones: " + ex.getMessage());
        }
        return lista;
    }

    public void eliminarInstalacion(int codInstal) {
        String sql = "UPDATE instalacion SET estado=0 WHERE codInstal=?";
        try {
            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setInt(1, codInstal);
            ps.executeUpdate();
            ps.close();
            System.out.println("Instalación eliminada (estado = 0).");
        } catch (SQLException ex) {
            System.out.println("Error al eliminar instalación: " + ex.getMessage());
        }
    }
}
