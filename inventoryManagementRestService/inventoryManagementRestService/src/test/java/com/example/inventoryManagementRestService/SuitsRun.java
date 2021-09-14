package com.example.inventoryManagementRestService;

import com.example.inventoryManagementRestService.BlService.TestInventoryManagerBL;
import com.example.inventoryManagementRestService.controllerService.TestInventoryManagerController;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestInventoryManagerBL.class, TestInventoryManagerController.class})
public class SuitsRun {
}
