package co.parqueadero.api;

import co.parqueadero.bd.Conexion;
import co.parqueadero.modelos.Vehiculo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

/**
 *
 * @author Portatil
 */
@Path("vehiculo")
public class VehiculoResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get() {
        List<Vehiculo> lista = new Conexion().obtenerVehiculos();
        
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
    public String getClientePorId(@QueryParam("id") String id) {
        Vehiculo entidad = new Conexion().obtenerVehiculoPorId(Integer.parseInt(id));
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            return objectMapper.writeValueAsString(entidad);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(VehiculoTipoResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
    
    @Path("buscar-por-placa")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getClientePorPlaca(@QueryParam("placa") String placa) {
        Vehiculo entidad = new Conexion().obtenerVehiculoPorPlaca(placa);
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            return objectMapper.writeValueAsString(entidad);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(VehiculoTipoResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
    
    @Path("buscar-por-cliente-id")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getVehiculosPorClienteId(@QueryParam("clienteId") int clienteId) {
        List<Vehiculo> entidad = new Conexion().obtenerVehiculosPorClienteId(clienteId);
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            return objectMapper.writeValueAsString(entidad);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(VehiculoTipoResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String clienteJson) {
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            Vehiculo entidad = mapper.readValue(clienteJson, Vehiculo.class);
            
            entidad = new Conexion().crearVehiculo(entidad);
            
            return mapper.writeValueAsString(entidad);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ClienteResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String put(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            Vehiculo entidad = objectMapper.readValue(json, Vehiculo.class);
            new Conexion().actualizarVehiculo(entidad);
            
            return objectMapper.writeValueAsString(entidad);
        } catch (Exception ex) {
            Logger.getLogger(ClienteResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
}
