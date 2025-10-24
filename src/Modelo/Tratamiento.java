/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.List;
/**
 *
 * @author Fabrizio
 */
public class Tratamiento {
    private int codTratam;
    private String nombre;
    private String tipo; 
    private String detalle;
    private List<String> productos; 
    private int duracionMinutos; 
    private double costo;
    private boolean activo;

    
    public Tratamiento() {
    }

    
    public Tratamiento(String nombre, String tipo, String detalle, List<String> productos, int duracionMinutos, double costo, boolean activo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.detalle = detalle;
        this.productos = productos;
        this.duracionMinutos = duracionMinutos;
        this.costo = costo;
        this.activo = activo;
    }
    
    
    public Tratamiento(int codTratam, String nombre, String tipo, String detalle, List<String> productos, int duracionMinutos, double costo, boolean activo) {
        this.codTratam = codTratam;
        this.nombre = nombre;
        this.tipo = tipo;
        this.detalle = detalle;
        this.productos = productos;
        this.duracionMinutos = duracionMinutos;
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

    public List<String> getProductos() {
        return productos;
    }

    public void setProductos(List<String> productos) {
        this.productos = productos;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
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
    public String toString() {
        return codTratam + " - " + nombre + " (" + duracionMinutos + " min)";
    }
}
