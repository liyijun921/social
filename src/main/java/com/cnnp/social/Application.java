package com.cnnp.social;

import com.cnnp.social.base.BaseSetting;
import com.cnnp.social.news.manager.NewsSetting;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableCaching
@EnableConfigurationProperties({NewsSetting.class,BaseSetting.class})
public class Application {
//extends SpringBootServletInitializer
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    	//System.out.println(new Date());
    }
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(Application.class);
//    }
//	@Bean
//	public UndertowEmbeddedServletContainerFactory embeddedServletContainerFactory() {
//	    UndertowEmbeddedServletContainerFactory factory = new UndertowEmbeddedServletContainerFactory();
//	   // factory.
//	    //factory
//	    factory.addBuilderCustomizers(new UndertowBuilderCustomizer() {
//
//			@Override
//			public void customize(Undertow.Builder builder) {
//
//				builder.addHttpListener(8080, "0.0.0.0");
//
//			}
//
//
//	    });
//	    return factory;
//	}
}
