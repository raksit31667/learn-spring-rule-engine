package com.raksit.example.rule.activity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum CertificationBonus {

  TDD_101("1234", 20, LocalDate.of(2022, 2, 1), LocalDate.of(2022, 2, 28)),
  AGILE_101("5678", 30, LocalDate.of(2022, 3, 1), LocalDate.of(2022, 3, 31)),
  DEFAULT(null, 0, LocalDate.now(), LocalDate.now());

  private final String id;
  private final int points;
  private final LocalDate validFrom;
  private final LocalDate validUntil;

  public static CertificationBonus getBonus(String id) {
    return Arrays.stream(values())
        .filter(certification -> id.equals(certification.id))
        .findFirst()
        .orElseGet(() -> DEFAULT);
  }
}
