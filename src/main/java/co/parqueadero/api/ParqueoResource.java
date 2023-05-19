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

import co.parqueadero.bd.DAO;
import co.parqueadero.modelos.Parqueo;
import javax.ws.rs.DELETE;

/**
 *
 * @author Portatil
 */
@Path("parqueo")
public class ParqueoResource {
    /**
     * Método GET para traer todos los parqueos.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get() {
        List<Parqueo> lista = new DAO().obtenerParqueos();
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            return objectMapper.writeValueAsString(lista);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(VehiculoTipoResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }

    @GET
    @Path("buscar-por-id")
    @Produces(MediaType.APPLICATION_JSON)
    public String buscarPorId(@QueryParam("id") String id) {
        Parqueo parqueo = new DAO().obtenerParqueoPorId(Integer.parseInt(id));
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            return objectMapper.writeValueAsString(parqueo);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(VehiculoTipoResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
    
    @GET
    @Path("buscar-por-vehiculo-id")
    @Produces(MediaType.APPLICATION_JSON)
    public String buscarPorVehiculoId(@QueryParam("id") String id) {
        List<Parqueo> parqueo = new DAO().obtenerParqueosPorVehiculoId(Integer.parseInt(id));
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            return objectMapper.writeValueAsString(parqueo);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(VehiculoTipoResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }

    @GET
    @Path("buscar-por-placa")
    @Produces(MediaType.APPLICATION_JSON)
    public String buscarPorVehiculoPlaca(@QueryParam("placa") String placa) {
        List<Parqueo> parqueo = new DAO().obtenerParqueosPorVehiculoPlaca(placa);
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            return objectMapper.writeValueAsString(parqueo);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(VehiculoTipoResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
    
    @GET
    @Path("buscar-por-cubiculo-id")
    @Produces(MediaType.APPLICATION_JSON)
    public String buscarParqueoPorCubiculoId(@QueryParam("id") String id) {
        List<Parqueo> parqueo = new DAO().obtenerParqueosPorCubiculoId(Integer.parseInt(id));
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            return objectMapper.writeValueAsString(parqueo);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(VehiculoTipoResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }

    @GET
    @Path("buscar-por-cliente-documento")
    @Produces(MediaType.APPLICATION_JSON)
    public String buscarParqueoPorClienteDocumento(@QueryParam("documento") String documento) {
        List<Parqueo> parqueo = new DAO().obtenerParqueosPorClienteDocumento(documento);
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            return objectMapper.writeValueAsString(parqueo);
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
            Parqueo parqueo = objectMapper.readValue(json, Parqueo.class);
            
            new DAO().crearParqueo(parqueo);
            
            return objectMapper.writeValueAsString(parqueo);
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
            Parqueo parqueo = objectMapper.readValue(json, Parqueo.class);
            
            new DAO().actualizarParqueo(parqueo);
            
            return objectMapper.writeValueAsString(parqueo);
        } catch (Exception ex) {
            Logger.getLogger(VehiculoTipoResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
    
    @Path("actualizacion")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String putActualizacion(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            Parqueo parqueo = objectMapper.readValue(json, Parqueo.class);
            
            new DAO().actualizarParqueoReserva(parqueo);
            
            return objectMapper.writeValueAsString(parqueo);
        } catch (Exception ex) {
            Logger.getLogger(VehiculoTipoResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String eliminarParqueoPorId(@QueryParam("id") String id) {
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            Parqueo parqueo = new DAO().obtenerParqueoPorId(Integer.parseInt(id));
            
            new DAO().eliminarParqueoPorId(parqueo.getId());
            
            return objectMapper.writeValueAsString(parqueo);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(VehiculoTipoResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
}
