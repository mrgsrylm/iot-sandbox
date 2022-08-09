package com.gusrylmubarok.ecommerce.graphql.services;

import com.gusrylmubarok.ecommerce.graphql.generated.types.Product;
import com.gusrylmubarok.ecommerce.graphql.generated.types.Tag;
import com.gusrylmubarok.ecommerce.graphql.generated.types.TagInput;
import com.gusrylmubarok.ecommerce.graphql.repository.Repository;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

  private final Repository repository;

  public TagServiceImpl(Repository repository) {
    this.repository = repository;
  }

  @Override
  public Map<String, List<Tag>> getTags(List<String> productIds) {
    return repository.getProductTagMappings(productIds);
  }

  @Override
  public Product addTags(String productId, List<TagInput> tags) {
    return repository.addTags(productId, tags);
  }
}
