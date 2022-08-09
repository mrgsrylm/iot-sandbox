package com.gusrylmubarok.ecommerce.grpc.server.repository;

import com.gusrylmubarok.ecommerce.grpc.grpc.v1.AttachOrDetachReq;
import com.gusrylmubarok.ecommerce.grpc.grpc.v1.CreateSourceReq;
import com.gusrylmubarok.ecommerce.grpc.grpc.v1.SourceId;
import com.gusrylmubarok.ecommerce.grpc.grpc.v1.UpdateSourceReq;
import org.springframework.stereotype.Repository;

@Repository
public class SourceRepositoryImpl implements SourceRepository {
  private DbStore dbStore;

  public SourceRepositoryImpl(DbStore dbStore) {
    this.dbStore = dbStore;
  }

  @Override
  public UpdateSourceReq.Response update(UpdateSourceReq req) {
    return dbStore.updateSource(req);
  }

  @Override
  public CreateSourceReq.Response create(CreateSourceReq req) {
    return dbStore.createSource(req);
  }

  @Override
  public SourceId.Response retrieve(String sourceId) {
    return dbStore.retrieveSource(sourceId);
  }

  @Override
  public AttachOrDetachReq.Response attach(AttachOrDetachReq req) {
    return dbStore.attach(req);
  }

  @Override
  public AttachOrDetachReq.Response detach(AttachOrDetachReq req) {
    return dbStore.detach(req);
  }
}
