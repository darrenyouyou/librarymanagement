package com.darrenyou.librarymanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BorrowRecordsController {

    @Autowired
    private BorrowRecordsService borrowRecordsService;

    @PostMapping("/insert_borrow_record")
    @CrossOrigin(origins = "*")
    public ResponseEntity<BorrowRecords> insertBorrowRecord(@RequestParam int userId, @RequestParam int bookId) {
        BorrowRecords newBorrowRecord = borrowRecordsService.insertBorrowRecord(userId, bookId);
        return ResponseEntity.ok(newBorrowRecord);
    }

    @GetMapping("/borrow_records")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<BorrowRecords>> getBorrowRecords() {
        List<BorrowRecords> inventories = borrowRecordsService.getAllBorrowRecords();
        return ResponseEntity.ok(inventories);
    }

    @GetMapping("/borrow_records_user")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<BorrowRecords>> getBorrowRecordsByUserId(@RequestParam int userId) {
        List<BorrowRecords> inventories = borrowRecordsService.getBorrowRecordsByUserId(userId);
        return ResponseEntity.ok(inventories);
    }

    @PutMapping("/return_borrow_record")
    @CrossOrigin(origins = "*")
    public ResponseEntity<BorrowRecords> updateInventoryStatus(@RequestParam int id) {
        BorrowRecords borrowRecords = borrowRecordsService.updateBorrowRecordReturnDate(id);
        if (borrowRecords == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok().body(borrowRecords);
    }
}
