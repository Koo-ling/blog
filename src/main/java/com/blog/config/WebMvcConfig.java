package com.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {

		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/single").setViewName("single");
		registry.addViewController("/logout").setViewName("index");
		registry.addViewController("/publish").setViewName("publish");
		registry.addViewController("/403").setViewName("403");

	}


}
