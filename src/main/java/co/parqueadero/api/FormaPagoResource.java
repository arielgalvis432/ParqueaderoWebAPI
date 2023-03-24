package co.parqueadero.api;

import co.parqueadero.bd.Conexion;
import co.parqueadero.modelos.FormaPago;
import co.parqueadero.modelos.Rol;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Portatil
 */
@Path("forma-pago")
public class FormaPagoResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get() {
        List<FormaPago> lista = new Conexion().obtenerFormasPago();
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            return objectMapper.writeValueAsString(lista);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(VehiculoTipoResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
}
