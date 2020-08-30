package com.example.demo.repository;
import com.example.demo.entity.ProductEntity;
import com.example.demo.entity.User;
import com.example.demo.entity.WorkTimes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface WorkTimeRepository  extends JpaRepository<WorkTimes, Integer> {

}
