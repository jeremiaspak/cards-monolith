package com.creditcard.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Card {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotBlank
  @JsonProperty("numero")
  private String number;

  @NotNull
  @JsonProperty("ativo")
  @Column(columnDefinition = "boolean default false")
  private Boolean active = false;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "client_id")
  @JsonIgnore
  private Client client;

  @Column(name = "client_id", insertable = false, updatable = false)
  @JsonProperty("clienteId")
  private Integer clientId;

  public Integer getId() { return id; }

  public void setId(Integer id) { this.id = id; }

  public void setNumber(String number) { this.number = number; }

  public String getNumber() { return number; }

  public Boolean getActive() { return active; }

  public void setActive(Boolean active) { this.active = active; }

  public Client getClient() { return client; }

  public void setClient(Client client) { this.client = client; }

  public Integer getClientId() { return clientId; }

  public void setClientId(Integer clientId) { this.clientId = clientId; }
}
