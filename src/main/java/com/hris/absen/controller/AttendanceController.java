package com.hris.absen.controller;

import com.hris.absen.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("attendences")
@PreAuthorize("permitAll()")
public class AttendanceController extends BaseController{

    @Autowired
    private AttendanceService service;
}
