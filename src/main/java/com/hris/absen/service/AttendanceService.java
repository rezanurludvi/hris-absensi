package com.hris.absen.service;

import com.hris.absen.AbsenApplication;
import com.hris.absen.dao.AttendanceDAO;
import com.hris.absen.dao.BaseDAO;
import com.hris.absen.entity.Attendance;
import com.hris.absen.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.Date;

@Service
public class AttendanceService extends BaseService<Attendance> {

    @Autowired
    private AttendanceDAO dao;

    @Override
    protected BaseDAO<Attendance> getDAO() {
        return dao;
    }

    @Transactional
    public Attendance save(Attendance entity){
        entity.setAttendanceDate(new Date());
        entity.setEmployee(AbsenApplication.getCurrentEmployee());

        return dao.save(entity);
    }

    @Transactional
    public Attendance update(Attendance entity){
        if (entity.getId() != null){
            Attendance reference = getDAO().findReference(entity.getId());

            entity.setAttendanceDate(reference.getAttendanceDate());

            return entity;
        }

        return null;
    }



}
