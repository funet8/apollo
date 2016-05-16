package com.ctrip.apollo.common.controller;

import javax.servlet.DispatcherType;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
public class CharacterEncodingFilterConfiguration {

  @Bean
  public FilterRegistrationBean encodingFilter() {
    FilterRegistrationBean bean = new FilterRegistrationBean();
    bean.setFilter(new CharacterEncodingFilter());
    bean.addInitParameter("encoding", "UTF-8");
    //FIXME: https://github.com/Netflix/eureka/issues/702
//    bean.addInitParameter("forceEncoding", "true");
    bean.setName("encodingFilter");
    bean.addUrlPatterns("/*");
    bean.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD);
    return bean;
  }
}
