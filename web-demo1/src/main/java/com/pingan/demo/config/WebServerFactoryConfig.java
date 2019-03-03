package com.pingan.demo.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * WebServerFactory 配置
 * @author TANGJIAN
 * @since 2019-03-03 14:20
 */
@Configuration
public class WebServerFactoryConfig {
    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> customizer() {
        return (factory) -> {
            factory.addContextCustomizers((context) -> {
                        String relativePath = "web-demo1/src/main/webapp";
                        // 相对于 user.dir = D:\workspace\dive-in-spring-boot
                        File docBaseFile = new File(relativePath);
                        if (docBaseFile.exists()) { // 路径是否存在
                            // 解决 Maven 多模块 JSP 无法读取的问题
                            context.setDocBase(docBaseFile.getAbsolutePath());
                        }
                    }
            );
        };
    }
}
