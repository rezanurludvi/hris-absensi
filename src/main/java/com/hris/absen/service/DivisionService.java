package com.hris.absen.service;

import com.hris.absen.dao.BaseDAO;
import com.hris.absen.dao.DivisionDAO;
import com.hris.absen.entity.Division;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DivisionService extends BaseService<Division> {

    @Autowired
    private DivisionDAO dao;

    @Override
    protected BaseDAO<Division> getDAO(){
        return dao;
    }
}
