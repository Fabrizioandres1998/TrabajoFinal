package Modelo;

import java.util.Objects;

public class Instalacion {

    private int codInstal;
    private String nombre;
    private String detalle_de_uso;
    private double precio30m;
    private boolean estado;

    public Instalacion() {
    }

    public Instalacion(String nombre, String detalle_de_uso, double precio30m, boolean estado) {
        this.nombre = nombre;
        this.detalle_de_uso = detalle_de_uso;
        this.precio30m = precio30m;
        this.estado = estado;
    }

    public Instalacion(int codInstal, String nombre, String detalle_de_uso, double precio30m, boolean estado) {
        this.codInstal = codInstal;
        this.nombre = nombre;
        this.detalle_de_uso = detalle_de_uso;
        this.precio30m = precio30m;
        this.estado = estado;
    }

    public int getCodInstal() {
        return codInstal;
    }

    public void setCodInstal(int codInstal) {
        this.codInstal = codInstal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getdetalle_de_uso() {
        return detalle_de_uso;
    }

    public void setdetalle_de_uso(String detalle_de_uso) {
        this.detalle_de_uso = detalle_de_uso;
    }

    public double getPrecio30m() {
        return precio30m;
    }

    public void setPrecio30m(double precio30m) {
        this.precio30m = precio30m;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.codInstal;
        hash = 89 * hash + Objects.hashCode(this.nombre);
        hash = 89 * hash + Objects.hashCode(this.detalle_de_uso);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.precio30m) ^ (Double.doubleToLongBits(this.precio30m) >>> 32));
        hash = 89 * hash + (this.estado ? 1 : 0);
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
        final Instalacion other = (Instalacion) obj;
        if (this.codInstal != other.codInstal) {
            return false;
        }
        if (Double.doubleToLongBits(this.precio30m) != Double.doubleToLongBits(other.precio30m)) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.detalle_de_uso, other.detalle_de_uso);
    }

    @Override
    public String toString() {
        return codInstal + " - " + nombre;
    }
}
