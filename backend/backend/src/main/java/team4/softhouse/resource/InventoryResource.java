package team4.softhouse.resource;

import team4.softhouse.db.InventoryDAO;
import team4.softhouse.db.entity.Inventory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

//import team4.softhouse.process.NoteProcess;


@Path("/inventory")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class InventoryResource {
    private InventoryDAO inventoryDAO;

    public InventoryResource(InventoryDAO inventoryDAO) {
        this.inventoryDAO = checkNotNull(inventoryDAO);
    }

    @GET
    public List<Inventory> listInventory(@QueryParam("type") String type) {
        System.out.println(type);
        if (type == null)
        {
            return this.inventoryDAO.list();
        }


        return this.inventoryDAO.findByType(type);
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
    public Inventory getNote(@PathParam("id") Integer id) {
        return this.inventoryDAO.findBy(id);
    }

    @POST
    public int createNote(@NotNull @Valid Inventory inventory) {
        return this.inventoryDAO.create(inventory);
    }

    @PUT
    @Path("/{id}")
    public int updateNote(@PathParam("id") Integer id, @Valid Inventory inventory) {
        return this.inventoryDAO.update(id, inventory);
    }

    @DELETE
    @Path("/{id}")
    public void deleteNote(@PathParam("id") Integer id) {
        this.inventoryDAO.deleteBy(id);
    }
}
