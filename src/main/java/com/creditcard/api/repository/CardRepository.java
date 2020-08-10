package com.creditcard.api.repository;

import com.creditcard.api.model.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CardRepository extends CrudRepository<Card, Integer> {
  Optional<Card> findByNumber(String number);
}
