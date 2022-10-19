package com.bitcamp.board.config;

import javax.sql.DataSource;
import org.apache.ibatis.logging.LogFactory;
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

    System.out.println("sqlSessionFactory() 호출됨!");

    // Mybatis의 Log4j2 기능 활성화시키기
    LogFactory.useLog4J2Logging();

    // SqlSessionFactory 를 만들어 줄 객체를 준비한다. 
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();

    // Mybatis가 사용할 DB 커넥션풀을 설정한다. 
    factoryBean.setDataSource(ds);

    // Mybatis가 실행할 SQL 문이 들어 있는 파일의 위치를 설정한다.
    factoryBean.setMapperLocations(
        iocContainer.getResources("classpath:com/bitcamp/board/mapper/*Mapper.xml"));

    // 도메인 클래스의 별명을 자동으로 부여한다.
    // - 패키지 명을 제외한 클래스 이름이 별명으로 사용된다.
    // - 별명은 대소문자를 구분하지 않는다.
    factoryBean.setTypeAliasesPackage("com.bitcamp.board.domain");

    return factoryBean.getObject();
  }

}








