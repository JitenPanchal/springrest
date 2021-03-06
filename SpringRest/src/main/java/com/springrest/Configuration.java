package com.springrest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.springrest.repositories.IUserRepository;
import com.springrest.service.MembershipService;
import com.springrest.service.contracts.IMembershipService;

@org.springframework.context.annotation.Configuration
public class Configuration implements WebMvcConfigurer {

	@Autowired
	ApplicationContext applicationContext;

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorParameter(true).parameterName("format").defaultContentType(MediaType.APPLICATION_JSON)
				.mediaType("xml", MediaType.APPLICATION_XML).mediaType("json", MediaType.APPLICATION_JSON);
	}
	
	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.configureHandlerExceptionResolvers(resolvers);
	}
	
//	@Override
//    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
//        exceptionResolvers.add(new ValidationHandler());
//    }

	@Bean
	public IMembershipService membershipService() {
		return new MembershipService(applicationContext.getBean(IUserRepository.class));
	}
}