package com.camunda.consulting.sb_test3;

import org.apache.catalina.Manager;
import org.apache.catalina.session.StandardManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TomcatConfiguration {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(TomcatConfiguration.class);
  
  @Value("${server.tomcat.jvmroute}")
  private String jvmRoute;

  @Bean
  public WebServerFactoryCustomizer<TomcatServletWebServerFactory> tomcatCustomizer() {
    return (tomcat) -> tomcat.addContextCustomizers((context) -> {
      Manager manager = context.getManager();
      if (manager == null) {
        manager = new StandardManager();
        context.setManager(manager);
      }
      manager.getSessionIdGenerator().setJvmRoute(jvmRoute);
      LOGGER.info("add jvmRoute as {}", jvmRoute);
      LOGGER.info("Sample SessionId: {}", manager.getSessionIdGenerator().generateSessionId());
    });
  }
}
