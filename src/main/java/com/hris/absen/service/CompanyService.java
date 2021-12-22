package com.hris.absen.service;

import com.hris.absen.dao.BaseDAO;
import com.hris.absen.dao.CompanyDAO;
import com.hris.absen.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService extends BaseService<Company> {

    @Autowired
    private CompanyDAO dao;

    @Override
    protected BaseDAO<Company> getDAO() {
        return dao;
    }
}
