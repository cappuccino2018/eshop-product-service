package com.roncoo.eshop.product.model;

import java.io.Serializable;

/**
 * Description:
 *
 * @author 陈思男
 * @date 2020年04月15日 12:23
 */

public class ProductIntro implements Serializable {

    private Long id;
    private String content;
    private Long productId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
