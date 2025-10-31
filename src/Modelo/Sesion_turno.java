package Modelo;

import java.time.LocalDateTime;
import java.util.List;

public class Sesion_turno {

    private int codSesion;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private Tratamiento tratamiento;
    private Consultorio consultorio;
    private Masajista masajista;
    private List<Instalacion> instalaciones;
    private DiaDeSpa diaDeSpa;
    private boolean estado;

    public Sesion_turno() {
    }

    public Sesion_turno(LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, Tratamiento tratamiento, Consultorio consultorio, Masajista masajista, List<Instalacion> instalaciones, DiaDeSpa diaDeSpa, boolean estado) {
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.tratamiento = tratamiento;
        this.consultorio = consultorio;
        this.masajista = masajista;
        this.instalaciones = instalaciones;
        this.diaDeSpa = diaDeSpa;
        this.estado = estado;
    }

    public Sesion_turno(int codSesion, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, Tratamiento tratamiento, Consultorio consultorio, Masajista masajista, List<Instalacion> instalaciones, DiaDeSpa diaDeSpa, boolean estado) {
        this.codSesion = codSesion;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.tratamiento = tratamiento;
        this.consultorio = consultorio;
        this.masajista = masajista;
        this.instalaciones = instalaciones;
        this.diaDeSpa = diaDeSpa;
        this.estado = estado;
    }

    public int getCodSesion() {
        return codSesion;
    }

    public void setCodSesion(int codSesion) {
        this.codSesion = codSesion;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    public Masajista getMasajista() {
        return masajista;
    }

    public void setMasajista(Masajista masajista) {
        this.masajista = masajista;
    }

    public List<Instalacion> getInstalaciones() {
        return instalaciones;
    }

    public void setInstalaciones(List<Instalacion> instalaciones) {
        this.instalaciones = instalaciones;
    }

    public DiaDeSpa getDiaDeSpa() {
        return diaDeSpa;
    }

    public void setDiaDeSpa(DiaDeSpa diaDeSpa) {
        this.diaDeSpa = diaDeSpa;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
