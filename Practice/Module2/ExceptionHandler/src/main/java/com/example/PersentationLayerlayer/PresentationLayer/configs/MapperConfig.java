package com.example.PersentationLayerlayer.PresentationLayer.configs;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.PublicKey;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper getModelMapper(){
        return  new ModelMapper();
    }
}
