package team4.softhouse.process;

import javassist.NotFoundException;
import team4.softhouse.db.entity.Orders;

import java.util.List;

/**
 * Created by cherla on 14/11/2016.
 */
public interface OrdersProcess {

    List<Orders> list();
    Orders findType(String emp_id);
    Orders create(Orders orders);
    Orders update(Integer id, Orders orders) throws NotFoundException;
    Orders find(Integer id) throws NotFoundException;
}
