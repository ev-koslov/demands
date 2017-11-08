package com.demands.constructor.db;

import com.demands.QFieldDescription;
import com.demands.constructor.field.FieldDescription;
import com.querydsl.sql.SQLQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FieldDescriptionDB extends CommonDB<QFieldDescription, Long, FieldDescription> {
    private final QFieldDescription field = QFieldDescription.fieldDescription;

    public FieldDescriptionDB(SQLQueryFactory queryFactory) {
        super(queryFactory);
    }

    @Override
    protected List<QFieldDescription> findAll() {
        return queryFactory.selectFrom(field).fetch();
    }

    @Override
    protected QFieldDescription findOne(Long id) {
        return queryFactory.selectFrom(field).where(field.id.eq(id)).fetchOne();
    }

    @Override
    protected List<QFieldDescription> findManyById(List<Long> ids) {
        return queryFactory.selectFrom(field).where(field.id.in(ids)).fetch();
    }

    @Override
    public Long save(FieldDescription source) {
        Long fieldId = queryFactory.insert(field)
                .set(field.nameId, source.getName().getId())
                .set(field.resourceType, source.getResourceReference().getType().name())
                .set(field.resourceTypeId, source.getResourceReference().getId())
                .set(field.dataType, source.getDataType().name())
                .set(field.type, source.getDataType().name())
                .set(field.defaultValue, source.getDefaultValue())
                .execute();

        source.setId(fieldId);

        return fieldId;
    }
}
