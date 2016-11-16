package team4.softhouse.resource;

import team4.softhouse.process.CartProcess;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RolesAllowed("ADMIN")
@Path("/cart")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class CartResource {
    private CartProcess cartProcess
}
