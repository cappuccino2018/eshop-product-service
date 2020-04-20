package com.roncoo.eshop.product.model;

import java.io.Serializable;

/**
 * Description: 品牌的Model
 *
 * @author 陈思男
 * @date 2020年04月15日 9:07
 */

public class Brand implements Serializable {
    public Brand() {
    }

    private Long id;
    private String name;
    private String description;

    public Brand(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
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
