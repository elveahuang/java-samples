package cn.elvea.quarkus.base.resource;

import cn.elvea.quarkus.base.service.CoreService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * IndexResource
 *
 * @author elvea
 */
@Path("/")
public class IndexResource {

    @Inject
    CoreService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return service.hello();
    }

}
