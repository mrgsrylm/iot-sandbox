package com.gusrylmubarok.ecommerce.grpc.client;

import com.gusrylmubarok.ecommerce.grpc.grpc.v1.ChargeServiceGrpc;
import com.gusrylmubarok.ecommerce.grpc.grpc.v1.ChargeServiceGrpc.ChargeServiceBlockingStub;
import com.gusrylmubarok.ecommerce.grpc.grpc.v1.SourceServiceGrpc;
import com.gusrylmubarok.ecommerce.grpc.grpc.v1.SourceServiceGrpc.SourceServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.sleuth.brave.instrument.grpc.GrpcManagedChannelBuilderCustomizer;
import org.springframework.cloud.sleuth.brave.instrument.grpc.SpringAwareManagedChannelBuilder;
import org.springframework.stereotype.Component;

@Component
public class GrpcClient {

  private static final Logger LOG = LoggerFactory.getLogger(GrpcClient.class);
  @Value("${grpc.server.host:localhost}")
  private String host;

  @Value("${grpc.server.port:8080}")
  private int port;

  @Autowired
  private SpringAwareManagedChannelBuilder builder;
  private ManagedChannel channel;
  private SourceServiceBlockingStub sourceServiceStub;
  private ChargeServiceBlockingStub chargeServiceStub;

  public void start() {
    channel = builder.forAddress(host, port).usePlaintext().build();
    sourceServiceStub = SourceServiceGrpc.newBlockingStub(channel);
    chargeServiceStub = ChargeServiceGrpc.newBlockingStub(channel);
    LOG.info("gRPC client connected to {}:{}", host, port);
  }

  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
    LOG.info("gRPC client disconnected successfully.");
  }

  public SourceServiceBlockingStub getSourceServiceStub() {
    return this.sourceServiceStub;
  }

  public ChargeServiceBlockingStub getChargeServiceStub() {
    return this.chargeServiceStub;
  }
}
