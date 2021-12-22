package com.hris.absen.controller;

import com.hris.absen.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("positions")
@PreAuthorize("permitAll()")
public class PositionController extends BaseController{

    @Autowired
    private PositionService service;

}
