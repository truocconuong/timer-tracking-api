package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.WorkTimes;
import com.example.demo.repository.WorkTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkTimeService implements  IWorkTimeService{
    @Autowired
    WorkTimeRepository workTimerepository;


    @Override
    public WorkTimes checkin(WorkTimes worktime, User user) {
        worktime.setUser(user);
        return workTimerepository.save(worktime);
    }

    public List<WorkTimes> getHistory() {
        List<WorkTimes> worktime =workTimerepository.findAll();
        return worktime;
    }
}
