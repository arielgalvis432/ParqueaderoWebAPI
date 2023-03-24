package co.parqueadero.modelos;

/**
 *
 * @author Portatil
 */
public class Factura {
    private int id;
    private String fechaHora;
    private int impuesto;
    private double total;
    private int usuarioId;
    private int formaPagoId;

    public Factura() {
    }

    public Factura(String fechaHora, int impuesto, double total, int usuarioId, int formaPagoId) {
        this.fechaHora = fechaHora;
        this.impuesto = impuesto;
        this.total = total;
        this.usuarioId = usuarioId;
        this.formaPagoId = formaPagoId;
    }

    public Factura(int id, String fechaHora, int impuesto, double total, int usuarioId, int formaPagoId) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.impuesto = impuesto;
        this.total = total;
        this.usuarioId = usuarioId;
        this.formaPagoId = formaPagoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(int impuesto) {
        this.impuesto = impuesto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getFormaPagoId() {
        return formaPagoId;
    }

    public void setFormaPagoId(int formaPagoId) {
        this.formaPagoId = formaPagoId;
    }

    @Override
    public String toString() {
        return "Factura{" + "id=" + id + ", fechaHora=" + fechaHora + ", impuesto=" + impuesto + ", total=" + total + ", usuarioId=" + usuarioId + ", formaPagoId=" + formaPagoId + '}';
    }
}
