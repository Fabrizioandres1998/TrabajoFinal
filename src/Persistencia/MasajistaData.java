package Persistencia;

import Modelo.Masajista;
import Persistencia.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MasajistaData {

    private Connection conex = null;

    // constructor que recibe la conexion
    public MasajistaData(Conexion con) {
        this.conex = con.obtenerConexion();
    }

    // constructor vacio
    public MasajistaData() {
    }

    // guarda un nuevo masajista
    public void guardarMasajista(Masajista m) {
        String query = "INSERT INTO masajista (matricula, nombre_apellido, telefono, especialidad, estado) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setString(1, m.getMatricula());
            ps.setString(2, m.getNombreYApellido());
            ps.setString(3, m.getTelefono());
            ps.setString(4, m.getEspecialidad());
            ps.setBoolean(5, m.isEstado());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("error al guardar masajista: " + e.getMessage());
        }
    }

    // busca un masajista por matricula
    public Masajista buscarMasajista(String matricula) {
        Masajista m = null;
        String query = "SELECT * FROM masajista WHERE matricula = ?";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setString(1, matricula);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                m = new Masajista();
                m.setMatricula(rs.getString("matricula"));
                m.setNombreYApellido(rs.getString("nombre_apellido"));
                m.setTelefono(rs.getString("telefono"));
                m.setEspecialidad(rs.getString("especialidad"));
                m.setEstado(rs.getBoolean("estado"));
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("error al buscar masajista: " + e.getMessage());
        }
        return m;
    }

    // actualiza los datos de un masajista
    public void actualizarMasajista(Masajista m) {
        String query = "UPDATE masajista SET nombre_apellido = ?, telefono = ?, especialidad = ?, estado = ? WHERE matricula = ?";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setString(1, m.getNombreYApellido());
            ps.setString(2, m.getTelefono());
            ps.setString(3, m.getEspecialidad());
            ps.setBoolean(4, m.isEstado());
            ps.setString(5, m.getMatricula());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("error al actualizar masajista: " + e.getMessage());
        }
    }

    // cambia el estado a inactivo
    public void bajaLogicaMasajista(Masajista m) {
        String query = "UPDATE masajista SET estado = false WHERE matricula = ?";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setString(1, m.getMatricula());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("error al dar de baja masajista: " + e.getMessage());
        }
    }

    // cambia el estado a activo
    public void altaLogicaMasajista(Masajista m) {
        String query = "UPDATE masajista SET estado = true WHERE matricula = ?";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setString(1, m.getMatricula());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("error al dar de alta masajista: " + e.getMessage());
        }
    }

    // lista todos los masajistas activos
    public List<Masajista> listarMasajistasActivos() {
        List<Masajista> lista = new ArrayList<>();
        String query = "SELECT * FROM masajista WHERE estado = 1";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Masajista m = new Masajista();
                m.setMatricula(rs.getString("matricula"));
                m.setNombreYApellido(rs.getString("nombre_apellido"));
                m.setTelefono(rs.getString("telefono"));
                m.setEspecialidad(rs.getString("especialidad"));
                m.setEstado(rs.getBoolean("estado"));
                lista.add(m);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("error al listar masajistas activos: " + e.getMessage());
        }
        return lista;
    }

    public void bajaFisicaMasajista(String matricula) {
        String query = "DELETE FROM masajista WHERE matricula = ?";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setString(1, matricula);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("error al eliminar masajista: " + e.getMessage());
        }
    }
}
