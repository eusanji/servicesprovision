package com.servicesprovision;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean( name = "applicationName")
    public String applicationName(){
        return "Sell system";
    }
}
