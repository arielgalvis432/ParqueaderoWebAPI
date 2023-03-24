package co.parqueadero.api;

import co.parqueadero.bd.Conexion;
import co.parqueadero.modelos.Cubiculo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Portatil
 */
@Path("cubiculo")
public class CubiculoRecurso {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get() {
        List<Cubiculo> lista = new Conexion().obtenerCubiculos();
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            return objectMapper.writeValueAsString(lista);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(VehiculoTipoResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
    
    @Path("buscar-por-id")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPorId(@QueryParam("id") String id) {
        Cubiculo entidad = new Conexion().obtenerCubiculoPorId(Integer.parseInt(id));
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            return objectMapper.writeValueAsString(entidad);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(VehiculoTipoResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
}
