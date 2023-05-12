package co.parqueadero.modelos;

/**
 *
 * @author Portatil
 */
public class Usuario {
    private int id;
    private String email;
    private String password;
    private String nombreCompleto;
    private String telefono;
    private int rolId;
    private int parqueaderoId;
    private String nombreRol;
    private String nombreParqueadero;

    public Usuario() {
    }

    public Usuario(String email, String password, String nombreCompleto, String telefono, int rolId, int parqueaderoId, String nombreRol, String nombreParqueadero) {
        this.email = email;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.rolId = rolId;
        this.parqueaderoId = parqueaderoId;
        this.nombreRol = nombreRol;
        this.nombreParqueadero = nombreParqueadero;
    }

    public Usuario(int id, String email, String password, String nombreCompleto, String telefono, int rolId, int parqueaderoId, String nombreRol, String nombreParqueadero) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.rolId = rolId;
        this.parqueaderoId = parqueaderoId;
        this.nombreRol = nombreRol;
        this.nombreParqueadero = nombreParqueadero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public int getParqueaderoId() {
        return parqueaderoId;
    }

    public void setParqueaderoId(int parqueaderoId) {
        this.parqueaderoId = parqueaderoId;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getNombreParqueadero() {
        return nombreParqueadero;
    }

    public void setNombreParqueadero(String nombreParqueadero) {
        this.nombreParqueadero = nombreParqueadero;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", email=" + email + ", password=" + password + ", nombreCompleto=" + nombreCompleto + ", telefono=" + telefono + ", rolId=" + rolId + ", parqueaderoId=" + parqueaderoId + ", nombreRol=" + nombreRol + ", nombreParqueadero=" + nombreParqueadero + '}';
    }
}
