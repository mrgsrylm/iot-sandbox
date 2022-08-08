package com.gusrylmubarok.ecommerce.rest.service;

import com.gusrylmubarok.ecommerce.rest.entity.AuthorizationEntity;
import com.gusrylmubarok.ecommerce.rest.model.PaymentReq;
import com.gusrylmubarok.ecommerce.rest.repository.OrderRepository;
import com.gusrylmubarok.ecommerce.rest.repository.PaymentRepository;
import java.util.UUID;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PaymentServiceImpl implements PaymentService {

  private PaymentRepository repository;
  private OrderRepository orderRepo;

  public PaymentServiceImpl(PaymentRepository repository, OrderRepository orderRepo) {
    this.repository = repository;
    this.orderRepo = orderRepo;
  }

  @Override
  public Mono<AuthorizationEntity> authorize(@Valid Mono<PaymentReq> paymentReq) {
    return Mono.empty();
  }

  @Override
  public Mono<AuthorizationEntity> getOrdersPaymentAuthorization(@NotNull String orderId) {
    return orderRepo.findById(UUID.fromString(orderId)).map(oe -> oe.getAuthorizationEntity());
  }
}
