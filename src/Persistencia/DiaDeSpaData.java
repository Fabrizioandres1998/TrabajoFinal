package Persistencia;

import Modelo.DiaDeSpa;
import Modelo.Cliente;
import Persistencia.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DiaDeSpaData {

    private Connection conex = null;
    private ClienteData clienteData;

    public DiaDeSpaData(Conexion con) {
        this.conex = con.obtenerConexion();
        this.clienteData = new ClienteData(con);
    }

    public DiaDeSpaData() {
    }

    // guarda un nuevo dia de spa
    public void guardarDiaDeSpa(DiaDeSpa d) {
        String query = "INSERT INTO dia_de_spa(fecha_y_hora, preferencias, codCli, estado, monto) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conex.prepareStatement(query, java.sql.Statement.RETURN_GENERATED_KEYS);
            ps.setTimestamp(1, Timestamp.valueOf(d.getFechaYHora()));
            ps.setString(2, d.getPreferencias());
            ps.setInt(3, d.getCliente().getCodCli());
            ps.setBoolean(4, d.isEstado());
            ps.setDouble(5, d.getMonto());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                d.setCodPack(rs.getInt(1));
            }

            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // busca un dia de spa por codigo
    public DiaDeSpa buscarDiaDeSpa(int codPack) {
        DiaDeSpa d = null;
        String query = "SELECT * FROM dia_de_spa WHERE codPack = ?";

        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setInt(1, codPack);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                d = new DiaDeSpa();
                d.setCodPack(rs.getInt("codPack"));
                d.setFechaYHora(rs.getTimestamp("fecha_y_hora").toLocalDateTime());
                d.setPreferencias(rs.getString("preferencias"));
                Cliente cliente = clienteData.buscarCliente(rs.getInt("codCli"));
                d.setCliente(cliente);
                d.setEstado(rs.getBoolean("estado"));
                d.setMonto(rs.getDouble("monto"));
            }

            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    // actualiza los datos de un dia de spa existente
    public void actualizarDiaDeSpa(DiaDeSpa d) {
        String query = "UPDATE dia_de_spa SET fecha_y_hora = ?, preferencias = ?, codCli = ?, estado = ?, monto = ? WHERE codPack = ?";

        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setTimestamp(1, Timestamp.valueOf(d.getFechaYHora()));
            ps.setString(2, d.getPreferencias());
            ps.setInt(3, d.getCliente().getCodCli());
            ps.setBoolean(4, d.isEstado());
            ps.setDouble(5, d.getMonto());
            ps.setInt(6, d.getCodPack());

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // elimina fisicamente un dia de spa
    public void bajaFisicaDiaDeSpa(int codPack) {
        String query = "DELETE FROM dia_de_spa WHERE codPack = ?";

        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setInt(1, codPack);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // da de baja logica (marca estado en false)
    public void bajaLogicaDiaDeSpa(DiaDeSpa d) {
        String query = "UPDATE dia_de_spa SET estado = false WHERE codPack = ?";

        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setInt(1, d.getCodPack());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // da de alta logica (marca estado en true)
    public void altaLogicaDiaDeSpa(DiaDeSpa d) {
        String query = "UPDATE dia_de_spa SET estado = true WHERE codPack = ?";

        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setInt(1, d.getCodPack());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // lista todos los dias de spa activos
    public List<DiaDeSpa> listarDiasDeSpaActivos() {
        List<DiaDeSpa> dias = new ArrayList<>();
        String query = "SELECT * FROM dia_de_spa WHERE estado = true";

        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DiaDeSpa d = new DiaDeSpa();
                d.setCodPack(rs.getInt("codPack"));
                d.setFechaYHora(rs.getTimestamp("fecha_y_hora").toLocalDateTime());
                d.setPreferencias(rs.getString("preferencias"));
                Cliente cliente = clienteData.buscarCliente(rs.getInt("codCli"));
                d.setCliente(cliente);
                d.setEstado(rs.getBoolean("estado"));
                d.setMonto(rs.getDouble("monto"));
                dias.add(d);
            }

            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dias;
    }
}
