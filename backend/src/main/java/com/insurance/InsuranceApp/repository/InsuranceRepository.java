package com.insurance.InsuranceApp.repository;

import com.insurance.InsuranceApp.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Sopel on 2017-08-13.
 */
public interface InsuranceRepository extends JpaRepository<Insurance, Integer>{
}
