package com.hris.absen.service;

import com.hris.absen.dao.AttendanceDAO;
import com.hris.absen.dao.BaseDAO;
import com.hris.absen.entity.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService extends BaseService<Attendance> {

    @Autowired
    private AttendanceDAO dao;

    @Override
    protected BaseDAO<Attendance> getDAO() {
        return dao;
    }
}
