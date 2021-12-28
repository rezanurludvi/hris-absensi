package com.hris.absen.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hris.absen.common.RestResult;
import com.hris.absen.common.StatusCode;
import com.hris.absen.entity.Attendance;
import com.hris.absen.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("attendances")
public class AttendanceController extends BaseController{

    @Autowired
    private AttendanceService service;

    @PreAuthorize("permitAll()")
    @GetMapping
    public RestResult find(@RequestParam(value = "param", required = false) String param,
                           @RequestParam(value = "offset", required = false) int offset,
                           @RequestParam(value = "limit", required = false) int limit) throws JsonProcessingException {
        Attendance attendance = param != null ? new ObjectMapper().readValue(param, Attendance.class) : new Attendance();

        Long rows = service.count(attendance);

        return new RestResult(rows > 0 ? service.find(attendance, offset, limit) : new ArrayList<>(), rows);
    }

    @PreAuthorize("permitAll()")
    @PostMapping
    public RestResult save(@RequestBody Attendance entity){
       RestResult result = new RestResult(StatusCode.OPERATION_FAILED);

       if (entity != null){
           result.setData(service.save(entity));
           result.setStatus(StatusCode.SAVE_SUCCESS);
       }
        return result;
    }


    @PreAuthorize("permitAll()")
    @DeleteMapping(value = "{id}")
    public RestResult delete(@PathVariable Long id){
        return new RestResult(service.delete(id) ? StatusCode.DELETE_SUCCESS : StatusCode.DELETE_FAILED);
    }
}
