package com.example.inventoryManagementRestService.controllerService;

import com.example.inventoryManagementRestService.blService.InventoryManagerBL;
import com.example.inventoryManagementRestService.entity.Order_Received;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class InventoryManagerController {

    private InventoryManagerBL inventoryManagerBL;

    @Autowired
    public InventoryManagerController(InventoryManagerBL inventoryManagerBL) {
        this.inventoryManagerBL = inventoryManagerBL;
    }

    @GetMapping("/{orderId}")
    public Order_Received getOrderPlace(@PathVariable int orderId){
        Order_Received order_received = inventoryManagerBL.findOrder(orderId);
        if(order_received == null){
            throw new RuntimeException("Order Id id not Valid or its Null");
        }
        return order_received;
    }
}
