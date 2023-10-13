package com.darrenyou.librarymanagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowRecordsRepository extends JpaRepository<BorrowRecords, Integer> {

    List<BorrowRecords> findAll();

    @Query("SELECT u FROM BorrowRecords u WHERE u.id = :id")
    BorrowRecords findById(@Param("id") int id);

    @Query("SELECT u FROM BorrowRecords u WHERE u.userId = :userId")
    List<BorrowRecords> findAllByUserId(@Param("userId") int userId);
}
