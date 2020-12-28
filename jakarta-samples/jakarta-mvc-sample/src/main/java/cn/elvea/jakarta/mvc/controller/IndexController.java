package cn.elvea.jakarta.mvc.controller;

import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

/**
 * IndexController
 *
 * @author elvea
 */
@Controller
@Path("index")
public class IndexController {

    @GET
    public Response hello() {
        return Response.ok().build();
    }

}
