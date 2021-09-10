package com.example.inventoryManagementRestService.BlService;

import com.example.inventoryManagementRestService.entity.IteamList;


import java.util.List;

public interface InvertoryManagerWareHouseInterfaceBl {

    IteamList findOrder(int id);

    void save(IteamList iteamList);

    int deleteById(int id);

    void updateOrderReceived(IteamList iteamList);

    List<IteamList> orderReceivedAll();

}
