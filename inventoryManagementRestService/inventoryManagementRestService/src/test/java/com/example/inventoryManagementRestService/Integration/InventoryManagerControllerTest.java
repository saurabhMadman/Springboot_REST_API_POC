package com.example.inventoryManagementRestService.Integration;

import com.example.inventoryManagementRestService.controllerService.InventoryManagerController;
import com.example.inventoryManagementRestService.entity.Order_Received;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryManagerControllerTest extends AbstractTest {

   @Override
   @Before
   public void setUp() {
      super.setUp();
   }

   @org.junit.Test
   public void getProductsList() throws Exception {
      String uri = "/inorder/1";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
              .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      Order_Received order_received = super.mapFromJson(content, Order_Received.class);
      assertNotNull(order_received);
   }
   @org.junit.Test
   public void createProduct() throws Exception {
      String uri = "/inorder";
      Order_Received order_received = new Order_Received();
      order_received.setOrder_id(3);
      order_received.setCustomerFname("Ginger");
      String inputJson = super.mapToJson(order_received);
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
              .contentType(MediaType.APPLICATION_JSON_VALUE)
              .content(inputJson)).andReturn();

      int status = mvcResult.getResponse().getStatus();
      assertEquals(201, status);
      String content = mvcResult.getResponse().getContentAsString();
      assertEquals(content, "Product is created successfully");
   }
   @org.junit.Test
   public void updateProduct() throws Exception {
      String uri = "/inorder/all";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
              .contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();

      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      assertEquals(content, "Product is updated successsfully");
   }
   @Test
   public void deleteProduct() throws Exception {
      String uri = "/products/2";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      assertEquals(content, "Product is deleted successsfully");
   }



}