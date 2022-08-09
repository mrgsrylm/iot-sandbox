package com.gusrylmubarok.ecommerce.grpc.server.repository;

import com.gusrylmubarok.ecommerce.grpc.grpc.v1.AttachOrDetachReq;
import com.gusrylmubarok.ecommerce.grpc.grpc.v1.CreateSourceReq;
import com.gusrylmubarok.ecommerce.grpc.grpc.v1.SourceId;
import com.gusrylmubarok.ecommerce.grpc.grpc.v1.UpdateSourceReq;

public interface SourceRepository {
  UpdateSourceReq.Response update(UpdateSourceReq req);
  CreateSourceReq.Response create(CreateSourceReq req);
  SourceId.Response retrieve(String sourceId);
  AttachOrDetachReq.Response attach(AttachOrDetachReq req);
  AttachOrDetachReq.Response detach(AttachOrDetachReq req);
}
