package com.creditcard.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class PaymentSubmit {
  @JsonProperty("cartaoId")
  private Integer cardId;

  @JsonProperty("descricao")
  private String description;

  @JsonProperty("valor")
  private BigDecimal value;

  public Integer getCardId() {
    return cardId;
  }

  public void setCardId(Integer cardId) { this.cardId = cardId; }

  public String getDescription() { return description; }

  public void setDescription(String description) { this.description = description; }

  public BigDecimal getValue() { return value; }

  public void setValue(BigDecimal value) { this.value = value; }
}
