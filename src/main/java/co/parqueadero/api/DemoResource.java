/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.parqueadero.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 *
 * @author Felix Linares
 */

@Path("demo")
public class DemoResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String httpGet() {
        return "Todo funcionando";
    }
}