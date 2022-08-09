package com.gusrylmubarok.ecommerce.grpc.server.repository;

import com.gusrylmubarok.ecommerce.grpc.grpc.v1.CaptureChargeReq;
import com.gusrylmubarok.ecommerce.grpc.grpc.v1.ChargeId;
import com.gusrylmubarok.ecommerce.grpc.grpc.v1.CreateChargeReq;
import com.gusrylmubarok.ecommerce.grpc.grpc.v1.CustomerId;
import com.gusrylmubarok.ecommerce.grpc.grpc.v1.UpdateChargeReq;

public interface ChargeRepository {
  CreateChargeReq.Response create(CreateChargeReq req);
  UpdateChargeReq.Response update(UpdateChargeReq req);
  ChargeId.Response retrieve(String chargeId);
  CaptureChargeReq.Response capture(CaptureChargeReq req);
  CustomerId.Response retrieveAll(String customerId);
}
