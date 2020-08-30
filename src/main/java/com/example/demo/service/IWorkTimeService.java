package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.WorkTimes;

import java.util.List;

public interface IWorkTimeService {
    WorkTimes checkin(WorkTimes worktime, User user);
}
