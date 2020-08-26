package com.example.demo.service;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.entity.WorkTimes;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.WorkTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
@Service
public class WorkTimeService implements  IWorkTimeService{
    @Autowired
    WorkTimeRepository workTimerepository;


    @Override
    public WorkTimes checkin(WorkTimes worktime, User user) {
        worktime.setUser(user);
        return workTimerepository.save(worktime);
    }
}
