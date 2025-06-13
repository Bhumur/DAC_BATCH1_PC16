package com.listner;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Cart;
import com.entity.Category;
import com.entity.Product;
import com.entity.User;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class Initialization
 *
 */
@WebListener
public class Initialization implements ServletContextListener {

	SessionFactory hiberFactory = null;
	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	Configuration hiberConf = new Configuration();
    	Properties property = new Properties();
    	property.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
    	property.setProperty("hibernate.connection.username", "root");
    	property.setProperty("hibernate.connection.password", "cdac");
    	property.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/user_batch1");
    	property.setProperty("hibernate.hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    	property.setProperty("hibernate.hdm2dd/auto", "validate");
    	property.setProperty("hibernate.show_sql", "true");
    	hiberConf.addAnnotatedClass(User.class);
    	hiberConf.addAnnotatedClass(Category.class);
    	hiberConf.addAnnotatedClass(Product.class);
    	hiberConf.addAnnotatedClass(Cart.class);
    	
    	hiberConf.addProperties(property);
    	hiberFactory = hiberConf.buildSessionFactory();
    	sce.getServletContext().setAttribute("hiberFactory", hiberFactory);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         hiberFactory.close();
    }
	
}
