package com.hris.absen.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hris.absen.common.RestResult;
import com.hris.absen.common.StatusCode;
import com.hris.absen.entity.Employee;
import com.hris.absen.service.EmployeeService;
import com.hris.absen.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("employees")
@PreAuthorize("permitAll()")
public class EmployeeController extends BaseController{

    @Autowired
    private EmployeeService service;

    @PreAuthorize("permitAll()")
    @GetMapping
    public RestResult find(@RequestParam(value = "param", required = false) String param,
                               @RequestParam(value = "offset") int offset,
                               @RequestParam(value = "limit") int limit) throws JsonProcessingException {
        Employee employee = param != null ? new ObjectMapper().readValue(param, Employee.class) : new Employee();

        Long rows = service.count(employee);

        return new RestResult(rows > 0 ? service.find(employee, offset, limit) : new ArrayList<>(), rows);
    }

    @PreAuthorize("permitAll()")
    @GetMapping(value = "by-date")
    public RestResult findByDate(@RequestParam(value = "param", required = false) String param,
                                 @RequestParam(value = "start-date") String startDate,
                                 @RequestParam(value = "end-date") String endDate) throws JsonProcessingException {
        RestResult result = new RestResult(StatusCode.OPERATION_FAILED);

        Employee employee = param != null ? new ObjectMapper().readValue(param, Employee.class) : new Employee();

        result.setData(service.findByDate(employee, DateUtils.fromString(startDate), DateUtils.fromString(endDate)));
        result.setRows((long) service.findByDate(employee, DateUtils.fromString(startDate), DateUtils.fromString(endDate)).size());

        return result;
    }

    @PreAuthorize("permitAll()")
    @PostMapping
    public RestResult save(@RequestBody Employee entity){
        RestResult result = new RestResult(StatusCode.OPERATION_FAILED);

        if (entity != null){
            result.setData(service.save(entity));
            result.setStatus(StatusCode.SAVE_SUCCESS);
        }

        return result;
    }

    @PreAuthorize("permitAll()")
    @PutMapping
    public RestResult update(@RequestBody Employee entity){
        RestResult result = new RestResult(StatusCode.OPERATION_FAILED);

        if (entity != null){
            result.setData(service.update(entity));
            result.setStatus(service.update(entity) != null ? StatusCode.UPDATE_SUCCESS : StatusCode.UPDATE_FAILED);
        }

        return result;
    }

    @PreAuthorize("permitAll()")
    @DeleteMapping(value = "{id}")
    public RestResult delete(@PathVariable Long id){
        return new RestResult(service.delete(id) ? StatusCode.DELETE_SUCCESS : StatusCode.DELETE_FAILED);
    }
}
