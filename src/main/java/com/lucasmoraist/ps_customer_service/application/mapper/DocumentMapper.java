package com.lucasmoraist.ps_customer_service.application.mapper;

import com.lucasmoraist.ps_customer_service.domain.model.Document;
import com.lucasmoraist.ps_customer_service.infrastructure.database.entity.DocumentEntity;

public final class DocumentMapper {

    private DocumentMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static DocumentEntity toEntity(Document document) {
        return new DocumentEntity(
                null,
                document.type(),
                document.number(),
                null
        );
    }

}
