package com.example.inventoryManagementRestService.BlService;

import com.example.inventoryManagementRestService.DaoService.InventoryManagerDAO;
import com.example.inventoryManagementRestService.entity.Order_Received;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class InventoryManagerBL implements InventoryManagerInterfaceBl{

    private InventoryManagerDAO inventoryManagerDAO;

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
        order_received.setReceivedDate(new Date());
        inventoryManagerDAO.saveOrUpdate(order_received);
    }

    @Override
    @Transactional
    public int deleteById(int id) {
       return inventoryManagerDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void updateOrderReceived(Order_Received order_received) {
        inventoryManagerDAO.saveOrUpdate(order_received);
    }

    @Override
    @Transactional
    public List<Order_Received> orderReceivedAll() {
        return inventoryManagerDAO.orderReceivedAll();
    }


    @Transactional
    public Long countList(){
        return inventoryManagerDAO.getCountofOrder();
    }
}
