package com.demands.constructor.db;

import com.demands.QResourceDescription;
import com.demands.constructor.resource.ResourceDescription;
import com.querydsl.sql.SQLQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResourceDescriptionDB extends CommonDB<QResourceDescription, Long, ResourceDescription> {
    private final QResourceDescription resource = QResourceDescription.resourceDescription;

    public ResourceDescriptionDB(SQLQueryFactory queryFactory) {
        super(queryFactory);
    }

    @Override
    public List<QResourceDescription> findAll() {
        return queryFactory.selectFrom(resource).fetch();
    }

    @Override
    public QResourceDescription findOne(Long id) {
        return queryFactory.selectFrom(resource).where(resource.id.eq(id)).fetchOne();
    }

    @Override
    public List<QResourceDescription> findManyById(List<Long> ids) {
        return queryFactory.selectFrom(resource).where(resource.id.in(ids)).fetch();
    }

    @Override
    public Long save(ResourceDescription source) {
        Long resourceId = queryFactory.insert(resource)
                .set(resource.nameId, source.getName().getId())
                .set(resource.type, source.getType().name())
                .execute();

        source.setId(resourceId);

        return resourceId;
    }
}
