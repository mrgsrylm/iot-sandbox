package com.gusrylmubarok.ecommerce.rest.service;

import com.gusrylmubarok.ecommerce.rest.entity.CardEntity;
import com.gusrylmubarok.ecommerce.rest.model.AddCardReq;
import java.util.UUID;
import javax.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface CardService {
  Mono<Void> deleteCardById(String id);
  Mono<Void> deleteCardById(UUID id);
  Flux<CardEntity> getAllCards();
  Mono<CardEntity> getCardById(String id);
  Mono<CardEntity> registerCard(@Valid Mono<AddCardReq> addCardReq);
  CardEntity toEntity(AddCardReq model);
}
