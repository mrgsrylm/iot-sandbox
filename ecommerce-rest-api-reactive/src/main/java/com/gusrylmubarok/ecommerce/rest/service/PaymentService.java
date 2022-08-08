package com.gusrylmubarok.ecommerce.rest.service;

import com.gusrylmubarok.ecommerce.rest.entity.AuthorizationEntity;
import com.gusrylmubarok.ecommerce.rest.model.PaymentReq;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import reactor.core.publisher.Mono;

public interface PaymentService {
  Mono<AuthorizationEntity> authorize(@Valid Mono<PaymentReq> paymentReq);
  Mono<AuthorizationEntity> getOrdersPaymentAuthorization(@NotNull String orderId);
}
