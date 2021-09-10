package com.example.inventoryManagementRestService.controllerService;

import com.example.inventoryManagementRestService.BlService.InventoryManagerWareHouseBL;
import com.example.inventoryManagementRestService.entity.IteamList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class InventoryManagerWareHouseController {

    private InventoryManagerWareHouseBL inventoryManagerWareHouseBL;

    @Autowired
    public InventoryManagerWareHouseController(InventoryManagerWareHouseBL inventoryManagerWareHouseBL) {
        this.inventoryManagerWareHouseBL = inventoryManagerWareHouseBL;
    }

    @GetMapping("/{itemId}")
    public IteamList getItemList(@PathVariable int itemId){
       IteamList iteamList= inventoryManagerWareHouseBL.findItem(itemId);
       return iteamList;
   }

    @GetMapping("/all")
    public List<IteamList> order_receivedList(){
        return inventoryManagerWareHouseBL.iteamListsAll();
    }

    @PutMapping("/")
    public HttpStatus updateOrder_received(@RequestBody IteamList iteamList){
        inventoryManagerWareHouseBL.updateOrderReceived(iteamList);
        if(iteamList!= null){
            return HttpStatus.ACCEPTED;
        }
        return HttpStatus.NOT_MODIFIED;
    }

    @DeleteMapping("/{itemId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrder(@PathVariable int itemId){
        int i = inventoryManagerWareHouseBL.deleteById(itemId);
        if(i == -1){
            throw new RuntimeException("Order Id id not Valid or its Null");
        }
    }
}
