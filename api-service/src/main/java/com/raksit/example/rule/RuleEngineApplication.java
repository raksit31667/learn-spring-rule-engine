package com.raksit.example.rule;

import com.raksit.example.rule.tracing.MdcTaskDecorator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;


@SpringBootApplication
public class RuleEngineApplication {

  @Autowired
  private MdcTaskDecorator mdcTaskDecorator;

  @Bean
  public Executor taskExecutor() {
    ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
    threadPoolTaskExecutor.setTaskDecorator(mdcTaskDecorator);
    threadPoolTaskExecutor.initialize();
    return threadPoolTaskExecutor;
  }

  public static void main(String[] args) {
    SpringApplication.run(RuleEngineApplication.class, args);
  }
}
