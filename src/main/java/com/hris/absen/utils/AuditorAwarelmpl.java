package com.hris.absen.utils;

import com.hris.absen.common.RestResult;
import com.hris.absen.controller.AuthenticationController;
import com.hris.absen.dao.UserDAO;
import com.hris.absen.entity.BaseEntity;
import com.hris.absen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public class AuditorAwarelmpl implements AuditorAware<String> {

    @Autowired
    private UserDAO dao;

    @Override
    public Optional<String> getCurrentAuditor(){
//        User dao = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        return Optional.of(dao.getUsername());
        return Optional.of("Rezha");
    }
}
