package team4.softhouse.db.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class Orders {

    @JsonProperty
    private Integer id;

    @JsonProperty
    @NotEmpty
    private String emp_name;

    @JsonProperty
    @NotEmpty
    private String emp_id;

    @JsonProperty
    @NotEmpty
    private String name;

    @JsonProperty
    @NotEmpty
    private String category;

    @JsonProperty
    @NotEmpty
    private String specifications;

    public Orders (){}

    public Orders(Integer id, String emp_name, String emp_id, String name, String category, String specifications){
        this.id = id;
        this.emp_name = emp_name;
        this.emp_id = emp_id;
        this.name = name;
        this.category = category;
        this.specifications = specifications;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
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

