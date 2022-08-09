package com.gusrylmubarok.ecommerce.grpc.server.service;

import com.gusrylmubarok.ecommerce.grpc.grpc.v1.CaptureChargeReq;
import com.gusrylmubarok.ecommerce.grpc.grpc.v1.ChargeId;
import com.gusrylmubarok.ecommerce.grpc.grpc.v1.*;
import com.gusrylmubarok.ecommerce.grpc.grpc.v1.CreateChargeReq;
import com.gusrylmubarok.ecommerce.grpc.grpc.v1.CustomerId;
import com.gusrylmubarok.ecommerce.grpc.grpc.v1.UpdateChargeReq;
import com.gusrylmubarok.ecommerce.grpc.server.repository.ChargeRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

@Service
public class ChargeService extends ChargeServiceGrpc.ChargeServiceImplBase {

  private final ChargeRepository repository;

  public ChargeService(ChargeRepository repository) {
    this.repository = repository;
  }

  @Override
  public void create(CreateChargeReq req, StreamObserver<CreateChargeReq.Response> resObserver) {
    CreateChargeReq.Response resp = repository.create(req);
    resObserver.onNext(resp);
    resObserver.onCompleted();
  }

  @Override
  public void retrieve(ChargeId chargeId, StreamObserver<ChargeId.Response> resObserver) {
    ChargeId.Response resp = repository.retrieve(chargeId.getId());
    resObserver.onNext(resp);
    resObserver.onCompleted();
  }

  @Override
  public void update(UpdateChargeReq req, StreamObserver<UpdateChargeReq.Response> resObserver) {
    UpdateChargeReq.Response resp = repository.update(req);
    resObserver.onNext(resp);
    resObserver.onCompleted();
  }

  @Override
  public void capture(CaptureChargeReq req, StreamObserver<CaptureChargeReq.Response> resObserver) {
    CaptureChargeReq.Response resp = repository.capture(req);
    resObserver.onNext(resp);
    resObserver.onCompleted();
  }

  @Override
  public void retrieveAll(CustomerId customerId, StreamObserver<CustomerId.Response> resObserver) {
    CustomerId.Response resp = repository.retrieveAll(customerId.getId());
    resObserver.onNext(resp);
    resObserver.onCompleted();
  }
}
