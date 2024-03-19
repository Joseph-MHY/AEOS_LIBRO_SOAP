package pe.edu.idat;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet>
            messageDispatcherServlet (ApplicationContext ac){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(ac);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet,"/ws/*");
    }

    @Bean(name = "libros")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema librosSchema){
        DefaultWsdl11Definition wsd11 = new DefaultWsdl11Definition();
        wsd11.setPortTypeName("LibrosPort");
        wsd11.setTargetNamespace("http://idat.edu.pe/ws");
        wsd11.setSchema(librosSchema);
        return wsd11;
    }

    @Bean
    public XsdSchema librosSchema(){
        return new SimpleXsdSchema(new ClassPathResource("libros.xsd"));
    }
}
