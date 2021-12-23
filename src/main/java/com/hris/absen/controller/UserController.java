package com.hris.absen.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hris.absen.common.RestResult;
import com.hris.absen.common.StatusCode;
import com.hris.absen.entity.User;
import com.hris.absen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("users")
public class UserController extends BaseController{

    @Autowired
    private UserService service;

//    @PreAuthorize("permitAll()")
//    @GetMapping
//    public RestResult find(@RequestParam(value = "param", required = false) String param,
//                           @RequestParam(value = "offset", required = false) int offset,
//                           @RequestParam(value = "limit", required = false) int limit) throws JsonProcessingException {
//        User user = param != null ? new ObjectMapper().readValue(param, User.class) : new User();
//
//        Long rows = service.count(user);
//
//        return new RestResult(rows > 0 ? service.find(user, offset, limit) : new ArrayList<>(), rows);
//    }
//
//    @PreAuthorize("permitAll()")
//    @PostMapping
//    public RestResult save(@RequestBody User param){
//        param = service.save(param);
//
//        return new RestResult(param, param != null ? StatusCode.SAVE_SUCCESS : StatusCode.SAVE_FAILED);
//    }
}
