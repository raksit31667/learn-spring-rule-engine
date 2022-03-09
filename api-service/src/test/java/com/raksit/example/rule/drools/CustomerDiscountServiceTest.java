package com.raksit.example.rule.drools;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.raksit.example.rule.drools.Customer.CustomerType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CustomerDiscountServiceTest {

  @Autowired
  private CustomerDiscountService customerDiscountService;

  @Test
  void giveIndividualLongStanding_whenFireRule_thenCorrectDiscount() {
    Customer customer = new Customer(CustomerType.INDIVIDUAL, 5);

    customerDiscountService.calculateDiscount(customer);

    assertEquals(15, customer.getDiscount());
  }

  @Test
  void giveIndividualRecent_whenFireRule_thenCorrectDiscount() {
    Customer customer = new Customer(CustomerType.INDIVIDUAL, 1);

    customerDiscountService.calculateDiscount(customer);

    assertEquals(5, customer.getDiscount());
  }

  @Test
  void giveBusinessAny_whenFireRule_thenCorrectDiscount() {
    Customer customer = new Customer(CustomerType.BUSINESS, 0);

    customerDiscountService.calculateDiscount(customer);

    assertEquals(20, customer.getDiscount());
  }
}