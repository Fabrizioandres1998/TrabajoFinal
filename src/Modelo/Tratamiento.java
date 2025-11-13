package Modelo;

import java.util.List;
import java.util.Objects;

public class Tratamiento {

    private int codTratam;
    private String nombre;
    private String tipo;
    private String detalle;
    private List<Producto> productos;
    private int duracion;
    private double costo;
    private boolean activo;

    public Tratamiento() {
    }

    public Tratamiento(String nombre, String tipo, String detalle, List<Producto> productos, int duracion, double costo, boolean activo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.detalle = detalle;
        this.productos = productos;
        this.duracion = duracion;
        this.costo = costo;
        this.activo = activo;
    }

    public int getCodTratam() {
        return codTratam;
    }

    public void setCodTratam(int codTratam) {
        this.codTratam = codTratam;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracionMinutos) {
        this.duracion = duracionMinutos;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.codTratam;
        hash = 41 * hash + Objects.hashCode(this.nombre);
        hash = 41 * hash + Objects.hashCode(this.tipo);
        hash = 41 * hash + Objects.hashCode(this.detalle);
        hash = 41 * hash + Objects.hashCode(this.productos);
        hash = 41 * hash + this.duracion;
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.costo) ^ (Double.doubleToLongBits(this.costo) >>> 32));
        hash = 41 * hash + (this.activo ? 1 : 0);
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
        final Tratamiento other = (Tratamiento) obj;
        if (this.codTratam != other.codTratam) {
            return false;
        }
        if (this.duracion != other.duracion) {
            return false;
        }
        if (Double.doubleToLongBits(this.costo) != Double.doubleToLongBits(other.costo)) {
            return false;
        }
        if (this.activo != other.activo) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.detalle, other.detalle)) {
            return false;
        }
        return Objects.equals(this.productos, other.productos);
    }

    @Override
    public String toString() {
        return getCodTratam()+ " - " + getNombre();
    }

}
