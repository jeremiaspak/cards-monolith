package com.creditcard.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardSubmit {

  @JsonProperty("clienteId")
  private Integer clientId;

  @JsonProperty("numero")
  private String number;

  public Integer getClientId() {
    return clientId;
  }

  public void setClientId(Integer clientId) {
    this.clientId = clientId;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }
}
