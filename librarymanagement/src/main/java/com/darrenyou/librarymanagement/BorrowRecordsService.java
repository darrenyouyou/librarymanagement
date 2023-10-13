package com.darrenyou.librarymanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class BorrowRecordsService {

    @Autowired
    private BorrowRecordsRepository borrowRecordsRepository;

    public BorrowRecords insertBorrowRecord(int userId, int bookId, int inventoryId) {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        BorrowRecords borrowRecord = new BorrowRecords();
        borrowRecord.setUserId(userId);
        borrowRecord.setBookId(bookId);
        borrowRecord.setBorrowDate(currentTimestamp);
        borrowRecord.setReturnDate(null);
        borrowRecord.setInventoryId(inventoryId);
        return borrowRecordsRepository.saveAndFlush(borrowRecord);
    }

    public List<BorrowRecords> getAllBorrowRecords() {
        return borrowRecordsRepository.findAll();
    }

    public List<BorrowRecords> getBorrowRecordsByUserId(int userId) {
        return borrowRecordsRepository.findAllByUserId(userId);
    }

    public BorrowRecords updateBorrowRecordReturnDate(int id) {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        BorrowRecords existingBorrowRecord = borrowRecordsRepository.findById(id);
        if (existingBorrowRecord != null) {
            existingBorrowRecord.setReturnDate(currentTimestamp);
            return borrowRecordsRepository.saveAndFlush(existingBorrowRecord);
        } else {
            return null;
        }
    }
}
