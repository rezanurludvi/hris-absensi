package com.hris.absen.controller;

import com.hris.absen.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("companys")
@PreAuthorize("permitAll()")
public class CompanyController extends BaseController{

    @Autowired
    private CompanyService service;
}
