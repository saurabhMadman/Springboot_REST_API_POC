package com.example.inventoryManagementRestService.DaoService;

import com.example.inventoryManagementRestService.entity.Order_Received;
import org.hibernate.criterion.Order;

import java.util.List;

public interface InventoryManagerInterfaceDAO {

    Order_Received findOrder(int id);
    void saveOrUpdate(Order_Received order_received);
    int deleteById(int id);
    List<Order_Received> orderReceivedAll();
}
