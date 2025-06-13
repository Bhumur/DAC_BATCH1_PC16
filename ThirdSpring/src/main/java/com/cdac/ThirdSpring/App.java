package com.cdac.ThirdSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.cdac.ThirdSpring.components.User;
import com.cdac.ThirdSpring.config.ApplicationConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try(AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class)){
        	User user = (User)context.getBean("objUser");
        	System.out.println(user);
        }
    }
}
