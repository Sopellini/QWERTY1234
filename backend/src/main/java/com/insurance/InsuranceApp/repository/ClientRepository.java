package com.insurance.InsuranceApp.repository;

import com.insurance.InsuranceApp.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sopel on 2017-05-31.
 */
@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

    Client findByPesel(Long pesel);
}
