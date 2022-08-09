package com.gusrylmubarok.ecommerce.grpc.server.repository;

import com.gusrylmubarok.ecommerce.grpc.grpc.v1.CaptureChargeReq;
import com.gusrylmubarok.ecommerce.grpc.grpc.v1.ChargeId;
import com.gusrylmubarok.ecommerce.grpc.grpc.v1.CreateChargeReq;
import com.gusrylmubarok.ecommerce.grpc.grpc.v1.CustomerId;
import com.gusrylmubarok.ecommerce.grpc.grpc.v1.UpdateChargeReq;
import org.springframework.stereotype.Repository;

@Repository
public class ChargeRepositoryImpl implements ChargeRepository {

  private DbStore dbStore;

  public ChargeRepositoryImpl(DbStore dbStore) {
    this.dbStore = dbStore;
  }

  @Override
  public CreateChargeReq.Response create(CreateChargeReq req) {
    return dbStore.createCharge(req);
  }

  @Override
  public UpdateChargeReq.Response update(UpdateChargeReq req) {
    return dbStore.updateCharge(req);
  }

  @Override
  public ChargeId.Response retrieve(String chargeId) {
    return dbStore.retrieveCharge(chargeId);
  }

  @Override
  public CaptureChargeReq.Response capture(CaptureChargeReq req) {
    return dbStore.captureCharge(req);
  }

  @Override
  public CustomerId.Response retrieveAll(String customerId) {
    return dbStore.retrieveAllCharges(customerId);
  }
}
