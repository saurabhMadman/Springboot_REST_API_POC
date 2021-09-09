package com.example.inventoryManagementRestService.blService;

import com.example.inventoryManagementRestService.entity.Order_Received;

public interface InventoryManagerInterfaceBl {

    Order_Received findOrder(int id);
    void save(Order_Received order_received);
    void deleteById(int id);
}
