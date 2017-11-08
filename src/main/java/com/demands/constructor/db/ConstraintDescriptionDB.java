package com.demands.constructor.db;

import com.demands.QConstraintDescription;
import com.demands.constructor.model.constraint.ConstraintDescription;
import com.querydsl.sql.SQLQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConstraintDescriptionDB extends CommonDB<QConstraintDescription, Long, ConstraintDescription> {
    private final QConstraintDescription constraint = QConstraintDescription.constraintDescription;

    public ConstraintDescriptionDB(SQLQueryFactory queryFactory) {
        super(queryFactory);
    }

    @Override
    public List<QConstraintDescription> findAll() {
        return queryFactory.selectFrom(constraint).fetch();
    }

    @Override
    public QConstraintDescription findOne(Long id) {
        return queryFactory.selectFrom(constraint).where(constraint.id.eq(id)).fetchOne();
    }

    @Override
    public List<QConstraintDescription> findManyById(List<Long> ids) {
        return queryFactory.selectFrom(constraint).where(constraint.id.in(ids)).fetch();
    }

    @Override
    public Long save(ConstraintDescription source){
        Long constraintId = queryFactory.insert(constraint)
                .set(constraint.nameId, source.getName().getId())
                .set(constraint.type, source.getType().name())
                .execute();

        source.setId(constraintId);

        return constraintId;
    }
}
