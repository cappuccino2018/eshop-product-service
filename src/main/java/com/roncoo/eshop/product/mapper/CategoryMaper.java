package com.roncoo.eshop.product.mapper;

import com.roncoo.eshop.product.model.Category;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CategoryMaper {

    @Insert("INSERT INTO category(name,description) VALUES(#{name},#{description})")
    public void addCategory(Category category);

    @Update("UPDATE category set name=#{name},description=#{description} WHERE id=#{id}")
    public void updateCategory(Category category);

    @Delete("DELETE FROM category WHERE id=#{id}")
    public void deleteCategory(Long id);

    @Select("SELECT * FROM category WHERE id=#{id}")
    public Category findById(Long id);


}
