package Persistencia;

import Modelo.Cliente;
import Modelo.DiaDeSpa;
import Modelo.Instalacion;
import Modelo.Sesion_turno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TurnoData {

    private Connection conex = null;
    private Conexion conexion; // guarda la referencia a Conexion

    // constructor que recibe un objeto Conexion
    public TurnoData(Conexion con) {
        this.conexion = con;
        this.conex = con.obtenerConexion();
    }

    public TurnoData() {
        // constructor vacio
    }

    // guarda un nuevo turno en la base de datos
    public void guardarTurno(Sesion_turno turno) {
        String sql = "INSERT INTO sesion_turno "
                + "(fecha_hora_inicio, fecha_hora_fin, codTratam, nroConsultorio, matricula, codInstal, codPack, estado) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // asigna fecha y hora
            pst.setTimestamp(1, Timestamp.valueOf(turno.getFechaHoraInicio()));
            pst.setTimestamp(2, Timestamp.valueOf(turno.getFechaHoraFin()));

            // asigna claves foraneas
            pst.setInt(3, turno.getTratamiento().getCodTratam());
            pst.setInt(4, turno.getConsultorio().getNroConsultorio());
            pst.setInt(5, Integer.parseInt(turno.getMasajista().getMatricula()));

            // solo permite una instalacion
            List<?> instalaciones = turno.getInstalaciones();
            if (instalaciones == null || instalaciones.isEmpty()) {
                throw new Exception("Debe seleccionar al menos una instalacion");
            }
            pst.setInt(6, ((Instalacion) instalaciones.get(0)).getCodInstal());

            pst.setInt(7, turno.getDiaDeSpa().getCodPack());
            pst.setBoolean(8, turno.isEstado());

            pst.executeUpdate();

            // obtiene el id generado automaticamente
            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                turno.setCodSesion(rs.getInt(1));
            }

            System.out.println("Turno guardado correctamente con ID: " + turno.getCodSesion());

        } catch (SQLException ex) {
            System.out.println("Error al guardar turno: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    // actualiza un turno existente
    public void actualizarTurno(Sesion_turno t) {
        String query = "UPDATE sesion_turno SET fecha_hora_inicio = ?, fecha_hora_fin = ?, codTratam = ?, nroConsultorio = ?, matricula = ?, codPack  = ?, estado = ? WHERE codSesion  = ?";
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

    // baja logica del turno (estado = false)
    public void bajaLogicaTurno(Sesion_turno t) {
        String query = "UPDATE sesion_turno SET estado = false WHERE codSesion  = ?";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setInt(1, t.getCodSesion());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al dar de baja turno: " + e.getMessage());
        }
    }

    // alta logica del turno (estado = true)
    public void altaLogicaTurno(Sesion_turno t) {
        String query = "UPDATE sesion_turno SET estado = true WHERE codSesion  = ?";
        try {
            PreparedStatement ps = conex.prepareStatement(query);
            ps.setInt(1, t.getCodSesion());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al dar de alta turno: " + e.getMessage());
        }
    }

    // lista todos los turnos activos
    public List<Sesion_turno> listarTurnosActivos() {
        List<Sesion_turno> lista = new ArrayList<>();
        String sql = "SELECT codSesion FROM sesion_turno WHERE estado = 1";

        try (PreparedStatement ps = conex.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Sesion_turno turno = buscarTurno(rs.getInt("codSesion"));
                if (turno != null) {
                    lista.add(turno);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al listar turnos activos: " + e.getMessage());
        }

        return lista;
    }

    // elimina un turno fisicamente
    public void eliminarTurno(int codSesion) {
        String query = "DELETE FROM sesion_turno WHERE codSesion = ?";
        try (PreparedStatement ps = conex.prepareStatement(query)) {
            ps.setInt(1, codSesion);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Turno eliminado fisicamente correctamente.");
            } else {
                System.out.println("No se encontro el turno con codSesion = " + codSesion);
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar turno: " + e.getMessage());
        }
    }

    // busca un turno por codigo
    public Sesion_turno buscarTurno(int codSesion) {
        Sesion_turno turno = null;
        String sql = "SELECT * FROM sesion_turno WHERE codSesion = ?";
        try {
            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setInt(1, codSesion);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                turno = new Sesion_turno();
                turno.setCodSesion(rs.getInt("codSesion"));
                turno.setFechaHoraInicio(rs.getTimestamp("fecha_hora_inicio").toLocalDateTime());
                turno.setFechaHoraFin(rs.getTimestamp("fecha_hora_fin").toLocalDateTime());
                turno.setEstado(rs.getBoolean("estado"));

                // carga objetos relacionados via sus respectivos Data
                turno.setTratamiento(new TratamientoData(conexion).buscarTratamiento(rs.getInt("codTratam")));
                turno.setConsultorio(new ConsultorioData(conexion).buscarConsultorio(rs.getInt("nroConsultorio")));
                turno.setMasajista(new MasajistaData(conexion).buscarMasajista(rs.getString("matricula")));

                DiaDeSpa dia = new DiaDeSpa();
                dia.setCodPack(rs.getInt("codPack"));
                turno.setDiaDeSpa(dia);

                InstalacionData id = new InstalacionData(conexion);
                List<Instalacion> instalaciones = new ArrayList<>();
                instalaciones.add(id.buscarInstalacion(rs.getInt("codInstal")));
                turno.setInstalaciones(instalaciones);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al buscar turno: " + e.getMessage());
        }
        return turno;
    }

    // lista todos los turnos de un dia de spa
    public List<Sesion_turno> listarTurnosPorDiaDeSpa(int codPack) {
        List<Sesion_turno> turnos = new ArrayList<>();
        String sql = "SELECT codSesion FROM sesion_turno WHERE codPack = ?";

        try (PreparedStatement ps = conex.prepareStatement(sql)) {
            ps.setInt(1, codPack);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Sesion_turno turno = buscarTurno(rs.getInt("codSesion"));
                if (turno != null) {
                    turnos.add(turno);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al listar turnos del Dia de Spa: " + e.getMessage());
        }

        return turnos;
    }
}
