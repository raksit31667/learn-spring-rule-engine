package com.raksit.example.rule.drools;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {

  private CustomerType type;

  private int years;

  private int discount;

  public Customer(CustomerType type, int years) {
    this.type = type;
    this.years = years;
  }

  public enum CustomerType {
    INDIVIDUAL,
    BUSINESS;
  }
}
