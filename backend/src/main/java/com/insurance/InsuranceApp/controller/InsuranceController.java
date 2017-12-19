package com.insurance.InsuranceApp.controller;

import com.insurance.InsuranceApp.model.Insurance;
import com.insurance.InsuranceApp.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by Sopel on 2017-08-13.
 */

@RestController
@RequestMapping("/api")
public class InsuranceController {

    @Autowired
    InsuranceService insuranceService;

    @RequestMapping(value = "/insurances", method = RequestMethod.GET)
    public ResponseEntity allInsurances(){
        List<Insurance> allInurances = insuranceService.getAllInsurances();
        return new ResponseEntity<>(allInurances, HttpStatus.OK);
    }
}
