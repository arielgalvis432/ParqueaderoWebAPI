package co.parqueadero.api;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.parqueadero.bd.Conexion;
import co.parqueadero.modelos.Factura;

/**
 *
 * @author Portatil
 */
@Path("factura")
public class FacturaResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getFactura(){
        List<Factura> lista = new Conexion().obtenerFacturas();
        
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
        Factura entidad = new Conexion().obtenerFacturaPorId(Integer.parseInt(id));
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            return objectMapper.writeValueAsString(entidad);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(VehiculoTipoResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
    
    @Path("buscar-por-usuario-id")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPorUsuarioId(@QueryParam("id") String id) {
        List<Factura> entidad = new Conexion().obtenerFacturasPorUsuarioId(Integer.parseInt(id));
        
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
            Factura entidad = objectMapper.readValue(json, Factura.class);
            
            new Conexion().crearFactura(entidad);
            
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
            Factura entidad = objectMapper.readValue(json, Factura.class);
            
            new Conexion().actualizarFactura(entidad);
            
            return objectMapper.writeValueAsString(entidad);
        } catch (Exception ex) {
            Logger.getLogger(VehiculoTipoResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
}
