package com.creditcard.api.controller;

import com.creditcard.api.model.Card;
import com.creditcard.api.model.CardSubmit;
import com.creditcard.api.model.Client;
import com.creditcard.api.service.CardService;
import com.creditcard.api.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class CardController {

  @Autowired
  private ClientService clientService;

  @Autowired
  private CardService cardService;

  @GetMapping("/cartao")
  public Iterable<Card> list() {
    return cardService.list();
  }

  @GetMapping("/cartao/{numero}")
  public Card get(@PathVariable("numero") String number) {
    return cardService.findByNumber(number).orElseThrow(() ->
      new ResponseStatusException(HttpStatus.NOT_FOUND, "Cartão não encontrado")
    );
  }

  @PostMapping("/cartao")
  @ResponseStatus(HttpStatus.CREATED)
  public Card create(
    @RequestBody CardSubmit cardSubmit
  ) {
    Client client = clientService.get(cardSubmit.getClientId()).orElseThrow(() ->
      new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado")
    );
    return cardService.create(cardSubmit, client);
  }

  @PatchMapping("/cartao/{numero}")
  @ResponseStatus(HttpStatus.OK)
  public Card patch(
    @PathVariable("numero") String number,
    @RequestBody(required = false) Card newCard
  ) {
    Card card = cardService.findByNumber(number).orElseThrow(() ->
      new ResponseStatusException(HttpStatus.NOT_FOUND, "Cartão não encontrado")
    );
    return cardService.update(card, newCard);
  }
}
