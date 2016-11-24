package team4.softhouse.db;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import team4.softhouse.db.entity.Inventory;

import java.util.List;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface InventoryDAO {
    @SqlUpdate("CREATE TABLE IF NOT EXISTS inventory(id int auto_increment primary key, name varchar(12), category varchar(255), specifications varchar(500), quantity int NOT NULL)")
    void createTable();

    @SqlUpdate("INSERT INTO `inventory` VALUES(:id, :name, :category, :specifications, :quantity)")
    @GetGeneratedKeys
    int create(@BindBean Inventory inventory);

    @SqlQuery("SELECT * FROM `inventory`")
    List<Inventory> list();

    @SqlQuery("SELECT DISTINCT category from inventory")
    List<Inventory> listCategory();

    @SqlQuery("SELECT * FROM `inventory` WHERE category = :type")
    List<Inventory> findByType(@Bind("type") String Type);

    //@SqlQuery("SELECT * FROM `inventory` WHERE category = :cat")
    //Inventory findByCat(@Bind("cat") String cat);

    @SqlQuery("SELECT * FROM `inventory` WHERE id = :id")
    Inventory findBy(@Bind("id") int id);

    @SqlUpdate("DELETE FROM `inventory` WHERE id = :id")
    int deleteBy(@Bind("id") int id);

    @SqlUpdate("UPDATE `inventory` SET name = :name, category = :category, quantity =:quantity WHERE id = :id")
    Integer update(@BindBean Inventory inventory);

    @SqlUpdate("UPDATE `inventory` SET quantity =quantity-1 WHERE id = :productid")
    void updateQuantity(@Bind("productid") int productid);

}
