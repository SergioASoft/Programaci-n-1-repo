package co.edu.uniquindio.biblioteca.models;

public class Empleado {
    private String nombre;
    private String apellido;
    private String cedula;
    private String direccion;
    private int edad;

    public Empleado(String nombre, String apellido, String cedula, String direccion, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    @Override
    public String toString() {
        return "Cliente{ \n-nombre: "+nombre+"\n-Apellido: "+apellido+"\n-Cédula: "+cedula+"\n-dirección: "+direccion+"\n-Edad: "+edad+"\n";
    }
}
