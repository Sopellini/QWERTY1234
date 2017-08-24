package com.insurance.InsuranceApp.controller;

import com.insurance.InsuranceApp.model.Insurance;
import com.insurance.InsuranceApp.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Sopel on 2017-08-13.
 */

@RestController
@RequestMapping("/api")
public class InsuranceController {

    @Autowired
    InsuranceRepository insuranceRepository;

    @RequestMapping(value = "/insurances", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity allInsurances(){
        Iterable<Insurance> all = insuranceRepository.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }


}
