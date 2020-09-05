package com.example.demo.repository;
import com.example.demo.entity.Documents;
import com.example.demo.entity.WorkTimes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Documents, Integer> {

}
