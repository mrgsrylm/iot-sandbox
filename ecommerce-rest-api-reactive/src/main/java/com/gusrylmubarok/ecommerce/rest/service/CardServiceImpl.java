package com.gusrylmubarok.ecommerce.rest.service;

import com.gusrylmubarok.ecommerce.rest.entity.CardEntity;
import com.gusrylmubarok.ecommerce.rest.model.AddCardReq;
import com.gusrylmubarok.ecommerce.rest.repository.CardRepository;
import com.gusrylmubarok.ecommerce.rest.repository.UserRepository;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CardServiceImpl implements CardService {

  private CardRepository repository;
  private UserRepository userRepo;

  public CardServiceImpl(CardRepository repository, UserRepository userRepo) {
    this.repository = repository;
    this.userRepo = userRepo;
  }

  @Override
  public Mono<Void> deleteCardById(String id) {
    return deleteCardById(UUID.fromString(id));
  }

  @Override
  public Mono<Void> deleteCardById(UUID id) {
    return repository.deleteById(id);
  }

  @Override
  public Flux<CardEntity> getAllCards() {
    return repository.findAll();
  }

  @Override
  public Mono<CardEntity> getCardById(String id) {
    return repository.findById(UUID.fromString(id));
  }

  @Override
  public Mono<CardEntity> registerCard(@Valid Mono<AddCardReq> addCardReq) {
    return addCardReq.map(this::toEntity).flatMap(repository::save);
  }

  @Override
  public CardEntity toEntity(AddCardReq model) {
    CardEntity e = new CardEntity();
    BeanUtils.copyProperties(model, e);
    e.setNumber(model.getCardNumber());
    return e;
  }
}
