package Modelo;

public class Producto {

    private int codProd;
    private String nombre;
    private String tipo;
    private double precio;
    private boolean estado;

    // Constructor
    public Producto(int codProd, String nombre, String tipo, double precio, boolean estado) {
        this.codProd = codProd;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.estado = estado;
    }

    public Producto() {
    }

    // Getters y Setters
    public int getCodProd() {
        return codProd;
    }

    public void setCodProd(int codProd) {
        this.codProd = codProd;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    // Método para mostrar información del producto
    @Override
    public String toString() {
        return "Producto{"
                + "codProd=" + codProd
                + ", nombre='" + nombre + '\''
                + ", tipo='" + tipo + '\''
                + ", precio=" + precio
                + ", estado=" + estado
                + '}';
    }
}
