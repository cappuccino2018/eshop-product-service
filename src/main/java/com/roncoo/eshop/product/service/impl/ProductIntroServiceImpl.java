package com.roncoo.eshop.product.service.impl;

import com.roncoo.eshop.product.mapper.ProductIntroMaper;
import com.roncoo.eshop.product.mapper.ProductPropertyMaper;
import com.roncoo.eshop.product.model.ProductIntro;
import com.roncoo.eshop.product.model.ProductProperty;
import com.roncoo.eshop.product.rabbitmq.RabbitMQSender;
import com.roncoo.eshop.product.rabbitmq.RabbitQueue;
import com.roncoo.eshop.product.service.ProductIntroService;
import com.roncoo.eshop.product.service.ProductPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author 陈思男
 * @date 2020年04月15日 9:17
 */

@Service
public class ProductIntroServiceImpl implements ProductIntroService {

    @Autowired
    private ProductIntroMaper productIntroMaper;
    @Autowired
    private RabbitMQSender rabbitMQSender;

    @Override
    public void addProductIntro(ProductIntro productIntro,String operationType) {
        productIntroMaper.addProductIntro(productIntro);
        String queue=null;

        if(operationType==null || "".equals(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        rabbitMQSender.send(queue,"{\"event_type\" : \"add\" , \"data_type\" : \"product_intro\",\"id\":" + productIntro.getId() + ",\"product_id\":" +productIntro.getProductId() +"}");
    }

    @Override
    public void updateProductIntro(ProductIntro productIntro,String operationType) {
        productIntroMaper.updateProductIntro(productIntro);
        String queue=null;

        if(operationType==null || "".equals(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        rabbitMQSender.send(queue,"{\"event_type\" : \"update\" , \"data_type\" : \"product_intro\",\"id\":" + productIntro.getId() + ",\"product_id\":" +productIntro.getProductId() +"}");
    }

    @Override
    public void deleteProductIntro(Long id,String operationType) {
        ProductIntro productIntro = findById(id);
        productIntroMaper.deleteProductIntro(id);
        String queue=null;

        if(operationType==null || "".equals(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        rabbitMQSender.send(queue,"{\"event_type\" : \"delete\" , \"data_type\" : \"product_intro\",\"id\":" + id + ",\"product_id\":" +productIntro.getProductId() + "}");
    }

    @Override
    public ProductIntro findById(Long id) {
        return productIntroMaper.findById(id);
    }


}
