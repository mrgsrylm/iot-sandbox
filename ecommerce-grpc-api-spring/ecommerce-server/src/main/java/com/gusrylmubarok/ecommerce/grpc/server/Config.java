package com.gusrylmubarok.ecommerce.grpc.server;

import brave.grpc.GrpcTracing;
import brave.rpc.RpcTracing;
import io.grpc.ServerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

  @Bean
  public GrpcTracing grpcTracing(RpcTracing rpcTracing) {
    return GrpcTracing.create(rpcTracing);
  }
}
