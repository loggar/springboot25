package com.loggar.rest_example.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.scan("com.loggar.springboot21");
		container.addListener(new ContextLoaderListener(context));

		ServletRegistration.Dynamic dispatcher = container.addServlet("mvc", new DispatcherServlet(context));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}
}

/*
 * Here, we’re creating a Spring context using the AnnotationConfigWebApplicationContext class,which means we’re using only annotation-based configuration. Then, we’re specifying the packages to scan for components and configuration classes.
 * 
 * Finally, we’re defining the entry point for the web application – the DispatcherServlet.
 * 
 * This class can entirely replace the web.xml file from <3.0 Servlet versions.
 */

// web.xml dispatchers(entry points) equivalent
//
// <servlet>
// <servlet-name>dispatcher</servlet-name>
// <servlet-class>
// org.springframework.web.servlet.DispatcherServlet
// </servlet-class>
// <init-param>
// <param-name>contextConfigLocation</param-name>
// <param-value>/WEB-INF/spring/dispatcher-config.xml</param-value>
// </init-param>
// <load-on-startup>1</load-on-startup>
// </servlet>
//
// <servlet-mapping>
// <servlet-name>dispatcher</servlet-name>
// <url-pattern>/</url-pattern>
// </servlet-mapping>