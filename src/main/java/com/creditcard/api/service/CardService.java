package com.creditcard.api.service;

import com.creditcard.api.model.Card;
import com.creditcard.api.model.CardSubmit;
import com.creditcard.api.model.Client;
import com.creditcard.api.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CardService {

  @Autowired
  private CardRepository repository;

  public Iterable<Card> list() {
    return repository.findAll();
  }

  public Optional<Card> get(Integer id) {
    return repository.findById(id);
  }

  public Optional<Card> findByNumber(String number) {
    return repository.findByNumber(number);
  }

  public Card create(CardSubmit cardSubmit, Client client) {
    Card card = new Card();
    card.setClient(client);
    card.setNumber(cardSubmit.getNumber());
    return repository.save(card);
  }

  public Card update(Card card, Card newCard) {
    card.setActive(newCard.getActive());
    return repository.save(card);
  }
}
