package com.gusrylmubarok.ecommerce.rest.controller;

import com.gusrylmubarok.ecommerce.rest.PaymentApi;
import com.gusrylmubarok.ecommerce.rest.hateoas.PaymentRepresentationModelAssembler;
import com.gusrylmubarok.ecommerce.rest.model.Authorization;
import com.gusrylmubarok.ecommerce.rest.model.PaymentReq;
import com.gusrylmubarok.ecommerce.rest.service.PaymentService;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
public class PaymentController implements PaymentApi {
  private PaymentService service;
  private final PaymentRepresentationModelAssembler assembler;

  public PaymentController(PaymentService service, PaymentRepresentationModelAssembler assembler) {
    this.service = service;
    this.assembler = assembler;
  }

  @Override
  public Mono<ResponseEntity<Authorization>> authorize(@Valid Mono<PaymentReq> paymentReq, ServerWebExchange exchange) {
    return null;
  }

  @Override
  public Mono<ResponseEntity<Authorization>> getOrdersPaymentAuthorization(
      @NotNull @Valid String id, ServerWebExchange exchange) {
    return null;
  }
}
