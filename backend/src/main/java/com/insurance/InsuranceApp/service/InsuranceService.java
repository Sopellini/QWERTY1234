package com.insurance.InsuranceApp.service;

import com.insurance.InsuranceApp.model.Insurance;
import com.insurance.InsuranceApp.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sopel on 2017-09-17.
 */
@Service
@Transactional
public class InsuranceService {

    @Autowired
    InsuranceRepository insuranceRepository;

    public List<Insurance> getAllInsurances(){
        List<Insurance> listOfInsurances = new ArrayList<>();
        insuranceRepository.findAll().forEach(listOfInsurances::add);
        return listOfInsurances;
    }
}
