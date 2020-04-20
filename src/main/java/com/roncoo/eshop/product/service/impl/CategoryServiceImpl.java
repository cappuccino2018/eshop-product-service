package com.roncoo.eshop.product.service.impl;

import com.roncoo.eshop.product.mapper.CategoryMaper;
import com.roncoo.eshop.product.model.Category;
import com.roncoo.eshop.product.rabbitmq.RabbitMQSender;
import com.roncoo.eshop.product.rabbitmq.RabbitQueue;
import com.roncoo.eshop.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author 陈思男
 * @date 2020年04月15日 9:17
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMaper categoryMaper;
    @Autowired
    private RabbitMQSender rabbitMQSender;

    @Override
    public void addCategory(Category category,String operationType) {
        categoryMaper.addCategory(category);
        String queue=null;

        if(operationType==null || "".equals(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        rabbitMQSender.send(queue,"{\"event_type\" : \"add\" , \"data_type\" : \"category\",\"id\":" + category.getId() + "}");
    }

    @Override
    public void updateCategory(Category category,String operationType) {
        categoryMaper.updateCategory(category);
        String queue=null;

        if(operationType==null || "".equals(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        rabbitMQSender.send(queue,"{\"event_type\" : \"update\" , \"data_type\" : \"category\",\"id\":" + category.getId() + "}");
    }

    @Override
    public void deleteCategory(Long id,String operationType) {
        categoryMaper.deleteCategory(id);
        String queue=null;

        if(operationType==null || "".equals(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        rabbitMQSender.send(queue,"{\"event_type\" : \"delete\" , \"data_type\" : \"category\",\"id\":" + id + "}");
    }

    @Override
    public Category findById(Long id) {
        return categoryMaper.findById(id);
    }


}
