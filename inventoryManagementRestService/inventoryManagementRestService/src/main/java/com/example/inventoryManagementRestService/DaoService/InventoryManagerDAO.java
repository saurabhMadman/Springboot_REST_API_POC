package com.example.inventoryManagementRestService.DaoService;

import com.example.inventoryManagementRestService.entity.Order_Received;
import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

@Repository
public class InventoryManagerDAO implements InventoryManagerInterfaceDAO {

    private EntityManager entityManager;

    @Autowired
    public InventoryManagerDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Order_Received findOrder(int id) {
        //get current Hibernate session
        Session session = entityManager.unwrap(Session.class);
        //create Query
        Order_Received order_received  = session.get(Order_Received.class,id);
        return order_received;
    }

    @Override
    public void save(Order_Received order_received) {

    }

    @Override
    public void deleteById(int id) {

    }
}
