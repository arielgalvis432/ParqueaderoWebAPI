package co.parqueadero.modelos;

/**
 *
 * @author Portatil
 */
public class Vehiculo {
    private int id;
    private String placa;
    private String marca;
    private String color;
    private int clienteId;
    private int tipoVehiculoId;

    public Vehiculo() {
    }

    public Vehiculo(String placa, String marca, String color, int clienteId, int tipoVehiculoId) {
        this.placa = placa;
        this.marca = marca;
        this.color = color;
        this.clienteId = clienteId;
        this.tipoVehiculoId = tipoVehiculoId;
    }

    public Vehiculo(int id, String placa, String marca, String color, int clienteId, int tipoVehiculoId) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.color = color;
        this.clienteId = clienteId;
        this.tipoVehiculoId = tipoVehiculoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getTipoVehiculoId() {
        return tipoVehiculoId;
    }

    public void setTipoVehiculoId(int tipoVehiculoId) {
        this.tipoVehiculoId = tipoVehiculoId;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "id=" + id + ", placa=" + placa + ", marca=" + marca + ", color=" + color + ", clienteId=" + clienteId + ", tipoVehiculoId=" + tipoVehiculoId + '}';
    }
}
