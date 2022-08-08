package com.gusrylmubarok.ecommerce.rest.service;

import com.gusrylmubarok.ecommerce.rest.entity.AuthorizationEntity;
import com.gusrylmubarok.ecommerce.rest.model.PaymentReq;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface PaymentService {
  public Optional<AuthorizationEntity> authorize(@Valid PaymentReq paymentReq);
  public Optional<AuthorizationEntity> getOrdersPaymentAuthorization(@NotNull String orderId);
}
