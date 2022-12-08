package com.dabong.bootapi.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
public class ViewConfig implements WebMvcConfigurer {

	    @Override
	    public void configureContentNegotiation(final ContentNegotiationConfigurer configurer) {
	        configurer.ignoreAcceptHeader(true)
	            .useRegisteredExtensionsOnly(true)
	            .defaultContentType(MediaType.APPLICATION_JSON)
	            .mediaType("do", MediaType.TEXT_HTML)
	            .mediaType("json", MediaType.APPLICATION_JSON)
	            .mediaType("xml", MediaType.APPLICATION_XML);

	    }

		@Bean
		public ViewResolver internalResourceViewResolver() {
			final InternalResourceViewResolver bean = new InternalResourceViewResolver();

			bean.setViewClass(JstlView.class);
			bean.setPrefix("/WEB-INF/views/");
			bean.setSuffix(".jsp");
			bean.setOrder(1);

			return bean;
		}

		@Bean
		public MappingJackson2JsonView jsonView() {

			return new MappingJackson2JsonView();

		}

//		@Bean
//		public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
//
//			List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
//
//		    resolvers.add(internalResourceViewResolver());
//
//		    ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
//		    resolver.setViewResolvers(resolvers);
//		    resolver.setContentNegotiationManager(manager);
//		    resolver.setOrder(1);
//
//		    return resolver;
//		}

}
