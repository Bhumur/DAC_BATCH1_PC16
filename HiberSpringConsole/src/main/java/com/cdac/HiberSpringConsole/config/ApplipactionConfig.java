package com.cdac.HiberSpringConsole.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.cdac.HiberSpringConsole.DAO.UserDAO;
import com.cdac.HiberSpringConsole.DAO.UserDAOImpl;
import com.cdac.HiberSpringConsole.entity.User;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplipactionConfig {
	
	@Autowired
	Environment env;
	
	@Bean
	public SessionFactory hiberConfig() {
		org.hibernate.cfg.Configuration Config = new org.hibernate.cfg.Configuration();
		Properties hiberProperties = new Properties();
		System.out.println(env.getProperty("hiber.connection"));
		hiberProperties.setProperty("hibernate.connection.driver_class", env.getProperty("hiber.connection"));
		hiberProperties.setProperty("hibernate.connection.username", env.getProperty("hiber.username"));
		hiberProperties.setProperty("hibernate.connection.password", env.getProperty("hiber.password"));
		hiberProperties.setProperty("hibernate.connection.url", env.getProperty("hiber.url"));
		hiberProperties.setProperty("hibernate.hibernate.dialect", env.getProperty("hiber.dialect"));
		hiberProperties.setProperty("hibernate.hdm2ddl.auto", env.getProperty("hiber.auto"));
		hiberProperties.setProperty("hibernate.show_sql", env.getProperty("hiber.show_sql"));
		Config.addProperties(hiberProperties);	
		Config.addAnnotatedClass(User.class);
		return Config.buildSessionFactory();
	}
	
	@Bean
	public User objUser() {
		return new User();
	}
	
	@Bean
	public UserDAO objUserDAO() {
		return new UserDAOImpl();
	}
}
