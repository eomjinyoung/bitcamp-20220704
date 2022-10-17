package com.bitcamp.board.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

public class MybatisConfig {

  public MybatisConfig() {
    System.out.println("MybatisConfig() 생성자 호출됨!");
  }

  @Bean
  public SqlSessionFactory sqlSessionFactory(
      DataSource ds,
      ApplicationContext iocContainer
      ) throws Exception {

    // SqlSessionFactory 를 만들어 줄 객체를 준비한다. 
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();

    // Mybatis가 사용할 DB 커넥션풀을 설정한다. 
    factoryBean.setDataSource(ds);

    // Mybatis가 실행할 SQL 문이 들어 있는 파일의 위치를 설정한다.
    factoryBean.setMapperLocations(
        iocContainer.getResource("classpath:com/bitcamp/board/mapper/*Mapper.xml"));

    return factoryBean.getObject();
  }

}








