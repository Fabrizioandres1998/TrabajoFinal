package Modelo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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

    public double calcularMontoTotal() {
        double total = 0.0;

        if (sesiones != null) {
            for (Sesion_turno sesion : sesiones) {
                double costoTurno = 0.0;

                // costo base del tratamiento
                if (sesion.getTratamiento() != null) {
                    costoTurno += sesion.getTratamiento().getCosto();
                }

                // sumar costp de productos usados (si existen)
                if (sesion.getTratamiento() != null && sesion.getTratamiento().getProductos() != null) {
                    for (Producto p : sesion.getTratamiento().getProductos()) {
                        costoTurno += p.getPrecio();
                    }
                }

                // sumar el costo del turno al total gral
                total += costoTurno;
            }
        }

        this.monto = total;
        return total;
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
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.codPack;
        hash = 59 * hash + Objects.hashCode(this.fechaYHora);
        hash = 59 * hash + Objects.hashCode(this.preferencias);
        hash = 59 * hash + Objects.hashCode(this.cliente);
        hash = 59 * hash + (this.estado ? 1 : 0);
        hash = 59 * hash + Objects.hashCode(this.sesiones);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.monto) ^ (Double.doubleToLongBits(this.monto) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DiaDeSpa other = (DiaDeSpa) obj;
        if (this.codPack != other.codPack) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        if (Double.doubleToLongBits(this.monto) != Double.doubleToLongBits(other.monto)) {
            return false;
        }
        if (!Objects.equals(this.preferencias, other.preferencias)) {
            return false;
        }
        if (!Objects.equals(this.fechaYHora, other.fechaYHora)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        return Objects.equals(this.sesiones, other.sesiones);
    }

    @Override
    public String toString() {
        return "Día de Spa N° " + codPack;
    }
}
