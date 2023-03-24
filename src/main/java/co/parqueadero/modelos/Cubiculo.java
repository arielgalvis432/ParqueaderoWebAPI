package co.parqueadero.modelos;

/**
 *
 * @author Portatil
 */
public class Cubiculo {
    private int id;
    private String nombre;
    private int disponible;

    public Cubiculo() {
    }

    public Cubiculo(String nombre, int disponible) {
        this.nombre = nombre;
        this.disponible = disponible;
    }

    public Cubiculo(int id, String nombre, int disponible) {
        this.id = id;
        this.nombre = nombre;
        this.disponible = disponible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDisponible() {
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Cubiculo{" + "id=" + id + ", nombre=" + nombre + ", disponible=" + disponible + '}';
    }
}
