package com.raksit.example.rule.activity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity {

  private String name;
  private String id;

  @JsonDeserialize(using = LocalDateDeserializer.class)
  private LocalDate performedOn;
}
