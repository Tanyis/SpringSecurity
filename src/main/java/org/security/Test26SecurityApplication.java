package org.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author tanyi
 * @date 2019/8/15 0:44
 */

@SpringBootApplication
public class Test26SecurityApplication {public static void main(String[] args) {
    SpringApplication.run(Test26SecurityApplication.class, args);
}
//    @Bean
//	public FilterRegistrationBean jwtFilterRegistrationBean(){
//		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//		HTTPBearerAuthorizeAttribute httpBearerFilter = new HTTPBearerAuthorizeAttribute();
//		registrationBean.setFilter(httpBearerFilter);
//		List<String> urlPatterns = new ArrayList<String>();
//		urlPatterns.add("/user/getusers");
//		registrationBean.setUrlPatterns(urlPatterns);
//		return registrationBean;
}
