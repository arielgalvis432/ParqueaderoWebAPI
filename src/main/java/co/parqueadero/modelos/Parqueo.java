package co.parqueadero.modelos;

/**
 *
 * @author Portatil
 */
public class Parqueo {
    private int id;
    private String fechaInicio;
    private String fechaFinal;
    private String horaInicio;
    private String horaFinal;
    private int reserva;
    private int estadoReserva;
    private int vehiculoId;
    private int facturaId;
    private int cubiculoId;
    private String nombreCliente;
    private String documentoCliente;
    private String placaVehiculo;
    private int clienteId;

    public Parqueo() {
    }

    public Parqueo(String fechaInicio, String fechaFinal, String horaInicio, String horaFinal, int reserva, int estadoReserva, int vehiculoId, int facturaId, int cubiculoId) {
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.reserva = reserva;
        this.estadoReserva = estadoReserva;
        this.vehiculoId = vehiculoId;
        this.facturaId = facturaId;
        this.cubiculoId = cubiculoId;
    }

    public Parqueo(int id, String fechaInicio, String fechaFinal, String horaInicio, String horaFinal, int reserva, int estadoReserva, int vehiculoId, int facturaId, int cubiculoId) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.reserva = reserva;
        this.estadoReserva = estadoReserva;
        this.vehiculoId = vehiculoId;
        this.facturaId = facturaId;
        this.cubiculoId = cubiculoId;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public int getReserva() {
        return reserva;
    }

    public void setReserva(int reserva) {
        this.reserva = reserva;
    }

    public int getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(int estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public int getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(int vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public int getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(int facturaId) {
        this.facturaId = facturaId;
    }

    public int getCubiculoId() {
        return cubiculoId;
    }

    public void setCubiculoId(int cubiculoId) {
        this.cubiculoId = cubiculoId;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDocumentoCliente() {
        return documentoCliente;
    }

    public void setDocumentoCliente(String documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    @Override
    public String toString() {
        return "Parqueo{" + "id=" + id + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + ", horaInicio=" + horaInicio + ", horaFinal=" + horaFinal + ", vehiculoId=" + vehiculoId + ", facturaId=" + facturaId + ", cubiculoId=" + cubiculoId + '}';
    }
}
