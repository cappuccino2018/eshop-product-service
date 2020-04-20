package com.roncoo.eshop.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * Description:
 *
 * @author 陈思男
 * @date 2020年04月14日 22:20
 */
@SpringBootApplication
@EnableEurekaClient
public class  EshopProductServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EshopProductServiceApplication.class,args);
    }




}
