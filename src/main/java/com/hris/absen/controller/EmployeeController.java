package com.hris.absen.controller;

import com.hris.absen.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employees")
@PreAuthorize("permitAll()")
public class EmployeeController extends BaseController{

    @Autowired
    private EmployeeService service;
}
