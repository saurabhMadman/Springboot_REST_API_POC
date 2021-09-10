package com.example.inventoryManagementRestService.BlService;

import com.example.inventoryManagementRestService.entity.Order_Received;

import java.util.List;

public interface InventoryManagerInterfaceBl {

    Order_Received findOrder(int id);

    void save(Order_Received order_received);

    int deleteById(int id);

    void updateOrderReceived(Order_Received order_received);

    List<Order_Received> orderReceivedAll();
}
