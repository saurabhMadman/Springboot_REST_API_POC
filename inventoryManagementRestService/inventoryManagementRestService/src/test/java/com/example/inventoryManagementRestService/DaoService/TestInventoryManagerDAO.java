package com.example.inventoryManagementRestService.DaoService;

import com.example.inventoryManagementRestService.BlService.InventoryManagerBL;
import com.example.inventoryManagementRestService.DaoService.InventoryManagerDAO;
import com.example.inventoryManagementRestService.entity.Order_Received;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
class TestInventoryManagerDAO {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private InventoryManagerDAO inventoryManagerDAO;

    @Test
    public void TestFind() {
        Order_Received order_received = getOrder_received();
        entityManager.persist(order_received);
        Order_Received order_received1 = inventoryManagerDAO.findOrder(1);
        assertNotNull(order_received1);
        assertEquals(1, order_received1.getOrder_id());

    }

    private Order_Received getOrder_received() {
        Order_Received order_received = new Order_Received();
        order_received.setCustomerLname("verma");
        order_received.setCustomerFname("Test");
        order_received.setOrder_id(1);
        return order_received;
    }


}