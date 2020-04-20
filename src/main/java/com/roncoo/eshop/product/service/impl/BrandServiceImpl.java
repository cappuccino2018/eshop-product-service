package com.roncoo.eshop.product.service.impl;

import com.roncoo.eshop.product.mapper.BrandMaper;
import com.roncoo.eshop.product.model.Brand;
import com.roncoo.eshop.product.rabbitmq.RabbitMQSender;
import com.roncoo.eshop.product.rabbitmq.RabbitQueue;
import com.roncoo.eshop.product.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @author 陈思男
 * @date 2020年04月15日 9:17
 */

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMaper brandMaper;
    @Autowired
    private RabbitMQSender rabbitMQSender;

    @Override
    public void addBrand(Brand brand,String operationType) {
        brandMaper.addBrand(brand);

        String queue=null;

        if(operationType==null || "".equals(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }

        rabbitMQSender.send(queue,"{\"event_type\" : \"add\" , \"data_type\" : \"brand\",\"id\":" + brand.getId() + "}");
    }

    @Override
    public void updateBrand(Brand brand,String operationType) {
        brandMaper.updateBrand(brand);
        String queue=null;

        System.out.println("operationtype="+operationType);
        if(operationType==null || "".equals(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        System.out.println("queue="+queue);
        rabbitMQSender.send(queue,"{\"event_type\" : \"update\" , \"data_type\" : \"brand\",\"id\":" + brand.getId() + "}");
    }

    @Override
    public void deleteBrand(Long id,String operationType) {
        brandMaper.deleteBrand(id);
        String queue=null;

        if(operationType==null || "".equals(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        rabbitMQSender.send(queue,"{\"event_type\" : \"delete\" , \"data_type\" : \"brand\",\"id\":" + id + "}");
    }

    @Override
    public Brand findById(Long id) {
        return brandMaper.findById(id);

    }

    @Override
    public List<Brand> findByIds(String ids) {
        return brandMaper.findByIds(ids);
    }
}
