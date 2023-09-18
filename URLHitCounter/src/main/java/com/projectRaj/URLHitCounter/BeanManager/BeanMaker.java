package com.projectRaj.URLHitCounter.BeanManager;


import com.projectRaj.URLHitCounter.Entity.UrlHitCounter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeanMaker {

    @Bean
    public List<UrlHitCounter> getUrlHitCounterList(){
        System.out.println("Empty repository initialized & ready to accept data !!!!!!!!!!!");
        return new ArrayList<>();
    }
}