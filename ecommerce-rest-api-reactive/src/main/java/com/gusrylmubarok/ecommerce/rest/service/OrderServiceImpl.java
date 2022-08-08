package com.gusrylmubarok.ecommerce.rest.service;

import com.gusrylmubarok.ecommerce.rest.entity.CardEntity;
import com.gusrylmubarok.ecommerce.rest.entity.ItemEntity;
import com.gusrylmubarok.ecommerce.rest.entity.OrderEntity;
import com.gusrylmubarok.ecommerce.rest.model.NewOrder;
import com.gusrylmubarok.ecommerce.rest.repository.AddressRepository;
import com.gusrylmubarok.ecommerce.rest.repository.CardRepository;
import com.gusrylmubarok.ecommerce.rest.repository.ItemRepository;
import com.gusrylmubarok.ecommerce.rest.repository.OrderRepository;
import com.gusrylmubarok.ecommerce.rest.repository.ShipmentRepository;
import com.gusrylmubarok.ecommerce.rest.repository.UserRepository;
import java.util.List;
import java.util.UUID;
import java.util.function.BiFunction;
import javax.validation.Valid;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderServiceImpl implements OrderService {

  private OrderRepository repository;
  private UserRepository userRepo;
  private AddressRepository addRepo;
  private CardRepository cardRepo;
  private ItemRepository itemRepo;
  private ShipmentRepository shipRepo;
  private BiFunction<OrderEntity, List<ItemEntity>, OrderEntity> biOrderItems = (o, fi) -> o
      .setItems(fi);

  public OrderServiceImpl(OrderRepository repository, UserRepository userRepo,
      AddressRepository addRepo, CardRepository cardRepo,
      ItemRepository itemRepo, ShipmentRepository shipRepo) {
    this.repository = repository;
    this.userRepo = userRepo;
    this.addRepo = addRepo;
    this.cardRepo = cardRepo;
    this.itemRepo = itemRepo;
    this.shipRepo = shipRepo;
  }

  @Override
  public Mono<OrderEntity> addOrder(@Valid Mono<NewOrder> newOrder) {
    // 1. Save Order
    return repository.insert(newOrder);
  }

  @Override
  public Mono<OrderEntity> updateMapping(@Valid OrderEntity orderEntity) {
    return repository.updateMapping(orderEntity);
  }

  @Override
  public Flux<OrderEntity> getOrdersByCustomerId(String customerId) {
    // will use the dummy Card Id if it is null
    return repository.findByCustomerId(customerId).flatMap(order ->
        Mono.just(order)
            .zipWith(userRepo.findById(order.getCustomerId()))
            .map(t -> t.getT1().setUserEntity(t.getT2()))
            .zipWith(addRepo.findById(order.getAddressId()))
            .map(t -> t.getT1().setAddressEntity(t.getT2()))
            .zipWith(cardRepo.findById(order.getCardId() != null ? order.getCardId()
                : UUID.fromString("0a59ba9f-629e-4445-8129-b9bce1985d6a"))
                .defaultIfEmpty(new CardEntity()))
            .map(t -> t.getT1().setCardEntity(t.getT2()))
            .zipWith(itemRepo.findByCustomerId(order.getCustomerId().toString()).collectList(),
                biOrderItems)
    );
  }

  @Override
  public Mono<OrderEntity> getByOrderId(String id) {
    return repository.findById(UUID.fromString(id)).flatMap(order ->
        Mono.just(order)
            .zipWith(userRepo.findById(order.getCustomerId()))
            .map(t -> t.getT1().setUserEntity(t.getT2()))
            .zipWith(addRepo.findById(order.getAddressId()))
            .map(t -> t.getT1().setAddressEntity(t.getT2()))
            .zipWith(cardRepo.findById(order.getCardId()))
            .map(t -> t.getT1().setCardEntity(t.getT2()))
            .zipWith(itemRepo.findByCustomerId(order.getCustomerId().toString()).collectList(),
                biOrderItems)
    );
  }
}
