package com.roncoo.eshop.product.service.impl;

import com.roncoo.eshop.product.mapper.BrandMaper;
import com.roncoo.eshop.product.mapper.ProductMaper;
import com.roncoo.eshop.product.model.Brand;
import com.roncoo.eshop.product.model.Product;
import com.roncoo.eshop.product.rabbitmq.RabbitMQSender;
import com.roncoo.eshop.product.rabbitmq.RabbitQueue;
import com.roncoo.eshop.product.service.BrandService;
import com.roncoo.eshop.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author 陈思男
 * @date 2020年04月15日 9:17
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMaper productMaper;
    @Autowired
    private RabbitMQSender rabbitMQSender;

    @Override
    public void addProduct(Product product,String operationType) {
        productMaper.addProduct(product);
        String queue=null;

        if(operationType==null || "".equals(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        rabbitMQSender.send(queue,"{\"event_type\" : \"add\" , \"data_type\" : \"product\",\"id\":" + product.getId() + "}");

    }

    @Override
    public void updateProduct(Product product,String operationType) {
        productMaper.updateProduct(product);
        String queue=null;

        if(operationType==null || "".equals(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        rabbitMQSender.send(queue,"{\"event_type\" : \"update\" , \"data_type\" : \"product\",\"id\":" + product.getId() + "}");
    }

    @Override
    public void deleteProduct(Long id,String operationType) {
        productMaper.deleteProduct(id);
        String queue=null;

        if(operationType==null || "".equals(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        rabbitMQSender.send(queue,"{\"event_type\" : \"delete\" , \"data_type\" : \"product\",\"id\":" + id + "}");
    }

    @Override
    public Product findById(Long id) {
        return productMaper.findById(id);
    }


}
