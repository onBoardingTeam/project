package team4.softhouse.process;

import javassist.NotFoundException;
import team4.softhouse.db.OrdersDAO;
import team4.softhouse.db.entity.Orders;

import java.util.List;

public class OrdersProcessDbImpl implements OrdersProcess {
    private OrdersDAO ordersDAO;

    public OrdersProcessDbImpl(OrdersDAO ordersDAO){
        this.ordersDAO = ordersDAO;
    }

    @Override
    public List<Orders> list() {
        return this.ordersDAO.list();
    }

    @Override
    public Orders findType(String empid) {
        return this.ordersDAO.findBy(this.ordersDAO.findByType(empid));
    }

    @Override
    public Orders create(Orders orders) {
        return this.ordersDAO.findBy(this.ordersDAO.create(orders));
    }

    @Override
    public Orders update(Integer id, Orders orders) throws NotFoundException {
        // need to update //
        return null;
    }

    @Override
    public Orders find(Integer id) throws NotFoundException {
        return null;
    }
}
