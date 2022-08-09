package com.gusrylmubarok.ecommerce.graphql.repository;

import com.gusrylmubarok.ecommerce.graphql.generated.types.Product;
import com.gusrylmubarok.ecommerce.graphql.generated.types.Tag;
import com.gusrylmubarok.ecommerce.graphql.generated.types.TagInput;
import java.util.List;
import java.util.Map;
import org.reactivestreams.Publisher;

public interface Repository {
  Product getProduct(String id);
  List<Product> getProducts();
  Map<String, List<Tag>> getProductTagMappings(List<String> productIds);
  Product addTags(String productId, List<TagInput> tags);
  Product addQuantity(String productId, int qty);
  Publisher<Product> getProductPublisher();
}
