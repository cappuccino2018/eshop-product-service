package com.roncoo.eshop.product.mapper;

import com.roncoo.eshop.product.model.Brand;
import com.roncoo.eshop.product.model.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BrandMaper {

    @Insert("INSERT INTO brand(name,description) VALUES(#{name},#{description})")
    public void addBrand(Brand brand);

    @Update("UPDATE brand set name=#{name},description=#{description} WHERE id=#{id}")
    public void updateBrand(Brand brand);

    @Delete("DELETE FROM brand WHERE id=#{id}")
    public void deleteBrand(Long id);

    @Select("SELECT * FROM brand WHERE id=#{id}")
    public Brand findById(Long id);

    @Select("SELECT * FROM brand WHERE id in (${ids})")
    public List<Brand> findByIds(@Param("ids") String ids);


}
