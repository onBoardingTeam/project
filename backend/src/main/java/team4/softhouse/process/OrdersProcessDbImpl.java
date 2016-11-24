package team4.softhouse.process;

import javassist.NotFoundException;
import team4.softhouse.db.OrdersDAO;
import team4.softhouse.db.entity.Inventory;
import team4.softhouse.db.entity.Orders;

import javax.ws.rs.BadRequestException;
import java.util.List;
import java.util.Optional;

public class OrdersProcessDbImpl implements OrdersProcess {
    private OrdersDAO ordersDAO;

    public OrdersProcessDbImpl(OrdersDAO ordersDAO){
        this.ordersDAO = ordersDAO;
    }


   @Override
    public List<Orders> getorders() throws NotFoundException {
       return Optional
               .ofNullable(this.ordersDAO.get())
               .orElseThrow(() -> new javax.ws.rs.NotFoundException("No orders available"));

   }

    @Override
    public void updateOrder(Integer id, Integer status) {
        this.ordersDAO.updateBy(id, status);
    }

    @Override
    public int create(Orders product) throws BadRequestException {
        return Optional
                .ofNullable( this.ordersDAO.create(product))
                .orElseThrow(()-> new BadRequestException("You have ordered similar product more than Once"));

    }

    }
