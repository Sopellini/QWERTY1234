package com.insurance.InsuranceApp.repository;

import com.insurance.InsuranceApp.model.Client;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Sopel on 2017-05-31.
 */
public interface ClientRepository extends CrudRepository<Client, Integer> {

}
