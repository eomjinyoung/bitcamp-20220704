package com.bitcamp.board;

import java.io.File;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

public class App {

  public static void main(String[] args) {
    System.out.println("비트캠프 프로젝트!");

    // 톰캣 서버를 구동시키는 객체를 준비한다.
    Tomcat tomcat = new Tomcat();

    // 서버의 포트 번호를 설정한다.
    tomcat.setPort(8888);

    // 톰캣 서버를 실행하는 동안 사용할 임시 디렉토리를 설정한다.
    tomcat.setBaseDir("temp");

    // 서버의 연결 정보를 설정한다.
    Connector connector = tomcat.getConnector();

    // 클라이언트와 데이터를 주고 받을 때 적용할 문자 집합을 설정한다.
    connector.setURIEncoding("UTF-8");

    // 웹 애플리케이션의 context path와 배치 디렉토를 설정한다.
    tomcat.addWebapp(
        "/", // 웹 애플리케이션 context path 
        new File("./src/main/webapp/").getAbsolutePath());

    try {
      // 톰캣 서버를 실행한다.
      tomcat.start();

    } catch (LifecycleException e) {
      e.printStackTrace();
    }

    // 톰캣 서버가 종료될 때까지 JVM을 끝내지 않고 기다린다.
    tomcat.getServer().await();
  }

}
