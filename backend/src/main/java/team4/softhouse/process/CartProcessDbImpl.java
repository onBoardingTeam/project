package team4.softhouse.process;


import javassist.NotFoundException;
import team4.softhouse.db.CartDAO;
import team4.softhouse.db.entity.Cart;

import java.util.List;
import java.util.Optional;

public class CartProcessDbImpl implements CartProcess {
    private CartDAO cartDAO;

    public CartProcessDbImpl(CartDAO cartDAO){
        this.cartDAO = cartDAO;

    }

    @Override
    public List<Cart> list(){return this.cartDAO.list();}


    @Override
    public  Cart create(Cart cart){return this.cartDAO.findBy(this.cartDAO.create(cart));}

    @Override
    public Cart update(Integer id, Cart updatedCart) throws NotFoundException{
        Cart cart = this.find(id);

        Cart.setProduct_id(updatedCart.getProduct_id());
        Cart.setUser_id(updatedCart.getUser_id());

        this.cartDAO.update(Cart);

        return cart;
    }

    @Override
    public Cart find(Integer id) throws NotFoundException {
        return Optional
                .ofNullable(this.cartDAO.findBy(id))
                .orElseThrow(() -> new javax.ws.rs.NotFoundException("cart does not exist"));

    }

    @Override
    public void delete (Integer id) { this.cartDAO.deleteBy(id);}


}
