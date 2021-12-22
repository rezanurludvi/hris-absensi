package com.hris.absen.service;

import com.hris.absen.dao.BaseDAO;
import com.hris.absen.dao.PositionDAO;
import com.hris.absen.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionService extends BaseService<Position> {

    @Autowired
    private PositionDAO dao;

    @Override
    protected BaseDAO<Position> getDAO() {
        return dao;
    }
}
