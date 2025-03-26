package com.example.demo.config;

import javax.annotation.PostConstruct;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;  // ✅ Corrected import
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.core.io.ClassPathResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(WebServiceConfig.class);

    @PostConstruct
    public void init() {
        logger.info("✅ WebServiceConfig loaded successfully!");
    }

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);  // ✅ Removed incorrect casting
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");  // ✅ Corrected URL mapping
    }

    @Bean(name = "stock")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema stockSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("StockPort");
        wsdl11Definition.setLocationUri("/ws");  // ✅ Ensured consistency
        wsdl11Definition.setTargetNamespace("http://example.com/stock");
        wsdl11Definition.setSchema(stockSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema stockSchema() {
        return new SimpleXsdSchema(new ClassPathResource("stock.xsd"));
    }
}
