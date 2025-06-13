package com.cdac.SecondSpring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.SecondSpring.components.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try(AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml")){
        	User user1 = (User)context.getBean("objUser");
        	User user2 = (User)context.getBean("objUser");
        	
        	System.out.println(user1);
        	System.out.println(user2);
        }
    }
}
