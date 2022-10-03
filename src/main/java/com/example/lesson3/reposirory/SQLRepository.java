package com.example.lesson3.reposirory;

import com.example.lesson3.entity.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class SQLRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Product> getNameProduct(String nameCustomer) {
        Query query = entityManager.createQuery("select p from Product p where p.customer.name = :name");
        query.setParameter("name", nameCustomer);
        return query.getResultList();
    }
}
