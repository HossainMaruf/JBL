package com.example.jbl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jbl.model.Ccsp;

public interface CcspRepository extends JpaRepository<Ccsp, Long> {
    // JpaRepository provides all CRUD methods automatically
}
