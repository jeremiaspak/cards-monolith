package com.creditcard.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotBlank
  @JsonProperty("descricao")
  private String description;

  @NotNull
  @JsonProperty("valor")
  private BigDecimal value;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "card_id")
  @JsonIgnore
  private Card card;

  @Column(name = "card_id", insertable = false, updatable = false)
  @JsonProperty("cartaoId")
  private Integer cardId;

  public Integer getId() { return id; }

  public void setId(Integer id) { this.id = id; }

  public String getDescription() { return description; }

  public void setDescription(String description) { this.description = description; }

  public BigDecimal getValue() { return value; }

  public void setValue(BigDecimal value) { this.value = value; }

  public Card getCard() { return card; }

  public void setCard(Card card) { this.card = card; }

  public Integer getCardId() { return cardId; }

  public void setCardId(Integer cardId) { this.cardId = cardId; }
}
