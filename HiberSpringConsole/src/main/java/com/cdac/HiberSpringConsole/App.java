package com.cdac.HiberSpringConsole;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.cdac.HiberSpringConsole.DAO.UserDAO;
import com.cdac.HiberSpringConsole.DAO.UserDAOImpl;
import com.cdac.HiberSpringConsole.config.ApplipactionConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try(AbstractApplicationContext context =  new AnnotationConfigApplicationContext(ApplipactionConfig.class)){
        	UserDAO obj = (UserDAOImpl)context.getBean("objUserDAO");
        	obj.addUser();
        }
    }
}
