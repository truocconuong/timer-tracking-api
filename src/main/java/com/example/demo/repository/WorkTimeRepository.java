package com.example.demo.repository;
import com.example.demo.entity.User;
import com.example.demo.entity.WorkTimes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
public interface WorkTimeRepository  extends JpaRepository<WorkTimes, Integer> {

}
