package team4.softhouse.db;


import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import team4.softhouse.db.entity.Orders;

import java.util.List;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface OrdersDAO {

    @SqlUpdate("CREATE TABLE IF NOT EXISTS orders(id int auto_increment primary key, emp_name varchar(200), emp_id varchar(200), name varchar(200), category varchar(200), specifications varchar(500))")
    void createTable();

    @SqlUpdate("INSERT INTO `orders` VALUES(:id, :emp_name, :emp_id, :name, :category, :specifications)")
    @GetGeneratedKeys
    int create(@BindBean Orders orders);

    @SqlQuery("SELECT * FROM `orders`")
    List<Orders> list();

    @SqlQuery("SELECT * FROM `orders` WHERE emp_id = :empid")
    List<Orders> findByType(@Bind("empid") String Empid);

    @SqlQuery("SELECT * FROM `orders` WHERE id = :id")
    Orders findBy(@Bind("id") List<Orders> id);

    Orders findBy(int id);









  /*  @SqlUpdate("insert into orders (emp_id,emp_name,name,category,specifications) values (:emp_id,:emp_name,:name,:category,:specfications);")
    public void insertOrders(@BindBean Orders orders);

    @SqlUpdate("SELECT * FROM orders WHERE emp_id = :emp_id;")
    public List<Orders> getBy(@Bind("emp_id") String emp_id);

    @SqlQuery("select * from orders ;")
    public List<Orders> getBy();

    @SqlQuery("select * from order WHERE flag = :flag ;")
    public List<Orders> getStatus(@Bind("flag") int flag);
*/



}
