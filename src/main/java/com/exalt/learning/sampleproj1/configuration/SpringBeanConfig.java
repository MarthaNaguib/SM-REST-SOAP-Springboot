package com.exalt.learning.sampleproj1.configuration;
import com.exalt.learning.sampleproj1.SOAPconnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SpringBeanConfig {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this is the package name specified in the <generatePackage>
        marshaller.setContextPath("simplesolution.dev");
        return marshaller;
    }

    @Bean
    public SOAPconnection soapConnector(Jaxb2Marshaller marshaller) {
        SOAPconnection client = new SOAPconnection();
        client.setDefaultUri("http://localhost:8080/soapws/buckets.wsdl");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
