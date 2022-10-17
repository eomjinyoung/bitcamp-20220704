package com.bitcamp.board.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;

@ComponentScan(
    value="com.bitcamp.board",
    excludeFilters = @Filter(
        type = FilterType.REGEX,
        pattern = "com.bitcamp.board.controller.*")
    )
public class RootConfig {
  public RootConfig() {
    System.out.println("RootConfig() 생성자 호출됨!");
  }
}








