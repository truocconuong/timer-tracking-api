package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.WorkTimes;

public interface IWorkTimeService {
    WorkTimes checkin(WorkTimes worktime, User user);
    WorkTimes getHistory(User user);
}
