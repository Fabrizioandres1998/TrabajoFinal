package Modelo;

public class Cliente {

    private int codCli;
    private int dni;
    private String nombreCompleto;
    private long telefono;
    private int edad;
    private String afecciones;
    private boolean estado;

    public Cliente(int dni, String nombreCompleto, long telefono, int edad, String afecciones, boolean estado) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.edad = edad;
        this.afecciones = afecciones;
        this.estado = estado;
    }

    public Cliente() {
    }

    public int getCodCli() {
        return codCli;
    }

    public void setCodCli(int codCli) {
        this.codCli = codCli;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getAfecciones() {
        return afecciones;
    }

    public void setAfecciones(String afecciones) {
        this.afecciones = afecciones;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nombreCompleto; // solo el nombre completo
    }

}
