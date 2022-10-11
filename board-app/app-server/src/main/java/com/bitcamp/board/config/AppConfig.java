package com.bitcamp.board.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

//스프링 IoC 컨테이너의 설정을 수행하는 클래스
//1) DB 커넥션 객체 관리자 준비 : DataSource
//2) 트랜잭션 관리자 준비: TransactionManager
public class AppConfig {

  public AppConfig() {
    System.out.println("AppConfig() 생성자 호출됨!");
  }

  // DataSource 를 생성하는 메서드를 호출하라고 애노테이션으로 표시한다.
  // 메서드가 리턴한 객체는 @Bean 애노테이션에 지정된 이름으로 컨테이너에 보관될 것이다.
  @Bean("dataSource")
  public DataSource createDataSource() {
    System.out.println("createDataSource() 호출됨!");

    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName("org.mariadb.jdbc.Driver");
    ds.setUrl("jdbc:mariadb://localhost:3306/studydb");
    ds.setUsername("study");
    ds.setPassword("1111");
    return ds;
  }
  //
  //  public PlatformTransactionManager createTransactionManager(DataSource ds) {
  //    System.out.println("createTransactionManager() 호출됨!");
  //
  //    return new DataSourceTransactionManager(ds);
  //  }
}
