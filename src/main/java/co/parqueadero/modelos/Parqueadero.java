package co.parqueadero.modelos;

/**
 *
 * @author Portatil
 */
public class Parqueadero {
    private int id;
    private String nombre;
    private String nit;
    private String direccion;
    private String telefono;

    public Parqueadero() {
    }

    public Parqueadero(String nombre, String nit, String direccion, String telefono) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Parqueadero(int id, String nombre, String nit, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Parqueadero{" + "id=" + id + ", nit=" + nit + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }
}
