package com.insurance.InsuranceApp.repository;

import com.insurance.InsuranceApp.model.Insurance;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Sopel on 2017-08-13.
 */
public interface InsuranceRepository extends CrudRepository<Insurance, Integer> {
}
