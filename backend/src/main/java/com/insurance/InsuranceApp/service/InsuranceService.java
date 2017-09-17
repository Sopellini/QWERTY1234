package com.insurance.InsuranceApp.service;

import com.insurance.InsuranceApp.model.Insurance;
import com.insurance.InsuranceApp.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Sopel on 2017-09-17.
 */
@Service
@Transactional
public class InsuranceService {

    @Autowired
    InsuranceRepository insuranceRepository;

    public Iterable<Insurance> getAllInsurances(){
        return insuranceRepository.findAll();
    }
}
