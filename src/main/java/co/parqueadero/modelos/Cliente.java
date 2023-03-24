package co.parqueadero.modelos;

/**
 *
 * @author Portatil
 */
public class Cliente {
    private int id;
    private String nombreCompleto;
    private String email;
    private String documento;
    private String telefono;
    private int parqueaderoId;

    public Cliente() {
    }

    public Cliente(String nombreCompleto, String email, String documento, String telefono, int parqueaderoId) {
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.documento = documento;
        this.telefono = telefono;
        this.parqueaderoId = parqueaderoId;
    }

    public Cliente(int id, String nombreCompleto, String email, String documento, String telefono, int parqueaderoId) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.documento = documento;
        this.telefono = telefono;
        this.parqueaderoId = parqueaderoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getParqueaderoId() {
        return parqueaderoId;
    }

    public void setParqueaderoId(int parqueaderoId) {
        this.parqueaderoId = parqueaderoId;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombreCompleto=" + nombreCompleto + ", email=" + email + ", documento=" + documento + ", telefono=" + telefono + '}';
    }
}
