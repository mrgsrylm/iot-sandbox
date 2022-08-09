package com.gusrylmubarok.ecommerce.grpc.server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class GrpcServerRunner implements CommandLineRunner {

  private GrpcServer grpcServer;

  public GrpcServerRunner(GrpcServer grpcServer) {
    this.grpcServer = grpcServer;
  }

  @Override
  public void run(String... args) throws Exception {
    grpcServer.start();
    grpcServer.block();
  }
}
