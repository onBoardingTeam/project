package team4.softhouse.process;

import javassist.NotFoundException;
import team4.softhouse.db.entity.Inventory;

import java.util.List;

/**
 * Created by cherla on 07/11/2016.
 */
public interface InventoryProcess {

    List<Inventory> list();
    List<Inventory> findType( String Type);
    List<Inventory> listCategory();
    Inventory create(Inventory inventory);
    Inventory update(Integer id, Inventory inventory) throws NotFoundException;
    Inventory find(Integer id) throws NotFoundException;
    void updateQuantity(Integer productid);

    void delete(Integer id);
}
