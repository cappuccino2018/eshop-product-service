package com.roncoo.eshop.product.model;

/**
 * Description: 类别的model
 *
 * @author 陈思男
 * @date 2020年04月15日 9:06
 */

public class Category {

    private Long id;
    private String name;
    private String description;

    public Long getId() {
        return id;
    }

    public Category(Long id,String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Category() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
