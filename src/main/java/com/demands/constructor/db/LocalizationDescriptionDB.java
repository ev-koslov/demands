package com.demands.constructor.db;

import com.demands.QLocalizationDescription;
import com.demands.constructor.LocalizationDescription;
import com.querydsl.sql.SQLQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocalizationDescriptionDB extends CommonDB<QLocalizationDescription, Long, LocalizationDescription> {

    private final QLocalizationDescription localization = QLocalizationDescription.localizationDescription;

    public LocalizationDescriptionDB(SQLQueryFactory queryFactory) {
        super(queryFactory);
    }

    @Override
    protected List<QLocalizationDescription> findAll() {
        return queryFactory.selectFrom(localization).fetch();
    }

    @Override
    protected QLocalizationDescription findOne(Long id) {
        return queryFactory.selectFrom(localization)
                .where(localization.id.eq(id))
                .fetchOne();
    }

    @Override
    protected List<QLocalizationDescription> findManyById(List<Long> ids) {
        return queryFactory
                .selectFrom(localization)
                .where(localization.id.in(ids))
                .fetch();
    }

    @Override
    public Long save(LocalizationDescription source) {
        Long localizationId = queryFactory.insert(localization)
                .set(localization.en, source.getEn())
                .set(localization.ru, source.getRu())
                .set(localization.kk, source.getKk())
                .execute();

        source.setId(localizationId);

        return localizationId;
    }
}
