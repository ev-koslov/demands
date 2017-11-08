package com.demands.constructor.db;

import com.querydsl.sql.RelationalPathBase;
import com.querydsl.sql.SQLQueryFactory;

import java.util.List;

//Common query dsl generic class. It declares common abstract methods
@SuppressWarnings("WeakerAccess")
public abstract class CommonDB<T extends RelationalPathBase<T>, I, D> {
    protected final SQLQueryFactory queryFactory;

    protected CommonDB(SQLQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    protected abstract List<T> findAll();
    protected abstract T findOne(I id);
    protected abstract List<T> findManyById(List<I> ids);

    protected abstract I save(D source);

}
