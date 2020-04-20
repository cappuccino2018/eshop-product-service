package com.roncoo.eshop.product.service.impl;

import com.roncoo.eshop.product.mapper.BrandMaper;
import com.roncoo.eshop.product.mapper.ProductPropertyMaper;
import com.roncoo.eshop.product.model.Brand;
import com.roncoo.eshop.product.model.ProductProperty;
import com.roncoo.eshop.product.rabbitmq.RabbitMQSender;
import com.roncoo.eshop.product.rabbitmq.RabbitQueue;
import com.roncoo.eshop.product.service.BrandService;
import com.roncoo.eshop.product.service.ProductPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.PrinterURI;

/**
 * Description:
 *
 * @author 陈思男
 * @date 2020年04月15日 9:17
 */

@Service
public class ProductPropertyServiceImpl implements ProductPropertyService {

    @Autowired
    private ProductPropertyMaper productPropertyMaper;
    @Autowired
    private RabbitMQSender rabbitMQSender;

    @Override
    public void addProductProperty(ProductProperty productProperty,String operationType) {
        productPropertyMaper.addProductProperty(productProperty);
        String queue=null;

        if(operationType==null || "".equals(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        rabbitMQSender.send(queue,"{\"event_type\" : \"add\" , \"data_type\" : \"product_property\",\"id\":" + productProperty.getId() + ", \"product_id\": "+ productProperty.getProductId() +"}");

    }

    @Override
    public void updateProductProperty(ProductProperty productProperty,String operationType) {
        productPropertyMaper.updateProductProperty(productProperty);
        String queue=null;

        if(operationType==null || "".equals(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        rabbitMQSender.send(queue,"{\"event_type\" : \"update\" , \"data_type\" : \"product_property\",\"id\":" + productProperty.getId() + ", \"product_id\": "+ productProperty.getProductId() +"}");
    }

    @Override
    public void deleteProductProperty(Long id,String operationType) {
        ProductProperty productProperty = findById(id);
        productPropertyMaper.deleteProductProperty(id);
        String queue=null;

        if(operationType==null || "".equals(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        rabbitMQSender.send(queue,"{\"event_type\" : \"delete\" , \"data_type\" : \"product_property\",\"id\":" + id +", \"product_id\": "+ productProperty.getProductId() + "}");
    }

    @Override
    public ProductProperty findById(Long id) {
        return productPropertyMaper.findById(id);
    }

    @Override
    public ProductProperty findByProductId(Long productId) {
        return productPropertyMaper.findById(productId);
    }


}
