package co.edu.uniquindio.biblioteca.models;

public class Libro {
    private String nombre;
    private String descripcion;
    private String genero;
    private String autor;
    private int numPaginas;

    public Libro(String nombre, String descripcion, String genero, String autor, int numPaginas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.genero = genero;
        this.autor = autor;
        this.numPaginas = numPaginas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }
    @Override
    public String toString() {
        return "Cliente{ \n-nombre: "+nombre+"\n-Descripción: "+descripcion+"\n-Género: "+genero+"\n-autor: "+autor+"\n-numPaginas: "+numPaginas+"\n";
    }
}
