package com.example.demo.repository;

import com.example.demo.model.trainList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface trainrepository extends JpaRepository<trainList,Integer> {
}
