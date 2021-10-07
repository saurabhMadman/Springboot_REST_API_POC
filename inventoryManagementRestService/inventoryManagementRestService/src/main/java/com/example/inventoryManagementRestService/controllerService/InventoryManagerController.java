package com.example.inventoryManagementRestService.controllerService;

import com.example.inventoryManagementRestService.BlService.InventoryManagerBL;
import com.example.inventoryManagementRestService.entity.Order_Received;
import com.example.inventoryManagementRestService.exception.InvalidArgumentExceptionClass;
import com.example.inventoryManagementRestService.exception.ResourceNotFoundExceptionHandler;
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
    public ResponseEntity getOrderPlace(@PathVariable Integer orderId) throws ResourceNotFoundExceptionHandler, InvalidArgumentExceptionClass {
        if((orderId == null)){
            String[] error = {"OrderId should be Integer Only"};
            throw new InvalidArgumentExceptionClass(error);
        }
        Order_Received order_received = inventoryManagerBL.findOrder(orderId);
        if(order_received == null){
            throw new ResourceNotFoundExceptionHandler("Order Was Not Found" +orderId);
        }
        return ResponseEntity.ok(order_received);
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
    public ResponseEntity deleteOrder(@PathVariable int orderId) throws ResourceNotFoundExceptionHandler {
        int i = inventoryManagerBL.deleteById(orderId);
        if (i == -1) {
            throw new ResourceNotFoundExceptionHandler("OrderId Was Not Found :" +orderId);
        }
        return new ResponseEntity<>(i, HttpStatus.OK);
    }

    /**
     * Updating Object
     */
    @PutMapping(path = "/update", produces = "application/json")
    public ResponseEntity updateOrder_received(@RequestBody Order_Received order_received) {
        if (order_received != null) {
            inventoryManagerBL.updateOrderReceived(order_received);
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
