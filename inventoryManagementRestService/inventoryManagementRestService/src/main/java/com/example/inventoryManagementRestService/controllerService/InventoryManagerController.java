package com.example.inventoryManagementRestService.controllerService;

import com.example.inventoryManagementRestService.BlService.InventoryManagerBL;
import com.example.inventoryManagementRestService.entity.Order_Received;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/inorder")
public class InventoryManagerController {

    private final InventoryManagerBL inventoryManagerBL;

    @Autowired
    public InventoryManagerController(InventoryManagerBL inventoryManagerBL) {
        this.inventoryManagerBL = inventoryManagerBL;
    }

    /**
     * Find Single Object
     */
    @GetMapping(path = "/{orderId}", produces = "application/json")
    public ResponseEntity getOrderPlace(@PathVariable int orderId) {
        Order_Received order_received = inventoryManagerBL.findOrder(orderId);
        if (order_received == null) {
            throw new RuntimeException("Order Id id not Valid or its Null");
        }
        return new ResponseEntity<>(order_received, HttpStatus.OK);
    }

    /**
     * Add new Object
     */
    @PostMapping(path = "/", produces = "application/json")
    public ResponseEntity saveOrder(@RequestBody Order_Received order_received) {
        inventoryManagerBL.save(order_received);
        return new ResponseEntity<>("Object Saved Successfully", HttpStatus.OK);
    }

    /**
     * Delete Object By Id
     */
    @DeleteMapping(path = "/{orderId}", produces = "application/json")
    public ResponseEntity deleteOrder(@PathVariable int orderId) {
        int i = inventoryManagerBL.deleteById(orderId);
        if (i == -1) {
            throw new RuntimeException("Order Id id not Valid or its Null");
        }
        return new ResponseEntity<>(i, HttpStatus.OK);
    }

    /**
     * Updating Object
     */
    @PutMapping(path = "/update", produces = "application/json")
    public ResponseEntity updateOrder_received(@RequestBody Order_Received order_received) {
        inventoryManagerBL.updateOrderReceived(order_received);
        if (order_received != null) {
            return new ResponseEntity<>("updated", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(path = "/all", produces = "application/json")
    public ResponseEntity order_receivedList() {
        List<Order_Received> order_receivedList = inventoryManagerBL.orderReceivedAll();
        return new ResponseEntity<>(order_receivedList, HttpStatus.OK);
    }

    @GetMapping(path="/count", produces = "application/json")
    public ResponseEntity getCount(){
       Long countList = inventoryManagerBL.countList();
       return new ResponseEntity<>("Count: " +countList , HttpStatus.OK);
    }

}
