package co.parqueadero.api;

import co.parqueadero.bd.Conexion;
import co.parqueadero.modelos.Cliente;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
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

/**
 *
 * @author Portatil
 */
@Path("cliente")
public class ClienteResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get() {
        List<Cliente> lista = new Conexion().obtenerClientes();
        
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
        Cliente cliente = new Conexion().obtenerClientePorId(Integer.parseInt(id));
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            return objectMapper.writeValueAsString(cliente);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(VehiculoTipoResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
    
    @Path("buscar-por-documento")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getClientePorDocumento(@QueryParam("documento") String documento) {
        Cliente cliente = new Conexion().obtenerClientePorDocumento(documento);
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            return objectMapper.writeValueAsString(cliente);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(VehiculoTipoResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String entidadJson) {
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            Cliente cliente = mapper.readValue(entidadJson, Cliente.class);
            
            cliente = new Conexion().crearCliente(cliente);
            
            return mapper.writeValueAsString(cliente);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ClienteResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
}
