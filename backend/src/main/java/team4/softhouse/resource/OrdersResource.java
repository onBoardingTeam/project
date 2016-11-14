package team4.softhouse.resource;


import com.sun.istack.internal.NotNull;
import team4.softhouse.db.entity.Orders;
import team4.softhouse.process.OrdersProcess;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static jersey.repackaged.com.google.common.base.Preconditions.checkNotNull;

@RolesAllowed("ADMIN")
@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class OrdersResource {

    private OrdersProcess ordersProcess;

    public OrdersResource(OrdersProcess ordersProcess){
        this.ordersProcess = checkNotNull(ordersProcess);
    }

    @GET
    public List<Orders> listOrders(@QueryParam("empid") String empid){
    System.out.println(empid);
        if (empid == null)
        {
            return this.ordersProcess.list();
        }

        return (List<Orders>) this.ordersProcess.findType(empid);
    }

    @POST
    public Orders createNote(@NotNull @Valid Orders orders){
        return this.ordersProcess.create(orders);
    }

}




