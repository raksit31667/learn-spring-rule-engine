package com.raksit.example.rule.drools;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

@Service
public class CustomerDiscountService {

  private final KieContainer kieContainer;

  public CustomerDiscountService(KieContainer kieContainer) {
    this.kieContainer = kieContainer;
  }

  public void calculateDiscount(Customer customer) {
    KieSession kieSession = kieContainer.newKieSession();
    kieSession.insert(customer);
    kieSession.fireAllRules();
    kieSession.dispose();
  }
}
