package team4.softhouse.resource;

import team4.softhouse.db.entity.Inventory;
import team4.softhouse.process.InventoryProcess;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

//import team4.softhouse.process.NoteProcess;

@RolesAllowed("ADMIN")
@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class InventoryResource {
    private InventoryProcess inventoryProcess;

    public InventoryResource(InventoryProcess inventoryProcess) {
        this.inventoryProcess = checkNotNull(inventoryProcess);
    }

    @GET
    public List<Inventory> listInventory(@QueryParam("type") String type) {
        System.out.println(type);
        if (type == null)
        {
            return this.inventoryProcess.list();
        }

        return this.inventoryProcess.findType(type);
    }
/*
    @GET
    @Path("/category/{type}")
    public List<Inventory> getInventory(@PathParam("type") String type) {
        return this.inventoryDAO.findByType(type);//
    }

    @GET
    @Path("/category/")
    public List<Inventory> getInventoryx(@QueryParam("type") String type) {
        System.out.println(type);
        return this.inventoryDAO.findByType(type);
    }
*/
    @GET
    @Path("/{id}")
    public Inventory getNote(@PathParam("id") Integer id) throws javassist.NotFoundException {
        return this.inventoryProcess.find(id);
    }

    @POST
    public Inventory createNote(@NotNull @Valid Inventory inventory) {
        return this.inventoryProcess.create(inventory);
    }

    @PUT
    @Path("/{id}")
    public Inventory updateNote(@PathParam("id") Integer id, @Valid Inventory inventory) throws javassist.NotFoundException {
        return this.inventoryProcess.update(id, inventory);
    }

    @DELETE
    @Path("/{id}")
    public void deleteNote(@PathParam("id") Integer id) {
        this.inventoryProcess.delete(id);
    }
}
