package com.gusrylmubarok.ecommerce.grpc.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class GrpcClientRunner implements CommandLineRunner {
  private final Logger LOG = LoggerFactory.getLogger(getClass());
  @Autowired
  GrpcClient client;

  @Override
  public void run(String... args) {
    client.start();

    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      try {
        client.shutdown();
      } catch (InterruptedException e) {
        LOG.error("Client stopped with error: {}", e.getMessage());
      }
    }));
  }
}
