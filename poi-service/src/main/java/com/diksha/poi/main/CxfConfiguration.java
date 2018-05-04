package com.diksha.poi.main;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:config/poi-servlet.xml")
public class CxfConfiguration {
	
	@Bean
    public ServletRegistrationBean cxfServlet() {
        ServletRegistrationBean servlet = new ServletRegistrationBean(new CXFServlet(), "/services/*");
        servlet.setLoadOnStartup(1);
        return servlet;
    }

}
