package Modelo;

import java.time.LocalDateTime;
import java.util.List;

public class DiaDeSpa {

    private int codPack;
    private LocalDateTime fechaYHora;
    private String preferencias;
    private Cliente cliente;
    private boolean estado; 
    private List<Sesion_turno> sesiones;
    private double monto;

    public DiaDeSpa() {
    }

    public DiaDeSpa(LocalDateTime fechaYHora, String preferencias, Cliente cliente, boolean estado, List<Sesion_turno> sesiones, double monto) {
        this.fechaYHora = fechaYHora;
        this.preferencias = preferencias;
        this.cliente = cliente;
        this.estado = estado;
        this.sesiones = sesiones;
        this.monto = monto;
    }

    public DiaDeSpa(int codPack, LocalDateTime fechaYHora, String preferencias, Cliente cliente, boolean estado, List<Sesion_turno> sesiones, double monto) {
        this.codPack = codPack;
        this.fechaYHora = fechaYHora;
        this.preferencias = preferencias;
        this.cliente = cliente;
        this.estado = estado;
        this.sesiones = sesiones;
        this.monto = monto;
    }

    
    public int getCodPack() {
        return codPack;
    }

    public void setCodPack(int codPack) {
        this.codPack = codPack;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public String getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<Sesion_turno> getSesiones() {
        return sesiones;
    }

    public void setSesiones(List<Sesion_turno> sesiones) {
        this.sesiones = sesiones;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    
    public void activar() {
        this.estado = true;
    }

    
    public void desactivar() {
        this.estado = false;
    }

    @Override
    public String toString() {
        String estadoStr = estado ? "Activo" : "Inactivo";
        return "dia  de Spa N° " + codPack + " | Cliente: " 
                + (cliente != null ? cliente.getNombreCompleto() : "Sin asignar")
                + " | Fecha: " + (fechaYHora != null ? fechaYHora.toLocalDate() : "-")
                + " | Estado: " + estadoStr;
    }
}