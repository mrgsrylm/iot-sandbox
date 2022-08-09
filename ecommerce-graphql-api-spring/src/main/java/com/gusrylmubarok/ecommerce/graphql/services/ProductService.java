package com.gusrylmubarok.ecommerce.graphql.services;

import com.gusrylmubarok.ecommerce.graphql.generated.types.Product;
import com.gusrylmubarok.ecommerce.graphql.generated.types.ProductCriteria;
import java.util.List;
import org.reactivestreams.Publisher;

public interface ProductService {

  Product getProduct(String id);

  List<Product> getProducts(ProductCriteria criteria);

  Product addQuantity(String productId, int qty);

  Publisher<Product> gerProductPublisher();
}
