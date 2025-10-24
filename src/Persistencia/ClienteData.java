package Persistencia;

import Modelo.Cliente;
import Persistencia.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Connection;

public class ClienteData {

    private Connection conex = null;

    public ClienteData(Conexion con) {
        this.conex = con.obtenerConexion();
    }

    public ClienteData() {
    }

    public void guardarCliente(Cliente c) {
        String query = "INSERT INTO cliente(dni, nombre_completo, telefono, edad, afecciones, estado) \n"
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conex.prepareStatement(query, java.sql.Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, c.getDni());                // int
            ps.setString(2, c.getNombreCompleto());  // String
            ps.setString(3, String.valueOf(c.getTelefono())); // Convertir a String
            ps.setInt(4, c.getEdad());               // int
            ps.setString(5, c.getAfecciones());      // String
            ps.setBoolean(6, c.isEstado());          // boolean

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                c.setCodCli(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Cliente buscarCliente(int codCli) {
        Cliente c = null;
        String query = "SELECT * FROM cliente WHERE codCli = ?"; //armar query

        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setInt(1, codCli);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                c = new Cliente();
                c.setCodCli(rs.getInt("codCli"));
                c.setDni(rs.getInt("dni"));
                c.setNombreCompleto(rs.getString("nombreCompleto"));
                c.setTelefono(rs.getLong("telefono"));
                c.setEdad(rs.getInt("edad"));
                c.setAfecciones(rs.getString("afecciones"));
                c.setEstado(rs.getBoolean("estado"));
            }
            ps.close();

        } catch (Exception e) {
        }
        return c;
    }
}
