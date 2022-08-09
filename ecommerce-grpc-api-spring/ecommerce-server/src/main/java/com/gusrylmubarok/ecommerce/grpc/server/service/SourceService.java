package com.gusrylmubarok.ecommerce.grpc.server.service;

import com.gusrylmubarok.ecommerce.grpc.grpc.v1.AttachOrDetachReq;
import com.gusrylmubarok.ecommerce.grpc.grpc.v1.CreateSourceReq;
import com.gusrylmubarok.ecommerce.grpc.grpc.v1.SourceId;
import com.gusrylmubarok.ecommerce.grpc.grpc.v1.*;
import com.gusrylmubarok.ecommerce.grpc.grpc.v1.UpdateSourceReq;
import com.gusrylmubarok.ecommerce.grpc.server.exception.ExceptionUtils;
import com.gusrylmubarok.ecommerce.grpc.server.repository.SourceRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

@Service
public class SourceService extends SourceServiceGrpc.SourceServiceImplBase {

  private SourceRepository repository;

  public SourceService(SourceRepository repository) {
    this.repository = repository;
  }

  @Override
  public void create(CreateSourceReq req, StreamObserver<CreateSourceReq.Response> resObserver) {
    CreateSourceReq.Response resp = repository.create(req);
    resObserver.onNext(resp);
    resObserver.onCompleted();
  }

  @Override
  public void retrieve(SourceId sourceId, StreamObserver<SourceId.Response> resObserver) {
    try {
      SourceId.Response resp = repository.retrieve(sourceId.getId());
      resObserver.onNext(resp);
      resObserver.onCompleted();
    } catch (Exception e) {
      ExceptionUtils.observeError(resObserver, e, SourceId.Response.getDefaultInstance());
    }
  }

  @Override
  public void update(UpdateSourceReq req, StreamObserver<UpdateSourceReq.Response> resObserver) {
    UpdateSourceReq.Response resp = repository.update(req);
    resObserver.onNext(resp);
    resObserver.onCompleted();
  }

  @Override
  public void attach(AttachOrDetachReq req, StreamObserver<AttachOrDetachReq.Response> resObserver) {
    AttachOrDetachReq.Response resp = repository.attach(req);
    resObserver.onNext(resp);
    resObserver.onCompleted();
  }

  @Override
  public void detach(AttachOrDetachReq req, StreamObserver<AttachOrDetachReq.Response> resObserver) {
    AttachOrDetachReq.Response resp = repository.detach(req);
    resObserver.onNext(resp);
    resObserver.onCompleted();
  }
}
