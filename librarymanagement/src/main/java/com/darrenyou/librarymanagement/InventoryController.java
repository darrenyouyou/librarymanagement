package com.darrenyou.librarymanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/insert_inventory")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Inventory> insertInventory(@RequestParam int isbn, @RequestParam int bookId) {
        Inventory newInventory = inventoryService.insertInventory(isbn, bookId);
        return ResponseEntity.ok(newInventory);
    }

    @GetMapping("/inventories")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Inventory>> getInventories() {
        List<Inventory> inventories = inventoryService.getAllInventories();
        return ResponseEntity.ok(inventories);
    }

    @PutMapping("/update_inventory")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Inventory> updateInventoryStatus(@RequestParam int id, @RequestParam String status) {
        Inventory inventory = inventoryService.updateInventoryStatus(id, status);
        if (inventory == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok().body(inventory);
    }
}
