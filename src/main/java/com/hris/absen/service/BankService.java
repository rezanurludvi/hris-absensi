package com.hris.absen.service;

import com.hris.absen.dao.BankDAO;
import com.hris.absen.dao.BaseDAO;
import com.hris.absen.entity.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService extends BaseService<Bank> {

    @Autowired
    private BankDAO dao;

    @Override
    protected BaseDAO<Bank> getDAO() {
        return dao;
    }
}
