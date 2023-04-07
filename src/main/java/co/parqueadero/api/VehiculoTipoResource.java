/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.parqueadero.api;

import co.parqueadero.bd.Conexion;
import co.parqueadero.modelos.VehiculoTipo;
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

/**
 *
 * @author Felix Linares
 */
@Path("vehiculo-tipo")
public class VehiculoTipoResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get() {
        List<VehiculoTipo> vehiculoTipos = new Conexion().obtenerVehiculosTipos();
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            return objectMapper.writeValueAsString(vehiculoTipos);
        } catch (JsonProcessingException ex) {
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
            VehiculoTipo entidad = objectMapper.readValue(json, VehiculoTipo.class);
            new Conexion().actualizarVehiculoTipo(entidad);
            
            return objectMapper.writeValueAsString(entidad);
        } catch (Exception ex) {
            Logger.getLogger(ClienteResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
}
