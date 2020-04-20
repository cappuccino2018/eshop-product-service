package com.roncoo.eshop.product.mapper;

import com.roncoo.eshop.product.model.ProductIntro;
import com.roncoo.eshop.product.model.ProductProperty;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProductIntroMaper {

    @Insert("INSERT INTO product_intro(content,product_id) VALUES(#{content},#{productId})")
    public void addProductIntro(ProductIntro productIntro);

    @Update("UPDATE product_intro set content=#{content},product_id=#{productId} WHERE id=#{id}")
    public void updateProductIntro(ProductIntro productIntro);

    @Delete("DELETE FROM product_intro WHERE id=#{id}")
    public void deleteProductIntro(Long id);

    @Select("SELECT * FROM product_intro WHERE id=#{id}")
    public ProductIntro findById(Long id);


}
