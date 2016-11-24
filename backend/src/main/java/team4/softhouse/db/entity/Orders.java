package team4.softhouse.db.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class Orders {
    @JsonProperty
    @NotEmpty
    private Integer orderid;

    @JsonProperty
    @NotEmpty
    private String name;

    @JsonProperty
    @NotEmpty
    private Integer productid;

    @JsonProperty
    @NotEmpty
    private Integer userid;

    @JsonProperty
    @NotEmpty
    private Integer status;

    @JsonProperty
    @NotEmpty
    private String username;

    @JsonProperty
    @NotEmpty
    private String category;

    @JsonProperty
    @NotEmpty
    private String specifications;

    public Orders (){}

    public Orders(Integer orderid, String name, Integer productid, Integer userid, Integer status, String username, String category, String specifications) {
        this.orderid = orderid;
        this.username=username;
        this.name = name;
        this.productid = productid;
        this.userid = userid;
        this.category = category;
        this.specifications = specifications;
        this.status = status;
    }



    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }
}

