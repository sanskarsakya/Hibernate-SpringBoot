package com.jpa;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Dao<T, ID extends Serializable> implements GenericDao<T, ID> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public <S extends T> S persist(S entity) {
        
        Objects.requireNonNull(entity, "Cannot persist a null entity");
        
        entityManager.persist(entity);

        return entity;
    }

    @Transactional(readOnly=true)
    public List<CarDto> fetchCars() {
        Query query = entityManager
                .createQuery("select new com.jpa.CarDto(c.name, c.color) from Car c",
                        CarDto.class);                
        List<CarDto> result = query.getResultList();

        return result;
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
