package com.example.inventoryManagementRestService.controllerService;

import com.example.inventoryManagementRestService.BlService.InventoryManagerBL;
import com.example.inventoryManagementRestService.entity.Order_Received;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InventoryManagerController {

    private InventoryManagerBL inventoryManagerBL;

    @Autowired
    public InventoryManagerController(InventoryManagerBL inventoryManagerBL) {
        this.inventoryManagerBL = inventoryManagerBL;
    }

    /**Find Single Object*/
    @GetMapping("/{orderId}")
    @ResponseStatus(HttpStatus.FOUND)
    public Order_Received getOrderPlace(@PathVariable int orderId){
        Order_Received order_received = inventoryManagerBL.findOrder(orderId);
        if(order_received == null){
            throw new RuntimeException("Order Id id not Valid or its Null");
        }
        return order_received;
    }

    /**Add new Object*/
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveOder(@RequestBody Order_Received order_received){
        inventoryManagerBL.save(order_received);
    }

    /**Delete Object By Id*/
    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrder(@PathVariable int orderId){
        int i = inventoryManagerBL.deleteById(orderId);
        if(i == -1){
            throw new RuntimeException("Order Id id not Valid or its Null");
        }
    }

    /**Updating Object
     * @return*/
    @PutMapping("/update")
    public HttpStatus updateOrder_received(@RequestBody Order_Received order_received){
        inventoryManagerBL.updateOrderReceived(order_received);
        if(order_received!= null){
            return HttpStatus.ACCEPTED;
        }
        return HttpStatus.NOT_MODIFIED;
    }

    @GetMapping("/all")
    public List<Order_Received> order_receivedList(){
       return inventoryManagerBL.orderReceivedAll();
    }

}
