package team4.softhouse.db;


import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import team4.softhouse.db.entity.Inventory;
import team4.softhouse.db.entity.Orders;

import java.util.List;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface OrdersDAO {

    @SqlUpdate("CREATE TABLE IF NOT EXISTS orders(orderid int auto_increment primary key, productid int, userid int, username varchar(200), name varchar(200), category varchar(200), specifications varchar(500), status int, UNIQUE(productid,userid))")
    void createTable();

    @SqlUpdate("INSERT INTO `orders` VALUES(:orderid, :productid, :userid, :username, :name, :category, :specifications, :status)")
    @GetGeneratedKeys
    int create(@BindBean Orders product);

   @SqlQuery("SELECT * FROM `orders`")
   List<Orders> get();

    @SqlUpdate("UPDATE `orders` set status = :status WHERE orderid = :id")
    int updateBy(@Bind("id") int id, @Bind("status") int status);

}
