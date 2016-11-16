package team4.softhouse.db.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class Cart {

    @JsonProperty
    private Integer id;

    @JsonProperty
    @NotEmpty
    private Integer product_id;

    @JsonProperty
    @NotEmpty
    private Integer user_id;

    public Cart(){}

    public Cart(Integer id, Integer product_id, Integer user_id){

        this.id = id;
        this.product_id = product_id;
        this.user_id = user_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
