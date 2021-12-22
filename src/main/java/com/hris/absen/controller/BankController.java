package com.hris.absen.controller;

import com.hris.absen.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("banks")
@PreAuthorize("permitAll()")
public class BankController extends BaseController{

    @Autowired
    private BankService service;
}
