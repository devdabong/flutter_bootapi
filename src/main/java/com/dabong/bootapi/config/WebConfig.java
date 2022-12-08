package com.dabong.bootapi.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}


	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new ControllerInterceptor())
//		.excludePathPatterns("/js/**", "/css/**", "/fonts/**", "/images/**");
	}

//	@Bean
//	public MessageSource messageSource() throws Exception {
//		CustomReloadableResourceBundleMessageSource message = new CustomReloadableResourceBundleMessageSource();
//		message.setDefaultEncoding("UTF-8");
//		message.setCacheSeconds(60);
//		message.setBasename("classpath:/message/message");
//		return message;
//	}
}
