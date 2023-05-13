package co.parqueadero.api;

import co.parqueadero.bd.Conexion;
import co.parqueadero.modelos.Cliente;
import co.parqueadero.modelos.Usuario;
import co.parqueadero.modelos.Vehiculo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
@Path("usuario")
public class UsuarioResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get() {
        List<Usuario> lista = new Conexion().obtenerUsuarios();
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            return objectMapper.writeValueAsString(lista);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(VehiculoTipoResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
    
    @Path("buscar-por-email")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getClientePorDocumento(@QueryParam("email") String email) {
        Usuario entidad = new Conexion().buscarUsuarioPorEmail(email);
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            return objectMapper.writeValueAsString(entidad);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ClienteResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String entidadJson) {
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            Usuario entidad = mapper.readValue(entidadJson, Usuario.class);
            
            entidad = new Conexion().crearUsuario(entidad);
            
            return mapper.writeValueAsString(entidad);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ClienteResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("iniciar-sesion")
    public String iniciarSesion(String entidadJson) {
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            Usuario usuario = mapper.readValue(entidadJson, Usuario.class);
            
            usuario = new Conexion().iniciarSesionUsuario(usuario.getEmail(), usuario.getPassword());
            
            if (usuario != null) {
                return mapper.writeValueAsString(usuario);
            } else {
                usuario = new Usuario();
                usuario.setId(0);
                
                return mapper.writeValueAsString(usuario);
            }
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ClienteResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
}
