package com.hris.absen.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hris.absen.common.RestResult;
import com.hris.absen.common.StatusCode;
import com.hris.absen.entity.Bank;
import com.hris.absen.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("banks")
@PreAuthorize("permitAll()")
public class BankController extends BaseController{

    @Autowired
    private BankService service;

    @PreAuthorize("permitAll()")
    @GetMapping
    public RestResult get(@RequestParam(value = "param", required = false) String param,
                          @RequestParam(value = "offset") int offset,
                          @RequestParam(value = "limit") int limit) throws JsonProcessingException {
        Bank bank = param != null ? new ObjectMapper().readValue(param, Bank.class) : null;

        long rows = service.count(bank);

        return new RestResult(rows > 0 ? service.find(bank, offset, limit) : new ArrayList<>(), rows);
    }

    @PostMapping
    public RestResult save(@RequestBody Bank param){
        param = service.save(param);
        return new RestResult(param, param != null ? StatusCode.SAVE_SUCCESS : StatusCode.SAVE_FAILED);
    }

    @PutMapping
    public RestResult update(@RequestBody Bank bank){
        bank = service.update(bank);
        return new RestResult(bank, bank != null ? StatusCode.UPDATE_SUCCESS : StatusCode.UPDATE_FAILED);
    }

    @PreAuthorize("permitAll()")
    @DeleteMapping(value = "{id}")
    public RestResult delete(@PathVariable Long id){
        return new RestResult(service.delete(id) ? StatusCode.DELETE_SUCCESS : StatusCode.DELETE_FAILED);
    }

}
