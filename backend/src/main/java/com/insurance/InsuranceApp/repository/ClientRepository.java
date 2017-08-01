package com.insurance.InsuranceApp.repository;

import com.insurance.InsuranceApp.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Sopel on 2017-05-31.
 */
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
