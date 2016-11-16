package team4.softhouse.process;


import javassist.NotFoundException;
import team4.softhouse.db.entity.Cart;

import java.util.List;

public interface CartProcess {


    List<Cart> list();
    Cart create(Cart cart);
    Cart update(Integer id, Cart cart) throws NotFoundException;
    Cart find(Integer);

}
