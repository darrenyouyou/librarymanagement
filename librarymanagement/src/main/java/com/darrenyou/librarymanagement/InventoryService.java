package com.darrenyou.librarymanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public Inventory insertInventory(int isbn, int bookId) {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        Inventory inventory = new Inventory();
        inventory.setIsbn(isbn);
        inventory.setStoreTime(currentTimestamp);
        inventory.setStatus(String.valueOf(InventoryStatus.IN_STOCK));
        inventory.setBookId(bookId);
        return inventoryRepository.saveAndFlush(inventory);
    }

    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    public Inventory updateInventoryStatus(int isbn, String status) {
        Inventory existingInventory = inventoryRepository.findByIsbn(isbn);

        if (existingInventory != null) {
            existingInventory.setStatus(status);
            return inventoryRepository.saveAndFlush(existingInventory);
        } else {
            return null;
        }
    }
}
