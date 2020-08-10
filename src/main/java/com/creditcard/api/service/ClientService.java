package com.creditcard.api.service;

import com.creditcard.api.model.Client;
import com.creditcard.api.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

  @Autowired
  private ClientRepository repository;

  public Iterable<Client> list() {
        return repository.findAll();
  }

  public Optional<Client> get(Integer id) {
    return repository.findById(id);
  }

  public Client create(Client client) {
    return repository.save(client);
  }
}
