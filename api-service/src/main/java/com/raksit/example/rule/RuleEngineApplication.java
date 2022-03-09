package com.raksit.example.rule;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.raksit.example.rule.easy.activity.Activity;
import com.raksit.example.rule.easy.rule.CertificationBonusRule;
import com.raksit.example.rule.easy.rule.VideoConferenceRule;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class RuleEngineApplication implements CommandLineRunner {

  public static void main(String[] args) throws IOException {
    SpringApplication.run(RuleEngineApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    RulesEngine rulesEngine = new DefaultRulesEngine();
    Rules rules = new Rules();
    rules.register(new CertificationBonusRule(), new VideoConferenceRule());

    MappingIterator<Activity> activityIterator = new CsvMapper().readerWithSchemaFor(Activity.class)
        .readValues(new ClassPathResource("activities.csv").getFile());
    List<Activity> activities = activityIterator.readAll();

    activities.forEach(activity -> {
      Facts facts = new Facts();
      facts.put("activity", activity);
      rulesEngine.fire(rules, facts);
    });
  }
}
