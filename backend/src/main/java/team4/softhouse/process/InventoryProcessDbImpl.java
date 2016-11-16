package team4.softhouse.process;

import javassist.NotFoundException;
import team4.softhouse.db.InventoryDAO;
import team4.softhouse.db.entity.Inventory;

import java.util.List;
import java.util.Optional;

public class InventoryProcessDbImpl implements InventoryProcess {
    private InventoryDAO inventoryDAO;

    public InventoryProcessDbImpl(InventoryDAO inventoryDAO){
        this.inventoryDAO = inventoryDAO;
    }

    @Override
    public List<Inventory> list() { return this.inventoryDAO.list(); }

    @Override
    public List<Inventory> findType(String type) {return this.inventoryDAO.findByType(type);}

    @Override
    public Inventory create(Inventory inventory) {return this.inventoryDAO.findBy(this.inventoryDAO.create(inventory)); }

    @Override
    public Inventory update(Integer id, Inventory updatedInventory) throws NotFoundException{
        Inventory inventory = this.find(id);

        inventory.setName(updatedInventory.getName());
        inventory.setCategory(updatedInventory.getCategory());
        inventory.setSpecifications(updatedInventory.getSpecifications());
        inventory.setQuantity(updatedInventory.getQuantity());

        this.inventoryDAO.update(inventory);

        return inventory;

    }

    @Override
    public Inventory find(Integer id) throws NotFoundException {
        return Optional
                .ofNullable(this.inventoryDAO.findBy(id))
                .orElseThrow(() -> new javax.ws.rs.NotFoundException("inventory does not exist"));

    }

    @Override
    public void delete (Integer id) { this.inventoryDAO.deleteBy(id);}


}

