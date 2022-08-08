package com.gusrylmubarok.ecommerce.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.h2.tools.Server;

@Component
public class H2ConsoleComponent {
    private final static Logger log = LoggerFactory.getLogger(H2ConsoleComponent.class);

    private Server webServer;

    @Value("${ecommrce.api.h2.console.port:8081}")
    Integer h2ConsolePort;

    @EventListener(ContextRefreshedEvent.class)
    public void start() throws java.sql.SQLException {
      log.info("starting h2 console at port "+h2ConsolePort);
      this.webServer = org.h2.tools.Server.createWebServer("-webPort", h2ConsolePort.toString(), "-tcpAllowOthers").start();
    }

    @EventListener(ContextClosedEvent.class)
    public void stop() {
      log.info("stopping h2 console at port "+h2ConsolePort);
      this.webServer.stop();
    }
}
