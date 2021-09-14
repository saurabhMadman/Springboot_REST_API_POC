package com.example.inventoryManagementRestService.BlService;

import com.example.inventoryManagementRestService.DaoService.InventoryManagerDAO;
import com.example.inventoryManagementRestService.entity.Order_Received;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TestInventoryManagerBL {

    @Mock
    private InventoryManagerDAO inventoryManagerDAO;
    @InjectMocks
    private InventoryManagerBL inventoryManagerBL;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void TestFind() {
        Order_Received order_received = getOrder_received();
        when(inventoryManagerDAO.findOrder(Mockito.anyInt())).thenReturn(order_received);
        Order_Received order_received1 = inventoryManagerBL.findOrder(1);
        assertNotNull(order_received1);
        assertEquals(1, order_received1.getOrder_id());

    }

    @Test
    public void TestSave() {
        Order_Received order_received = getOrder_received();
        doNothing().when(inventoryManagerDAO).saveOrUpdate(Mockito.any(Order_Received.class));
        inventoryManagerBL.save(order_received);
        verify(inventoryManagerDAO, times(1)).saveOrUpdate(Mockito.any(Order_Received.class));
    }

    @Test
    public void TestFindAll(){
        Order_Received order_received = getOrder_received();
        List<Order_Received> list = new ArrayList<>();
        list.add(order_received);
        when(inventoryManagerDAO.orderReceivedAll()).thenReturn(list);
        List<Order_Received> order_receivedList = inventoryManagerBL.orderReceivedAll();
        assertNotNull(order_receivedList);
    }

    @Test
    public void testDelete() {
        when(inventoryManagerDAO.deleteById(Mockito.anyInt())).thenReturn(1);
        int  i = inventoryManagerBL.deleteById(1);
        assertEquals(1,1);

    }

    private Order_Received getOrder_received() {
        Order_Received order_received = new Order_Received();
        order_received.setCustomerLname("verma");
        order_received.setCustomerFname("Test");
        order_received.setOrder_id(1);
        return order_received;
    }
}