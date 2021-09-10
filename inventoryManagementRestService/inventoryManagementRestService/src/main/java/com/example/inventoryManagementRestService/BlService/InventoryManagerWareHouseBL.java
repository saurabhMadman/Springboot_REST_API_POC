package com.example.inventoryManagementRestService.BlService;

import com.example.inventoryManagementRestService.DaoService.InventoryManagementWareHouseDAO;
import com.example.inventoryManagementRestService.entity.IteamList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InventoryManagerWareHouseBL implements InvertoryManagerWareHouseInterfaceBl {

    private InventoryManagementWareHouseDAO inventoryManagementWareHouseDAO;

    @Autowired
    public InventoryManagerWareHouseBL(InventoryManagementWareHouseDAO inventoryManagementWareHouseDAO) {
        this.inventoryManagementWareHouseDAO = inventoryManagementWareHouseDAO;
    }

    @Override
    @Transactional
    public IteamList findItem(int id) {
        return inventoryManagementWareHouseDAO.findItem(id);
    }

    @Override
    @Transactional
    public void save(IteamList iteamList) {
        inventoryManagementWareHouseDAO.saveOrUpdate(iteamList);
    }

    @Override
    @Transactional
    public int deleteById(int id) {
        return inventoryManagementWareHouseDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void updateOrderReceived(IteamList iteamList) {
        inventoryManagementWareHouseDAO.saveOrUpdate(iteamList);
    }


    @Transactional
    public List<IteamList> iteamListsAll() {
        return inventoryManagementWareHouseDAO.orderReceivedAll();
    }
}
