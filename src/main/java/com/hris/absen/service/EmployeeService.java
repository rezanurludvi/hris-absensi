package com.hris.absen.service;

import com.hris.absen.dao.BaseDAO;
import com.hris.absen.dao.EmployeeDAO;
import com.hris.absen.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService extends BaseService<Employee> {

    @Autowired
    private EmployeeDAO dao;

    @Override
    protected BaseDAO<Employee> getDAO() {
        return dao;
    }
}
