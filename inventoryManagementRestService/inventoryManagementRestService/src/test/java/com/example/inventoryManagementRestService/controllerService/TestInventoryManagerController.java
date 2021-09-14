package com.example.inventoryManagementRestService.controllerService;

import com.example.inventoryManagementRestService.BlService.InventoryManagerBL;
import com.example.inventoryManagementRestService.entity.Order_Received;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.mockito.ArgumentMatchers;

@WebMvcTest
public class TestInventoryManagerController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InventoryManagerBL inventoryManagementRestServiceApplication;

    private static ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testGetExample() throws Exception {
        Order_Received order_received = new Order_Received();
        order_received.setOrder_id(1);
        order_received.setCustomerFname("Test");
        Mockito.when( inventoryManagementRestServiceApplication.findOrder(1)).thenReturn(order_received);
        mockMvc.perform(get("inorder/1"))
                .andExpect(status().isOk());
    }
}