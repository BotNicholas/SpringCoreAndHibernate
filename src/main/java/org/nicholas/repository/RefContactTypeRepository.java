package org.nicholas.repository;

import org.hibernate.SessionFactory;
import org.nicholas.model.RefContactType;
import org.springframework.stereotype.Repository;

@Repository
public class RefContactTypeRepository extends RepositoryImpl<RefContactType, Integer>{
    public RefContactTypeRepository(SessionFactory sessionFactory) {
        super(sessionFactory, RefContactType.class);
    }
}
