package com.gusrylmubarok.ecommerce.graphql.services;

import com.gusrylmubarok.ecommerce.graphql.generated.types.Product;
import com.gusrylmubarok.ecommerce.graphql.generated.types.Tag;
import com.gusrylmubarok.ecommerce.graphql.generated.types.TagInput;
import java.util.List;
import java.util.Map;

public interface TagService {
  Map<String, List<Tag>> getTags(List<String> productIds);
  Product addTags(String productId, List<TagInput> tags);
}
