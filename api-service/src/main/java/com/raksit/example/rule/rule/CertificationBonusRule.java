package com.raksit.example.rule.rule;

import com.raksit.example.rule.activity.Activity;
import com.raksit.example.rule.activity.CertificationBonus;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Priority;
import org.jeasy.rules.annotation.Rule;

@Slf4j
@Rule
public class CertificationBonusRule {

  @Condition
  public boolean hasCompletedCertification(@Fact("activity") Activity activity) {
    CertificationBonus certificationBonus = CertificationBonus.getBonus(activity.getId());
    return "Certification".equals(activity.getName())
        && activity.getPerformedOn().isAfter(certificationBonus.getValidFrom())
        && activity.getPerformedOn().isBefore(certificationBonus.getValidUntil());
  }

  @Action
  public void printBonusPoints(@Fact("activity") Activity activity) {
    CertificationBonus certificationBonus = CertificationBonus.getBonus(activity.getId());
    log.info("Congratulations! You got {} bonus points", certificationBonus.getPoints() * 2);
  }

  @Priority
  public int getPriority() {
    return 1;
  }
}
