package com.creditcard.api.controller;

import com.creditcard.api.model.*;
import com.creditcard.api.service.CardService;
import com.creditcard.api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PaymentController {

  @Autowired
  private PaymentService paymentService;

  @Autowired
  private CardService cardService;

  @GetMapping("/pagamentos")
  public Iterable<Payment> list() {
    return paymentService.list();
  }

  @GetMapping("/pagamentos/{id_cartao}")
  public Iterable<Payment> getByCardId(
    @PathVariable("id_cartao") Integer cardId
  ) {
    Card card = cardService.get(cardId).orElseThrow(() ->
      new ResponseStatusException(HttpStatus.NOT_FOUND, "Cartão não encontrado")
    );
    return paymentService.findByCardId(cardId);
  }

  @PostMapping("/pagamentos")
  @ResponseStatus(HttpStatus.CREATED)
  public Payment create(
    @RequestBody PaymentSubmit paymentSubmit
  ) {
    Card card = cardService.get(paymentSubmit.getCardId()).orElseThrow(() ->
      new ResponseStatusException(HttpStatus.NOT_FOUND, "Cartão não encontrado")
    );
    return paymentService.create(paymentSubmit, card);
  }
}
