package com.example.inventoryManagementRestService.DaoService;

import com.example.inventoryManagementRestService.entity.IteamList;
import com.example.inventoryManagementRestService.entity.Order_Received;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class InventoryManagerDAO implements InventoryManagerInterfaceDAO {

    private final EntityManager entityManager;

    @Autowired
    public InventoryManagerDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Order_Received findOrder(int id) {
        //get current Hibernate session
        Session session = entityManager.unwrap(Session.class);
        //create Query
        Order_Received order_received = session.get(Order_Received.class, id);
        session.flush();
        return order_received;
    }

    public void saveOrUpdate(Order_Received order_received) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(order_received);
        currentSession.flush();
    }

    @Override
    public int deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Order_Received order_received = currentSession.get(Order_Received.class, id);
        if (order_received == null) {
            return -1;
        }
        currentSession.delete(order_received);
        currentSession.flush();
        return 1;
    }

    public List<Order_Received> orderReceivedAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        List<Order_Received> order_receivedList= currentSession.createQuery("from Order_Received").list();
        return order_receivedList;
    }

}
