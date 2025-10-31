package Persistencia;

import Modelo.Cliente;
import Persistencia.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ClienteData {

    private Connection conex = null;

    // constructor que recibe la conexion
    public ClienteData(Conexion con) {
        this.conex = con.obtenerConexion();
    }

    // constructor vacio
    public ClienteData() {
    }

    // guarda un nuevo cliente en la base de datos
    public void guardarCliente(Cliente c) {
        String query = "INSERT INTO cliente(dni, nombre_completo, telefono, edad, afecciones, estado) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conex.prepareStatement(query, java.sql.Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, c.getDni());
            ps.setString(2, c.getNombreCompleto());
            ps.setString(3, String.valueOf(c.getTelefono()));
            ps.setInt(4, c.getEdad());
            ps.setString(5, c.getAfecciones());
            ps.setBoolean(6, c.getEstado());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                c.setCodCli(rs.getInt(1));
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("error al guardar cliente: " + e.getMessage());
        }
    }

    // busca un cliente por su codigo
    public Cliente buscarCliente(int codCli) {
        Cliente c = null;
        String query = "SELECT * FROM cliente WHERE codCli = ?";

        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setInt(1, codCli);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                c = new Cliente();
                c.setCodCli(rs.getInt("codCli"));
                c.setDni(rs.getInt("dni"));
                c.setNombreCompleto(rs.getString("nombre_completo"));
                c.setTelefono(rs.getLong("telefono"));
                c.setEdad(rs.getInt("edad"));
                c.setAfecciones(rs.getString("afecciones"));
                c.setEstado(rs.getBoolean("estado"));
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("error al buscar cliente: " + e.getMessage());
        }
        return c;
    }

    // actualiza los datos de un cliente
    public void actualizarCliente(Cliente c) {
        String query = "UPDATE cliente SET dni = ?, nombre_completo = ?, telefono = ?, edad = ?, afecciones = ?, estado = ? "
                + "WHERE codCli = ?";

        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setInt(1, c.getDni());
            ps.setString(2, c.getNombreCompleto());
            ps.setLong(3, c.getTelefono());
            ps.setInt(4, c.getEdad());
            ps.setString(5, c.getAfecciones());
            ps.setBoolean(6, c.getEstado());
            ps.setInt(7, c.getCodCli());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("error al actualizar cliente: " + e.getMessage());
        }
    }

    // elimina fisicamente un cliente de la base de datos
    public void bajaFisicaCliente(int codCli) {
        String query = "DELETE FROM cliente WHERE codCli = ?";

        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setInt(1, codCli);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("error al eliminar cliente: " + e.getMessage());
        }
    }

    // cambia el estado del cliente a inactivo
    public void bajaLogicaCliente(Cliente c) {
        String query = "UPDATE cliente SET estado = false WHERE codCli = ?";

        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setInt(1, c.getCodCli());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("error al dar de baja logica al cliente: " + e.getMessage());
        }
    }

    // cambia el estado del cliente a activo
    public void altaLogicaCliente(Cliente c) {
        String query = "UPDATE cliente SET estado = true WHERE codCli = ?";

        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setInt(1, c.getCodCli());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("error al dar de alta logica al cliente: " + e.getMessage());
        }
    }

    // lista todos los clientes activos
    public List<Cliente> listarClientesActivos() {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM cliente WHERE estado = 1";

        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCodCli(rs.getInt("codCli"));
                c.setDni(rs.getInt("dni"));
                c.setNombreCompleto(rs.getString("nombre_completo"));
                c.setTelefono(rs.getLong("telefono"));
                c.setEdad(rs.getInt("edad"));
                c.setAfecciones(rs.getString("afecciones"));
                c.setEstado(rs.getBoolean("estado"));
                clientes.add(c);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("error al listar clientes activos: " + e.getMessage());
        }
        return clientes;
    }
}
