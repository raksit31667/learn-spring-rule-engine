package com.raksit.example.rule.rule;

import com.raksit.example.rule.activity.Activity;
import com.raksit.example.rule.activity.CertificationBonus;
import com.raksit.example.rule.activity.VideoConferenceBonus;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Priority;
import org.jeasy.rules.annotation.Rule;

import java.time.LocalDate;

@Slf4j
@Rule
public class VideoConferenceRule {

  @Condition
  public boolean hasCompletedVideoConference(@Fact("activity") Activity activity) {
    return "Video Conference".equals(activity.getName());
  }

  @Action
  public void printBonusPoints(@Fact("activity") Activity activity) {
    VideoConferenceBonus videoConferenceBonus = VideoConferenceBonus.getBonus(activity.getId());
    log.info("Congratulations! You got {} bonus points", videoConferenceBonus.getPoints());
  }

  @Priority
  public int getPriority() {
    return 2;
  }
}
