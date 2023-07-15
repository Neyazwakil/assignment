package com.neyaz.UserManagement.beanfactory;
import com.neyaz.UserManagement.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Configuration
public class BeanFactory {
    @Bean
    public Map<Integer, User> getUserMap()
    {
        return new HashMap<>();
    }
}