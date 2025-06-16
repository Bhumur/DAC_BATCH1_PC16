package com.cdac.config;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.cdac.entity.User;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.cdac.controllers")
@PropertySource("classpath:application.properties")
public class SpringWebMVCConfiguration implements WebMvcConfigurer {

	@Autowired
	Environment env;
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		System.out.println("bean ss");
		return viewResolver;
	}
	
	@Bean
	public SessionFactory hiberSession() {
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
	public LocaleResolver localeResolver() {
		return new CookieLocaleResolver();
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		System.out.println("locale........");
		return localeChangeInterceptor;
	}
	

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());		
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource msgSource = new ResourceBundleMessageSource();
		msgSource.setBasenames("message");
		msgSource.setDefaultLocale(Locale.ENGLISH);
		return msgSource;
	}
}
