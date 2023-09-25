package com.aamir;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
/*@EnableOAuth2Sso*/
public class InventoryManagmentTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryManagmentTaskApplication.class, args);
    }


    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

}
