package com.example.inventoryManagementRestService.blService;

import com.example.inventoryManagementRestService.DaoService.InventoryManagerDAO;
import com.example.inventoryManagementRestService.entity.Order_Received;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryManagerBL implements InventoryManagerInterfaceBl{

    InventoryManagerDAO inventoryManagerDAO;

    @Autowired
    public InventoryManagerBL(InventoryManagerDAO inventoryManagerDAO) {
        this.inventoryManagerDAO = inventoryManagerDAO;
    }

    /**import org.springframework.transaction.annotation.Transactional
     manages all sql transaction like commit, connection close etc.*/
    @Transactional
    public Order_Received findOrder(int orderId){
        return  inventoryManagerDAO.findOrder(orderId);
    }

    @Override
    @Transactional
    public void save(Order_Received order_received) {

    }

    @Override
    @Transactional
    public void deleteById(int id) {

    }
}
