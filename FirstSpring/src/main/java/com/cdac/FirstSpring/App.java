package com.cdac.FirstSpring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.FirstSpring.component.User;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try(AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");){
    		User user = (User)context.getBean("objUser");
    		
            System.out.println(user);
    	}
    }
}
