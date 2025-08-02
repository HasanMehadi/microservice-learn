package com.microservices.card;

import com.microservices.card.dto.CardsContactInfoDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableConfigurationProperties(CardsContactInfoDto.class)
@EnableDiscoveryClient
public class CardApplication {

    public static void main(String[] args) {
        try{
            SpringApplication.run(CardApplication.class, args);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
