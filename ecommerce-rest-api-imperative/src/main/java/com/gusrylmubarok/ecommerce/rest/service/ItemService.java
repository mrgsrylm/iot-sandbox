package com.gusrylmubarok.ecommerce.rest.service;

import com.gusrylmubarok.ecommerce.rest.entity.ItemEntity;
import com.gusrylmubarok.ecommerce.rest.model.Item;
import java.util.List;

public interface ItemService {
  ItemEntity toEntity(Item m);
  List<ItemEntity> toEntityList(List<Item> items);
  Item toModel(ItemEntity e);
  List<Item> toModelList(List<ItemEntity> items);
}
