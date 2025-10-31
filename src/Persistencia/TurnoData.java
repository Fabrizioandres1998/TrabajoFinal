package Persistencia;

import Modelo.Sesion_turno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TurnoData {

    private Connection conex = null;
    private Conexion conexion; // Guardamos la referencia a Conexion

    // Constructor que recibe la Conexion
    public TurnoData(Conexion con) {
        this.conexion = con;
        this.conex = con.obtenerConexion();
    }

    // Constructor vacío
    public TurnoData() {
    }

    // Guarda un nuevo turno
    public void guardarTurno(Sesion_turno t) {
        String query = "INSERT INTO turno (fecha_inicio, fecha_fin, cod_tratam, nro_consultorio, matricula, cod_pack, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conex.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setTimestamp(1, Timestamp.valueOf(t.getFechaHoraInicio()));
            ps.setTimestamp(2, Timestamp.valueOf(t.getFechaHoraFin()));
            ps.setInt(3, t.getTratamiento().getCodTratam());
            ps.setInt(4, t.getConsultorio().getNroConsultorio());
            ps.setString(5, t.getMasajista().getMatricula());
            ps.setInt(6, t.getDiaDeSpa().getCodPack());
            ps.setBoolean(7, t.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                t.setCodSesion(rs.getInt(1));
            }
            ps.close();

            // Incrementar los usos del consultorio
            if (this.conexion != null) {
                ConsultorioData cData = new ConsultorioData(this.conexion);
                cData.incrementarUsos(t.getConsultorio().getNroConsultorio());
            }

        } catch (Exception e) {
            System.out.println("Error al guardar turno: " + e.getMessage());
        }
    }

    // Busca un turno por código
    public Sesion_turno buscarTurno(int codSesion) {
        Sesion_turno t = null;
        String query = "SELECT * FROM turno WHERE cod_sesion = ?";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setInt(1, codSesion);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                t = new Sesion_turno();
                t.setCodSesion(rs.getInt("cod_sesion"));
                t.setFechaHoraInicio(rs.getTimestamp("fecha_inicio").toLocalDateTime());
                t.setFechaHoraFin(rs.getTimestamp("fecha_fin").toLocalDateTime());
                t.setEstado(rs.getBoolean("estado"));
                // tratamiento, consultorio, masajista y diaDeSpa deberían buscarse vía sus códigos
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al buscar turno: " + e.getMessage());
        }
        return t;
    }

    // Actualiza un turno existente
    public void actualizarTurno(Sesion_turno t) {
        String query = "UPDATE turno SET fecha_inicio = ?, fecha_fin = ?, cod_tratam = ?, nro_consultorio = ?, matricula = ?, cod_pack = ?, estado = ? WHERE cod_sesion = ?";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setTimestamp(1, Timestamp.valueOf(t.getFechaHoraInicio()));
            ps.setTimestamp(2, Timestamp.valueOf(t.getFechaHoraFin()));
            ps.setInt(3, t.getTratamiento().getCodTratam());
            ps.setInt(4, t.getConsultorio().getNroConsultorio());
            ps.setString(5, t.getMasajista().getMatricula());
            ps.setInt(6, t.getDiaDeSpa().getCodPack());
            ps.setBoolean(7, t.isEstado());
            ps.setInt(8, t.getCodSesion());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al actualizar turno: " + e.getMessage());
        }
    }

    // Baja lógica del turno
    public void bajaLogicaTurno(Sesion_turno t) {
        String query = "UPDATE turno SET estado = false WHERE cod_sesion = ?";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setInt(1, t.getCodSesion());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al dar de baja turno: " + e.getMessage());
        }
    }

    // Alta lógica del turno
    public void altaLogicaTurno(Sesion_turno t) {
        String query = "UPDATE turno SET estado = true WHERE cod_sesion = ?";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setInt(1, t.getCodSesion());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al dar de alta turno: " + e.getMessage());
        }
    }

    // Lista todos los turnos activos
    public List<Sesion_turno> listarTurnosActivos() {
        List<Sesion_turno> lista = new ArrayList<>();
        String query = "SELECT * FROM turno WHERE estado = 1";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sesion_turno t = new Sesion_turno();
                t.setCodSesion(rs.getInt("cod_sesion"));
                t.setFechaHoraInicio(rs.getTimestamp("fecha_inicio").toLocalDateTime());
                t.setFechaHoraFin(rs.getTimestamp("fecha_fin").toLocalDateTime());
                t.setEstado(rs.getBoolean("estado"));
                // tratamiento, consultorio, masajista y diaDeSpa deberían buscarse por sus códigos
                lista.add(t);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al listar turnos activos: " + e.getMessage());
        }
        return lista;
    }
}
