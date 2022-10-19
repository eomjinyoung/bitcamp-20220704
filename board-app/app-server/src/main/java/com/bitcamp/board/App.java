package com.bitcamp.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

  public static void main(String[] args) {
    System.out.println("비트캠프 프로젝트!");

    SpringApplication.run(App.class, args);
  }

}
