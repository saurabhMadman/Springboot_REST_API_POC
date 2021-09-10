package com.example.inventoryManagementRestService.Integration;

import com.example.inventoryManagementRestService.BlService.InventoryManagerBL;
import com.example.inventoryManagementRestService.entity.Order_Received;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class InventoryManagerBLTest {

    @Autowired
    InventoryManagerBL inventoryManagerBL;

    @Test
    public void testFind(){
        Order_Received order_received = inventoryManagerBL.findOrder(1);
        Assert.assertNotNull(order_received);
        Assert.assertEquals("1",order_received.getOrder_id().toString());
    }

}