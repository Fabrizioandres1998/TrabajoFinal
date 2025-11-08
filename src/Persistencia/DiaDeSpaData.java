package Persistencia;

import Modelo.DiaDeSpa;
import Modelo.Cliente;
import Modelo.Sesion_turno;
import Persistencia.Conexion;
import static Persistencia.Conexion.con;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DiaDeSpaData {

    private Connection conex = null;
    private Conexion conexion = null;
    private ClienteData clienteData;

    public DiaDeSpaData(Conexion conexion) {
        // inicializa conexion y clienteData
        this.conexion = conexion;
        this.conex = conexion.obtenerConexion();
        this.clienteData = new ClienteData(conexion);
    }

    public DiaDeSpaData() {
        // constructor vacio
    }

    // guarda un nuevo dia de spa en la base de datos
    public void guardarDiaDeSpa(DiaDeSpa d) {
        String query = "INSERT INTO dia_de_spa(fecha_hora, preferencias, codCli, estado, monto) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conex.prepareStatement(query, java.sql.Statement.RETURN_GENERATED_KEYS);
            ps.setTimestamp(1, Timestamp.valueOf(d.getFechaYHora()));
            ps.setString(2, d.getPreferencias());
            ps.setInt(3, d.getCliente().getCodCli());
            ps.setBoolean(4, d.isEstado());
            ps.setDouble(5, d.getMonto());

            ps.executeUpdate();

            // obtiene el id generado automaticamente
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
        DiaDeSpa dia = null;
        String sql = "SELECT * FROM dia_de_spa WHERE codPack = ?";

        try (PreparedStatement ps = conex.prepareStatement(sql)) {
            ps.setInt(1, codPack);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // crea objeto dia y carga sus datos
                dia = new DiaDeSpa();
                dia.setCodPack(rs.getInt("codPack"));
                dia.setFechaYHora(rs.getTimestamp("fecha_Hora").toLocalDateTime());
                dia.setPreferencias(rs.getString("preferencias"));
                dia.setEstado(rs.getBoolean("estado"));
                dia.setMonto(rs.getDouble("monto"));

                // carga cliente asociado
                int idCliente = rs.getInt("codCli");
                ClienteData cd = new ClienteData(this.conexion);
                Cliente cliente = cd.buscarCliente(idCliente);
                dia.setCliente(cliente);

                // carga turnos asociados al dia de spa
                TurnoData turnoData = new TurnoData(this.conexion);
                List<Sesion_turno> turnos = turnoData.listarTurnosPorDiaDeSpa(codPack);
                dia.setSesiones(turnos);
            }

            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al buscar Dia de Spa: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado en buscarDiaDeSpa: " + e.getMessage());
        }

        return dia;
    }

    // actualiza los datos de un dia de spa existente
    public void actualizarDiaDeSpa(DiaDeSpa d) {
        String query = "UPDATE dia_de_spa SET fecha_hora = ?, preferencias = ?, codCli = ?, estado = ?, monto = ? WHERE codPack = ?";

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

        try (PreparedStatement ps = conex.prepareStatement(query); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                DiaDeSpa d = new DiaDeSpa();
                d.setCodPack(rs.getInt("codPack"));
                d.setFechaYHora(rs.getTimestamp("fecha_hora").toLocalDateTime());
                d.setPreferencias(rs.getString("preferencias"));

                // carga cliente asociado
                Cliente cliente = clienteData.buscarCliente(rs.getInt("codCli"));
                d.setCliente(cliente);

                d.setEstado(rs.getBoolean("estado"));

                // carga turnos asociados
                TurnoData turnoData = new TurnoData(this.conexion);
                List<Sesion_turno> turnos = turnoData.listarTurnosPorDiaDeSpa(d.getCodPack());
                d.setSesiones(turnos);

                // calcula monto real segun tratamientos
                double montoCalculado = d.calcularMontoTotal();
                d.setMonto(montoCalculado);

                dias.add(d);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dias;
    }

    // da de baja logica usando codPack
    public void bajaLogicaDiaDeSpa(int codPack) {
        String sql = "UPDATE diadespa SET estado = 0 WHERE codPack = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codPack);
            int filas = ps.executeUpdate();

            if (filas == 0) {
                System.out.println("No se encontro el dia de spa con ese codigo.");
            }

            ps.close();
        } catch (SQLException ex) {
            System.out.println("error al dar de baja el dia de Spa: " + ex.getMessage());
        }
    }

}
