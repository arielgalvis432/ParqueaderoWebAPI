package co.parqueadero.api;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.parqueadero.bd.Conexion;
import co.parqueadero.modelos.Parqueadero;
import javax.ws.rs.PUT;

/**
 *
 * @author Portatil
 */
@Path("parqueadero")
public class ParqueaderoResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getFactura(){
        List<Parqueadero> lista = new Conexion().obtenerParqueaderos();
        
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
        Parqueadero entidad = new Conexion().obtenerParqueaderoPorId(Integer.parseInt(id));
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            return objectMapper.writeValueAsString(entidad);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(VehiculoTipoResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String post(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            Parqueadero entidad = objectMapper.readValue(json, Parqueadero.class);
            
            new Conexion().crearParqueadero(entidad);
            
            return objectMapper.writeValueAsString(entidad);
        } catch (Exception ex) {
            Logger.getLogger(VehiculoTipoResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String put(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            Parqueadero entidad = objectMapper.readValue(json, Parqueadero.class);
            
            new Conexion().actualizarParqueadero(entidad);
            
            return objectMapper.writeValueAsString(entidad);
        } catch (Exception ex) {
            Logger.getLogger(VehiculoTipoResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
}
