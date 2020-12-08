package com.ra2ocde.springsecuritydemo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class<?> configurationClasses[] = { DemoAppConfig.class };
		return configurationClasses;
	}

	@Override
	protected String[] getServletMappings() {
		String servletMappings[] = { "/" };
		return servletMappings;
	}
	
}
