package com.cdac.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import com.cdac.config.SpringWebMVCConfiguration;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class WebMVCInitilizer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.setServletContext(servletContext);
		
		
		ServletRegistration.Dynamic frontController = servletContext.addServlet("primaryControler", new DispatcherServlet(webContext));
		frontController.setLoadOnStartup(10);
		frontController.addMapping("/spring/*");
		System.out.println("hello");
		webContext.register(SpringWebMVCConfiguration.class);
	}

}
