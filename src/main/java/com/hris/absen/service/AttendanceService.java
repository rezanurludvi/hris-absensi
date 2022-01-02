package com.hris.absen.service;

import com.hris.absen.AbsenApplication;
import com.hris.absen.dao.AttendanceDAO;
import com.hris.absen.dao.BaseDAO;
import com.hris.absen.entity.Attendance;
import com.hris.absen.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class AttendanceService extends BaseService<Attendance> {

    @Autowired
    private AttendanceDAO dao;
    private Employee employee;

    @Override
    protected BaseDAO<Attendance> getDAO() {
        return dao;
    }

    @Transactional
    public Attendance save(Attendance entity){

        entity.setAttendanceDate(new java.util.Date());/*coba*/
//        entity.setEmployee(AbsenApplication.getCurrentEmployee());;
        return dao.save(entity);
    }

    @Transactional
    public Attendance update(Attendance entity){
        if (entity.getId() != null){
            Attendance reference = getDAO().findReference(entity.getId());

//            reference.setEmployee((entity.getEmployee() != null)
//                    ? entity.getEmployee()
//                    : new Employee());

            reference.setStartTime(entity.getStartTime() != null
                        ? entity.getStartTime()
                        : new java.util.Date());

            reference.setAttendanceDate(entity.getAttendanceDate() != null
                ? entity.getAttendanceDate()
                    : new java.util.Date());

            /*percobaan*/
//            reference.setEmployee(employee);
//            reference.getEmployee().setStatus(reference.getEmployee().getStatus().equals(Employee.StatusEmployee.UNPRESENT)
//                        ? Employee.StatusEmployee.PRESENT
//                        : reference.getEmployee().getStatus());

//            reference.setEmployee(reference.getEmployee().equals(Employee.StatusEmployee.UNPRESENT)
//                        ? Employee.StatusEmployee.PRESENT :
//                    entity.getEmployee(reference.getEmployee().getStatus()));

//            entity.setEmployee(reference.getEmployee());
            entity.setAttendanceDate(reference.getAttendanceDate());
            entity.setStartTime(reference.getStartTime());
//            entity.setStartTime(reference.getRestStartTime());/*percobaan*/
//            entity.getEmployee().setStatus(reference.getEmployee().getStatus());

            return entity;
        }

        return null;
    }

    /*belum pasti AttendanceDao*/
    @Transactional
    public Collection<Attendance> findByTime(Attendance entity, Date startTime, Date endTime){
        Collection<Attendance> result = dao.findByTime(entity, startTime, endTime);

        return result.size() > 0 ? result : new ArrayList<>();
    }

}
