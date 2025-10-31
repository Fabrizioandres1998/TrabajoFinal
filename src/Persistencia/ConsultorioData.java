package Persistencia;

import Modelo.Consultorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ConsultorioData {

    private Connection conex = null;

    // Constructor que recibe la clase Conexion
    public ConsultorioData(Conexion con) {
        this.conex = con.obtenerConexion();
    }

    // Guarda un nuevo consultorio
    public void guardarConsultorio(Consultorio c) {
        String query = "INSERT INTO consultorio(usos, equipamiento, apto) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conex.prepareStatement(query, java.sql.Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, c.getUsos());
            ps.setString(2, c.getEquipamiento());
            ps.setBoolean(3, c.isApto());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                c.setNroConsultorio(rs.getInt(1));
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Busca un consultorio por su número
    public Consultorio buscarConsultorio(int nroConsultorio) {
        Consultorio c = null;
        String query = "SELECT * FROM consultorio WHERE nroConsultorio = ?";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setInt(1, nroConsultorio);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                c = new Consultorio();
                c.setNroConsultorio(rs.getInt("nroConsultorio"));
                c.setUsos(rs.getString("usos"));
                c.setEquipamiento(rs.getString("equipamiento"));
                c.setApto(rs.getBoolean("apto"));
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    // Lista todos los consultorios aptos
    public List<Consultorio> listarConsultoriosAptos() {
        List<Consultorio> consultorios = new ArrayList<>();
        String query = "SELECT * FROM consultorio WHERE apto = true";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Consultorio c = new Consultorio();
                c.setNroConsultorio(rs.getInt("nroConsultorio"));
                c.setUsos(rs.getString("usos"));
                c.setEquipamiento(rs.getString("equipamiento"));
                c.setApto(rs.getBoolean("apto"));
                consultorios.add(c);
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return consultorios;
    }

    // Incrementa los usos del consultorio
    public void incrementarUsos(int nroConsultorio) {
        String query = "UPDATE consultorio SET usos = usos + 1 WHERE nroConsultorio = ?";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setInt(1, nroConsultorio);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al incrementar usos: " + e.getMessage());
        }
    }
}
