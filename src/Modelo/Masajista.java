package Modelo;

public class Masajista {

    private String matricula;
    private String nombreYApellido;
    private String telefono;
    private String especialidad;
    private boolean estado;

    public Masajista() {
    }

    public Masajista(String matricula, String nombreYApellido, String telefono, String especialidad, boolean estado) {
        this.matricula = matricula;
        this.nombreYApellido = nombreYApellido;
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    public Masajista(String nombreYApellido, String telefono, String especialidad, boolean estado) {
        this.nombreYApellido = nombreYApellido;
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombreYApellido() {
        return nombreYApellido;
    }

    public void setNombreYApellido(String nombreYApellido) {
        this.nombreYApellido = nombreYApellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return matricula + " - " + nombreYApellido;
    }
}
