package com.roncoo.eshop.product.service.impl;

import com.roncoo.eshop.product.mapper.ProductPropertyMaper;
import com.roncoo.eshop.product.mapper.ProductSpecificationMaper;
import com.roncoo.eshop.product.model.ProductProperty;
import com.roncoo.eshop.product.model.ProductSpecification;
import com.roncoo.eshop.product.rabbitmq.RabbitMQSender;
import com.roncoo.eshop.product.rabbitmq.RabbitQueue;
import com.roncoo.eshop.product.service.ProductPropertyService;
import com.roncoo.eshop.product.service.ProductSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author 陈思男
 * @date 2020年04月15日 9:17
 */

@Service
public class ProductSpecificationServiceImpl implements ProductSpecificationService {

    @Autowired
    private ProductSpecificationMaper ProductSpecificationMaper;
    @Autowired
    private RabbitMQSender rabbitMQSender;

    @Override
    public void addProductSpecification(ProductSpecification specification,String operationType) {
        ProductSpecificationMaper.addProductSpecification(specification);
        String queue=null;

        if(operationType==null || "".equals(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        rabbitMQSender.send(queue,"{\"event_type\" : \"add\" , \"data_type\" : \"product_specification\",\"id\":" + specification.getId() + ", \"product_id\": "+specification.getProductId()+"}");

    }

    @Override
    public void updateProductSpecification(ProductSpecification specification,String operationType) {
        ProductSpecificationMaper.updateProductSpecification(specification);
        String queue=null;

        if(operationType==null || "".equals(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        rabbitMQSender.send(queue,"{\"event_type\" : \"update\" , \"data_type\" : \"product_specification\",\"id\":" + specification.getId() + ", \"product_id\": "+specification.getProductId()+"}");
    }

    @Override
    public void deleteProductSpecification(Long id,String operationType) {
        ProductSpecification specification = findById(id);
        ProductSpecificationMaper.deleteProductSpecification(id);
        String queue=null;

        if(operationType==null || "".equals(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        rabbitMQSender.send(queue,"{\"event_type\" : \"delete\" , \"data_type\" : \"product_specification\",\"id\":" + id + ", \"product_id\": "+specification.getProductId()+"}");
    }

    @Override
    public ProductSpecification findById(Long id) {
        return ProductSpecificationMaper.findById(id);
    }

    @Override
    public ProductSpecification findByProductId(Long productId) {
        return ProductSpecificationMaper.findByProductId(productId);
    }
}
