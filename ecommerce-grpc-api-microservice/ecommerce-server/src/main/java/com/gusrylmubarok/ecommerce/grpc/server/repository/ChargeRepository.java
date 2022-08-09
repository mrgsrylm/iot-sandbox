package com.gusrylmubarok.ecommerce.grpc.server.repository;

import com.gusrylubarok.ecommerce.grpc.grpc.v1.*;

public interface ChargeRepository {

  CreateChargeReq.Response create(CreateChargeReq req);

  UpdateChargeReq.Response update(UpdateChargeReq req);

  ChargeId.Response retrieve(String chargeId);

  CaptureChargeReq.Response capture(CaptureChargeReq req);

  CustomerId.Response retrieveAll(String customerId);
}
