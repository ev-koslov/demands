package com.demands.constructor.db;

import com.demands.QDocumentDescription;
import com.demands.constructor.DocumentDescription;
import com.querydsl.sql.SQLQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DocumentDescriptionDB extends CommonDB<QDocumentDescription, Long, DocumentDescription> {

    private final QDocumentDescription document = QDocumentDescription.documentDescription;

    public DocumentDescriptionDB(SQLQueryFactory queryFactory) {
        super(queryFactory);
    }

    @Override
    public List<QDocumentDescription> findAll(){
        return queryFactory
                .select(document)
                .from(document)
                .fetch();
    }

    @Override
    public QDocumentDescription findOne(Long id) {
        return queryFactory
                .select(document)
                .from(document)
                .where(document.id.eq(id))
                .fetchOne();
    }

    @Override
    public List<QDocumentDescription> findManyById(List<Long> ids) {
        return queryFactory
                .select(document)
                .from(document)
                .where(document.id.in(ids))
                .fetch();
    }

    @Override
    public Long save(DocumentDescription source){
        Long documentId = queryFactory.insert(document)
                .set(document.nameId, source.getName().getId())
                .execute();

        source.setId(documentId);

        return documentId;
    }

}
