package com.bitcamp.board.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

public class DatabaseConfig {

  public DatabaseConfig() {
    System.out.println("DatabaseConfig() 생성자 호출됨!");
  }

  @Bean
  public PlatformTransactionManager transactionManager(DataSource ds) {
    System.out.println("PlatformTransactionManager 객체 생성!");
    return new DataSourceTransactionManager(ds);
  }

  @Bean
  public DataSource dataSource() {
    System.out.println("DataSource 객체 생성!");
    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName("org.mariadb.jdbc.Driver");
    ds.setUrl("jdbc:mariadb://localhost:3306/studydb");
    ds.setUsername("study");
    ds.setPassword("1111");
    return ds;
  }
}








