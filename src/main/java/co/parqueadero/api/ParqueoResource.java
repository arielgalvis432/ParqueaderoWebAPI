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
import co.parqueadero.modelos.Parqueo;

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
        List<Parqueo> lista = new Conexion().obtenerParqueos();
        
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
        Parqueo parqueo = new Conexion().obtenerParqueoPorId(Integer.parseInt(id));
        
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
        List<Parqueo> parqueo = new Conexion().obtenerParqueosPorVehiculoId(Integer.parseInt(id));
        
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
        List<Parqueo> parqueo = new Conexion().obtenerParqueosPorVehiculoPlaca(placa);
        
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
        List<Parqueo> parqueo = new Conexion().obtenerParqueosPorCubiculoId(Integer.parseInt(id));
        
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
        List<Parqueo> parqueo = new Conexion().obtenerParqueosPorClienteDocumento(documento);
        
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
            
            new Conexion().crearParqueo(parqueo);
            
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
            
            new Conexion().actualizarParqueo(parqueo);
            
            return objectMapper.writeValueAsString(parqueo);
        } catch (Exception ex) {
            Logger.getLogger(VehiculoTipoResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
}
