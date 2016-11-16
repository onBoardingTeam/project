package team4.softhouse.db;

import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import team4.softhouse.db.entity.Cart;

import java.util.List;

@RegisterMapperFactory(BeanMapperFactory.class)

public interface CartDAO {

    @SqlUpdate("CREATE TABLE IF NOT EXISTS cart(id int auto_increment primary key, product_id int(100), user_id int(100))")
    void createTable();

    @SqlUpdate("UPDATE INTO `cart` VALUES(:id, :product_id, :user_id)")
    @GetGeneratedKeys
    int create(@BindBean Cart cart);

    @SqlQuery("SELECT * FROM `cart`")
    List<Cart> list();

    @SqlUpdate("UPDATE `cart` SET product_id = :product_id, user_id = :user_id")
    Integer update(@BindBean Cart cart);

}
