package com.example.inventoryManagementRestService.DaoService;

import com.example.inventoryManagementRestService.entity.Order_Received;

public interface InventoryManagerInterfaceDAO {

    Order_Received findOrder(int id);
    void save(Order_Received order_received);
    void deleteById(int id);
}
