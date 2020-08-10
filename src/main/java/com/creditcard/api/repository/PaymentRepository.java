package com.creditcard.api.repository;

import com.creditcard.api.model.Card;
import com.creditcard.api.model.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository  extends CrudRepository<Payment, Integer> {
  Iterable<Payment> findByCardId(Integer cardId);
}
