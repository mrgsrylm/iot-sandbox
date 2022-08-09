package com.gusrylmubarok.ecommerce.graphql.dataloaders;

import com.netflix.graphql.dgs.DgsDataLoader;
import com.gusrylmubarok.ecommerce.graphql.generated.types.Tag;
import com.gusrylmubarok.ecommerce.graphql.services.TagService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import org.dataloader.MappedBatchLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DgsDataLoader(name = "tags")
public class TagDataloader implements MappedBatchLoader<String, List<Tag>> {
  private final Logger LOG = LoggerFactory.getLogger(getClass());
  private final TagService tagService;

  public TagDataloader(TagService tagService) {
    this.tagService = tagService;
  }
  
  @Override
  public CompletionStage<Map<String, List<Tag>>> load(Set<String> keys) {
    LOG.info("Tags will be fetched for following product IDs: {}", keys);
    return CompletableFuture.supplyAsync(() -> tagService.getTags(new ArrayList<>(keys)));
  }
}
