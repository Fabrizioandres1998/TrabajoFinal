package Modelo;

public class Instalacion {
    private int codInstal;
    private String nombre;
    private String detalle_de_uso;
    private double precio30m; // Precio por 30 minutos de uso
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
    public String toString() {
        return codInstal + " - " + nombre;
    }
}
