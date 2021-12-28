package com.hris.absen.service;

import com.hris.absen.AbsenApplication;
import com.hris.absen.dao.BaseDAO;
import com.hris.absen.dao.EmployeeDAO;
import com.hris.absen.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Service
public class EmployeeService extends BaseService<Employee> {

    @Autowired
    private EmployeeDAO dao;

    @Override
    protected BaseDAO<Employee> getDAO() {
        return dao;
    }

    @Transactional
    public Employee save(Employee entity){
        entity.setStartDate(new Date());/*percobaan*/
        entity.setUser(AbsenApplication.getCurrentUser());

        return dao.save(entity);
    }

    @Transactional
    public Employee update(Employee entity){
        if (entity.getId() != null){
            Employee reference = getDAO().findReference(entity.getId());

            reference.setStartDate(entity.getStartDate() != null
                    ? entity.getStartDate()
                    : new Date());

            reference.setStatus(reference.getStatus().equals(Employee.StatusEmployee.UNPRESENT)
                    ? Employee.StatusEmployee.PRESENT
                    : reference.getStatus());

            entity.setStartDate(reference.getStartDate());/*percobaan*/
//            entity.setStartDate(reference.getStartDate());
            entity.setStatus(reference.getStatus());

            return entity;
        }

        return null;
    }

    /*percobaan*/
    @Transactional
    public Collection<Employee> findByDate(Employee entity, Date startDate, Date endDate){
        Collection<Employee> result = dao.findByDate(entity, startDate, endDate);
        return result.size() > 0 ? result : new ArrayList<>();
    }
}
