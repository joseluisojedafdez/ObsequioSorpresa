package cl.desafiolatam.desafio1;

public class Obsequio {
    private String nombre;

    public Obsequio(String nombre, int imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Obsequio{" +
                "nombre='" + nombre + '\'' +
                ", imagen=" + imagen +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    private int imagen;
}
