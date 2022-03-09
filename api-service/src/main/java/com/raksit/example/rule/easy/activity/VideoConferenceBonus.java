package com.raksit.example.rule.easy.activity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum VideoConferenceBonus {

  TDD_101("1234", 25),
  AGILE_101("5678", 50),
  DEFAULT(null, 0);

  private final String id;
  private final int points;

  public static VideoConferenceBonus getBonus(String id) {
    return Arrays.stream(values())
        .filter(videoConference -> id.equals(videoConference.id))
        .findFirst()
        .orElseGet(() -> DEFAULT);
  }
}
