package team4.softhouse.process;

import javassist.NotFoundException;
import team4.softhouse.db.entity.Orders;

import java.util.List;


public interface OrdersProcess {

    int create(Orders product);
    List<Orders> getorders() throws NotFoundException;
    /*void delete(Integer id);*/
    void updateOrder(Integer id, Integer status);
}
