package com.darrenyou.librarymanagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    List<Inventory> findAll();

    @Query("SELECT u FROM Inventory u WHERE u.isbn = :isbn")
    Inventory findByIsbn(@Param("isbn") int isbn);
}
