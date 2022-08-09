package com.gusrylmubarok.ecommerce.grpc.server.repository;

import com.gusrylubarok.ecommerce.grpc.grpc.v1.*;

public interface SourceRepository {

  UpdateSourceReq.Response update(UpdateSourceReq req);

  CreateSourceReq.Response create(CreateSourceReq req);

  SourceId.Response retrieve(String sourceId);

  AttachOrDetachReq.Response attach(AttachOrDetachReq req);

  AttachOrDetachReq.Response detach(AttachOrDetachReq req);
}
