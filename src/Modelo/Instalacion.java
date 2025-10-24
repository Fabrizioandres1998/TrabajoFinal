/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Fabrizio
 */
public class Instalacion {
    private int codInstal;
    private String nombre;
    private String detalleDeUso;
    private double precio30m; // Precio por 30 minutos de uso
    private boolean estado;

    
    public Instalacion() {
    }

    
    public Instalacion(String nombre, String detalleDeUso, double precio30m, boolean estado) {
        this.nombre = nombre;
        this.detalleDeUso = detalleDeUso;
        this.precio30m = precio30m;
        this.estado = estado;
    }
    
    
    public Instalacion(int codInstal, String nombre, String detalleDeUso, double precio30m, boolean estado) {
        this.codInstal = codInstal;
        this.nombre = nombre;
        this.detalleDeUso = detalleDeUso;
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

    public String getDetalleDeUso() {
        return detalleDeUso;
    }

    public void setDetalleDeUso(String detalleDeUso) {
        this.detalleDeUso = detalleDeUso;
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
