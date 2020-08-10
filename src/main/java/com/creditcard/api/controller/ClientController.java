package com.creditcard.api.controller;

import com.creditcard.api.model.Client;
import com.creditcard.api.service.CardService;
import com.creditcard.api.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class ClientController {

  @Autowired
  private ClientService clientService;

  @Autowired
  private CardService cardService;

  @GetMapping("/cliente")
  public Iterable<Client> list() { return clientService.list(); }

  @GetMapping("/cliente/{id}")
  public Client get(@PathVariable("id") Integer id) {
    return clientService.get(id).orElseThrow(() ->
      new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado")
    );
  }

  @PostMapping("/cliente")
  @ResponseStatus(HttpStatus.CREATED)
  public Client create(@Valid @RequestBody Client client) {
    return clientService.create(client);
  }
}
