package com.creditcard.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotBlank
  @JsonProperty("nome")
  private String name;

  public Integer getId() { return id; }

  public void setId(Integer id) { this.id = id; }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
