package com.creditcard.api.repository;

import com.creditcard.api.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> { }
