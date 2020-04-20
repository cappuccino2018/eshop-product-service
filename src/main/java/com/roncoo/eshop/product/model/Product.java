package com.roncoo.eshop.product.model;

import java.io.Serializable;

/**
 * Description: 商品的Model
 *
 * @author 陈思男
 * @date 2020年04月15日 9:08
 */

public class Product implements Serializable {

    private Long id;
    private String name;
    private Long categoryId;
    private Long brandId;

    public Product() {
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
}
