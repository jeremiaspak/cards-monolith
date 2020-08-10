package com.creditcard.api.service;

import com.creditcard.api.model.*;
import com.creditcard.api.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {

  @Autowired
  private PaymentRepository repository;

  public Iterable<Payment> list() {
    return repository.findAll();
  }

  public Optional<Payment> get(Integer id) {
    return repository.findById(id);
  }

  public Iterable<Payment> findByCardId(Integer cardId) {
    return repository.findByCardId(cardId);
  }

  public Payment create(PaymentSubmit paymentSubmit, Card card) {
    Payment payment = new Payment();
    payment.setDescription(paymentSubmit.getDescription());
    payment.setValue(paymentSubmit.getValue());
    payment.setCard(card);
    return repository.save(payment);
  }
}
