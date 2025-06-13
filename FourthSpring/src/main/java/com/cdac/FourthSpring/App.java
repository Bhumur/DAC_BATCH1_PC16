package com.cdac.FourthSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.cdac.FourthSpring.components.User;
import com.cdac.FourthSpring.config.ApplicationConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try(AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class)){
        	User user1 = (User)context.getBean("objUser");
        	User user2 = (User)context.getBean("objUser");
        	
        	System.out.println(user1);
        	System.out.println(user2);
        }
    }
}
