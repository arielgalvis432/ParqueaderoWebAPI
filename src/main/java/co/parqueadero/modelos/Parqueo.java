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
    private int vehiculoId;
    private int facturaId;
    private int cubiculoId;

    public Parqueo() {
    }

    public Parqueo(String fechaInicio, String fechaFinal, String horaInicio, String horaFinal, int vehiculoId, int facturaId, int cubiculoId) {
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
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

    @Override
    public String toString() {
        return "Parqueo{" + "id=" + id + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + ", horaInicio=" + horaInicio + ", horaFinal=" + horaFinal + ", vehiculoId=" + vehiculoId + ", facturaId=" + facturaId + ", cubiculoId=" + cubiculoId + '}';
    }
}
