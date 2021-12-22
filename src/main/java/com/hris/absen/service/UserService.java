package com.hris.absen.service;

import com.hris.absen.dao.BaseDAO;
import com.hris.absen.dao.UserDAO;
import com.hris.absen.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User> {

    @Autowired
    private UserDAO dao;

    @Override
    protected BaseDAO<User> getDAO() {
        return dao;
    }
}
