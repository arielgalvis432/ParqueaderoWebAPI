package co.parqueadero.api;

import co.parqueadero.bd.DAO;
import co.parqueadero.modelos.FormaPago;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Portatil
 */
@Path("forma-pago")
public class FormaPagoResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get() {
        List<FormaPago> lista = new DAO().obtenerFormasPago();

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writeValueAsString(lista);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(VehiculoTipoResource.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String put(String json) {
        ObjectMapper mapper = new ObjectMapper();
        FormaPago entidad = new FormaPago();

        try {
            entidad = mapper.readValue(json, FormaPago.class);

            entidad = new DAO().actualizarMedioPago(entidad);

            return mapper.writeValueAsString(entidad);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ClienteResource.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }
}
