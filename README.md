# 자바-20220704

## 구글 미트

https://meet.google.com/uou-bbtj-qzf

## 강의 내용
### 1일
- 소프트웨어 개요
- 컴파일과 인터프리트, 하이브리드 방식
- JDK 설치

macOS 설정

.zshrc 파일
```
export JAVA_HOME=`/usr/libexec/java_home -v 17`
export PATH=${JAVA_HOME}/bin:$PATH
```

### 2일
- 비트를 이용하여 값을 메모리에 저장하는 방법
- 정수/부동소수점/문자/논리값의 2진수 표기법, 
- 리터럴

### 3일
- 자바 프로젝트의 Maven 표준 디렉토리 구조
- 자바 패키지 소속 클래스 컴파일과 실행
- 실습 프로젝트 준비
- 빌드 도구 개념 소개
- Gradle 빌드도구 설정
- Gradle 빌드도구로 프로젝트 준비
- Gradle 로 애플리케이션 실행
- Gradle 로 프로젝트 빌드 및 배포, 실행

### 4일
- 리터럴과 메모리 크기
    - 메모리 크기에 따라 정수 리터럴 표기하는 법
    - 메모리 크기에 따라 부동소수점 리터럴 표기하는 법
- 메모리 크기와 값의 범위
    - 정수, 부동소수점 리터럴의 유효한 값 범위
- 문자 리터럴과 코드 값
    - 문자 리터럴의 또다른 표기법
    - 문자 집합에 따른 문자 코드 값
    - 줄바꿈 코드(윈도우 vs 유닉스)
- 문자와 코드, 폰트의 관계
    - 래스터 폰트와 벡터 폰트
    - 비트맵 이미지와 벡터 이미지 
    - 이스케이프 문자

- 변수
    - 프로그램=애플리케이션
    - 프로세스=실행중인 프로그램
    - 프로세스와 OS 그리고 메모리
    - 변수 선언과 값 저장
    - l-value 와 r-value
    
### 5일
- 소스파일, 바이트코드, 실행까지의 문자 집합 변화 과정
- board-app 프로젝트 수행
  - 001. 프로젝트 준비 - Gradle 빌드 도구를 사용하여 프로젝트 준비하기
  - 002. 리터럴과 콘솔 출력 
  - 003. 키보드 입력과 변수, 조건문, 반복문

### 6일
- 부팅 과정 소개(ROM BIOS, Firmware, HDD 저장 원리 등)
- 변수와 연산자 사용법

### 7일
- 연산자 사용법(계속)
- 흐름제어문: if, if~ else~, switch, while, do~ while
- board-app 프로젝트 수행
  - 004. 변수 사용법

### 8일
- board-app 프로젝트 수행
  - 004. 변수 사용법(계속)
  - 005. 배열 사용법
- 배열: 레퍼런스와 인스턴스, 레퍼런스와 인덱스, 가비지, 가비지 컬렉터
- 흐름제어문: for (;;), for (:)
- 도구(메서드): 
  - 설정을 하고 사용하는 경우(인스턴스 메서드) 
  - 설정없이 사용하는 경우(스태틱 메서드) 
- 도구함을 이용한 설정
  - new 명령 사용법

### 9일
- board-app 프로젝트 수행
  - 006. 메서드 사용법(with static)
  - 007. 클래스 사용법
- Eclipse IDE 설치
  - 다운로드 및 설치, 설정
  - 프로젝트 임포트
  - Gradle로 이클립스 설정 파일을 만드는 방법

### 10일
- board-app 프로젝트 수행
  - 008. 클래스 사용법 II
- 기타
  - 자리 재배치

### 11일
- 메서드 사용법(eomcs-java-lang: com.eomcs.lang.ex07.*)
- 클래스 사용법(eomcs-java-lang: com.eomcs.oop.ex01.*)

### 12일
- 아침 특강(com.eomcs.quiz)
  - ex01.Test01: 2진수에서 1 값을 가지는 비트 수를 세기
  - ex01.Test02: 패리티 값을 알아내기 
- 클래스 사용법(eomcs-java-lang: com.eomcs.oop.ex01.*)(계속)
- 클래스 사용법(eomcs-java-lang: com.eomcs.oop.ex02.*)
  - 클래스 문법 활용: 사용자 정의 데이터 타입
  - 스태틱 메서드와 인스턴스 메서드
  - 중첩 클래스를 패키지 멤버 클래스로 전환
  - 패키지를 활용하여 클래스를 분류하기
  - 생성자 

### 13일
- 아침 특강(com.eomcs.quiz)
  - ex01.Test02/02_2/02_3: XOR 연산자의 특징
- 클래스 사용법(eomcs-java-lang: com.eomcs.oop.ex02.*)(계속)
  - 클래스 문법 활용: 메서드를 묶어서 분류
  - 스태틱 필드와 인스턴스 필드의 용도
  - 인스턴스 메서드가 필요한 이유
- board-app 프로젝트 수행
  - 009. 리팩토링: 함수 추출 및 함수 옮기기

### 14일 
- board-app 프로젝트 수행 
  - 010. 스태틱 필드의 한계
  - 011. 인스턴스 필드와 인스턴스 메서드, 생성자 사용법 
  - 012. 인스턴스 목록을 다루는 코드를 분리: High Cohesion 구현(재사용성 강화)

### 15일 
- board-app 프로젝트 수행 
  - 013. 회원관리 기능 추가: CRUD 구현
  - 014. 패키지를 이용하여 클래스를 분류하는 방법 + 접근 제어 조정
  - 015. 공통 코드(필드,메서드)를 공유하는 방법 : 상속 

### 16일 
- 아침 특강(com.eomcs.quiz)
  - ex02.Test01/02/03: 배열 다루기
- 클래스 사용법(eomcs-java-lang: com.eomcs.oop.ex03.*)
  - 스태틱 필드와 인스턴스 필드
  - 스태틱 메서드와 인스턴스 메서드, this 내장 변수
  - 생성자와 this()
  - 스태틱 초기화 블록, 스태틱 변수 초기화 문장
  - 인스턴스 초기화 블록, 인스턴스 변수 초기화 문장

### 17일 
- 아침 특강(com.eomcs.quiz)
  - ex01.Test07: 팩토리얼 다루기
  - ex02.Test04: 배열 다루기
- 클래스 사용법(eomcs-java-lang: com.eomcs.oop.ex05.*)
  - 상속을 통한 기능 확장법
  - UML: 클래스 간의 5가지 관계
  - 기타 기능 확장법 

### 18일 
- 아침 특강(com.eomcs.quiz)
  - ex01.Test08: 비트 연산자 다루기(2진수의 곱셈)
- board-app 프로젝트 수행 
  - 015. 공통 코드(필드,메서드)를 공유하는 방법 : 상속 (다시 연습)
- String 클래스 사용법(eomcs-java-lang: com.eomcs.basic.ex02.*)

### 19일 
- 아침 특강(com.eomcs.quiz)
  - ex01.Test09: 산술 진행에서 n번째 항목의 값 알아내기
  - ex01.Test10: n개의 숫자로 원을 구성할 때 서로 마주하는 숫자를 알아내기
  - ex02.Test05: 분수들 중에서 가장 큰 수를 알아내기
- board-app 프로젝트 수행 
  - 016. 예외를 처리하는 방법 1
  - 017. 예외를 처리하는 방법 2
  - 018. 예외를 발생시키는 방법 

### 20일 
- 아침 특강(com.eomcs.quiz)
  - ex01.Test11: 알파벳 카운트
  - ex01.Test12: 주어진 점이 원에 있는지 여부
- 예외를 다루는 방법(eomcs-java-lang: com.eomcs.exception.*)
- board-app 프로젝트 수행 
  - 019. 사용자 정의 예외를 다루는 방법 

### 21일 
- 아침 특강(com.eomcs.quiz)
  - ex01.Test13: 배수의 합 구하기 
  - ex01.Test14: 10진수 순서 뒤집기
  - ex02.Test06: 분수의 가분부(Improper) 여부 검사
- board-app 프로젝트 수행 
  - 020. 자료구조를 구현하고 다루는 방법: Linked List 구현 및 사용
  - 021. 공통 코드(필드,메서드)를 공유하는 방법 : 연관(association)  

### 22일 
- 아침 특강(com.eomcs.quiz)
  - ex01.Test15: 반복 문자열 여부 검사하기
  - ex02.Test07: 배열에서 가장 큰 짝수 알아내기
- board-app 프로젝트 수행 
  - 022. 자료구조를 구현하고 다루는 방법: Linked List 구현 및 사용
    - 021 버전에 LinkedList 적용
  - 023. 메서드 사용법을 규격화하여 객체 사용 방법을 일관성 있게 만들기: 인터페이스
  - 024. List 규격에 맞춰 LinkedList 구현하고 적용하기
- 인터페이스 사용법(eomcs-java-lang: com.eomcs.oop.ex09.*)

### 23일 
- 아침 특강(com.eomcs.quiz)
  - ex01.Test16: 윤년 구하기
  - ex02.Test08: 배열로 주어진 좌표를 점핑하는 수 구하기
- board-app 프로젝트 수행 
  - 025. 추상 클래스를 활용하여 인터페이스의 일부를 미리 구현하기
  - 026. 중첩 클래스 문법을 이용하여 클래스 사용 범위를 제한하기
  - 027. 스택 자료 구조를 활용하여 브래드크럼 메뉴 만들기
  - 028. 인터페이스를 이용하여 핸들러의 사용법을 규격화 하기
- 인터페이스 사용법(eomcs-java-lang: com.eomcs.oop.ex09.*)(계속)

### 24일 
- 아침 특강(com.eomcs.quiz)
  - ex01.Test17: 
  - ex01.Test18: 
- board-app 프로젝트 수행 
  - 029. 추상 클래스를 사용하여 핸들러의 공통 기능 구현하기: 템플릿 메서드 패턴 적용
  - 030. List가 특정 타입의 목록만 다루게 하는 방법: 제네릭 문법 적용
  - 031. 기존 List 구현체를 자바 컬렉션 API로 교체하기: java.util 패키지의 클래스 사용

### 25일 
- 아침 특강(com.eomcs.quiz)
  - ex01.Test19: 
  - ex01.Test20: 
- Iterator 패턴과 중첩 클래스 사용법(eomcs-java-lang: com.eomcs.design_pattern.iterator.*)

### 26일(8/8) 
- 아침 특강(com.eomcs.quiz)
  - ex01.Test21: 
  - ex01.Test22: 
- board-app 프로젝트 수행 
  - 031. 데이터 조회 로직을 객체화 하기: Iterator 패턴 적용
  - 032. 기존 List 구현체를 자바 컬렉션 API로 교체하기: java.util 패키지의 클래스 사용
  - 033. 입출력 API를 사용하여 데이터를 파일로 저장하기: 바이너리 저장

### 27일(8/9) 
- 아침 특강(com.eomcs.quiz)
  - ex02.Test09: 
  - ex02.Test10: 
- board-app 프로젝트 수행 
  - 033. 입출력 API를 사용하여 데이터를 파일로 저장하기: 바이너리 저장(계속)
  - 034. Primitive 타입 및 String 타입 데이터를 가공하여 입출력하는 기능을 객체화하기
- FileOutputStream/FileInputStream 사용법(board-app: com.bitcamp.study.*)
- DataOutputStream/DataInputStream 사용법(board-app: com.bitcamp.study.*)

### 28일(8/10) 
- 아침 특강(com.eomcs.quiz)
  - ex01.Test23: 
  - ex01.Test24: 
- board-app 프로젝트 수행 
  - 035. 자바에서 제공하는 데코레이터를 사용하기
  - 036. 인스턴스를 통째로 입출력하기: 객체 직렬화
  - 037. 인스턴스를 텍스트 형식으로 입출력하기: FileReader/FileWriter
  - 038. 리팩토링: Factory Method 패턴, Information Expert 패턴
- ObjectOutputStream/ObjectInputStream 사용법

### 29일(8/11) 
- 아침 특강(com.eomcs.quiz)
  - ex01.Test25: 
  - ex01.Test26: 
- board-app 프로젝트 수행 
  - 039. JSON 형식으로 데이터 입출력하기: Gson 라이브러리 사용
  - 040. 네트워킹을 이용한 파일 공유: client/server app. 아키텍처로 전환

### 교실 이전(8/12) 

### 30일(8/16) 

- board-app 프로젝트 수행 
  - 040. 네트워킹을 이용한 파일 공유: client/server app. 아키텍처로 전환(계속)
- 네트워크 프로그래밍 개요
  - ServerSocket, Socket 클래스 사용법
  - IP 주소와 포트 번호

### 31일(8/17) 

- 아침 특강(com.eomcs.quiz)
  - ex01.Test27: 
  - ex01.Test28: 
- board-app 프로젝트 수행 
  - 040. 네트워킹을 이용한 파일 공유: client/server app. 아키텍처로 전환(계속)
- 컬렉션 API 사용법(com.eomcs.basic.ex03.*)

### 32일(8/18) 

- board-app 프로젝트 수행 
  - 041. Client/Server 리팩토링
    - Hashtable, ArrayList 활용
    - 클라이언트 연결을 순차적으로 처리
- 컬렉션 API 사용법(com.eomcs.basic.ex03.*)(계속)

### 33일(8/19) 

- 아침 특강(com.eomcs.quiz)
  - ex01.Test30: 
- board-app 프로젝트 수행 
  - 042. Proxy 패턴을 이용한 네트워킹 코드 캡슐화
  - 043. Client/Server 공통 코드를 라이브러리 프로젝트로 분리하기
  - 044. 통신 방식을 Stateful에서 Stateless로 변경하기
- Proxy 패턴의 이해와 활용법
- Connection-Oriented 통신과 Connectionless 통신 비교
- Stateful 통신 방식과 Stateless 통신 방식 비교

### 34일(8/22) 

- 아침 특강(com.eomcs.quiz)
  - ex01.Test31:
  - ex02.Test12: 
- board-app 프로젝트 수행 
  - 045. Thread를 이용한 멀티 태스킹 구현하기: 동시 요청 처리하기
- 네트워킹 사용법(com.eomcs.net.*)

### 35일(8/23) 

- 아침 특강(com.eomcs.quiz)
  - ex01.Test32:
- 네트워킹 사용법(com.eomcs.net.*)(계속)

### 36일(8/24) 

- 아침 특강(com.eomcs.quiz)
  - ex01.Test33, 34, 35, 36:
- 네트워킹 사용법(com.eomcs.net.*)(계속)
- 스레드 사용법(com.eomcs.concurrent.*)
  - 멀티 태스킹 기법: 멀티 프로세싱, 멀티 스레딩
  - CPU 스케줄링, 컨텍스트 스위칭 
  
### 37일(8/25) 

- 아침 특강(com.eomcs.quiz)
  - 코딩 퀴즈는 백준 코딩 테스트로 대체한다.
- 스레드 사용법(com.eomcs.concurrent.*)(계속)
  - Thread, Runnable 사용법
  - 중첩 클래스를 다루는 방법
- board-app 프로젝트 수행 
  - 045. Thread를 이용한 멀티 태스킹 구현하기: 동시 요청 처리하기(계속)
    - 리팩토링: 중첩 클래스 활용

### 38일(8/26) 

- 스레드 사용법(com.eomcs.concurrent.*)(계속)
  - 스레드 라이프사이클 
  - 크리티컬 섹션과 스레드 안전
  - 뮤텍스와 세마포어
  - 자바에서 뮤텍스를 다루는 방법
- DBMS 사용법
  - Database와 DBMS
  - MariaDB 설치와 설정
  
### 39일(8/29) 

- SQL 사용법
  - DDL 사용법
- DBMS 사용법
  - 사용자 등록, 데이터베이스 생성, 권한 설정

### 40일(8/30) 

- SQL 사용법
  - DDL 사용법(계속)
  - DML 사용법

### 41일(8/31) 

- SQL 사용법
  - DML 사용법(계속)
  - PK, FK
  - 조인 예제 테이블 준비

### 42일(9/1) 

- SQL 사용법
  - 조인 사용법
  - 서브 쿼리 사용법
  - 그룹핑 사용법
- DB 모델링
  - ER-Diagram 도구 설치(www.exerd.com)
  
### 43일(9/2) 

- DB 모델링
  - 엔티티 식별 및 속성 식별
  - 제1,2,3 정규화 방법
  - 논리 모델링 및 물리 모델링
  - 포워드 엔지니어링을 통해 DDL 생성 및 테이블 생성

### 44일(9/5) 

- JDBC 프로그래밍(com.eomcs.jdbc.*)
  - DBMS Native API 와 ODBC API 개념
  - JDBC Driver 유형
  - JDBC 프로그래밍 절차
  - Driver 구현체 생성 및 DriverManager에 등록하는 방법
  - DBMS에 연결하는 방법

### 45일(9/6) 

- JDBC 프로그래밍(com.eomcs.jdbc.*)
  - insert, select, update, delete 을 다루는 법
  - SQL 삽입 공격을 막는 방법: Statement와 PreparedStatement
  - 트랜잭션 다루기
  
### 46일(9/7) 

- board-app 프로젝트 수행 
  - 046. DBMS 도입하기

### 47일(9/8) 

- board-app 프로젝트 수행 
  - 047. Connection 객체 공유하기
  - 048. Connection 객체 공유하기 II - 의존 객체 주입 방식
  - 049. DAO 객체를 교체하기 쉽게 만들기 - 의존 객체 주입과 인터페이스
  - 050. 트랜잭션 다루기 - 자동 커밋과 수동 커밋
- 팀별 프로젝트
  - 팀원 결정

### 48일(9/13) 

- board-app 프로젝트 수행 
  - 051. Application Server 구조로 전환하기
  
### 49일(9/14) 

- board-app 프로젝트 수행 
  - 051. Application Server 구조로 전환하기(계속)

### 50일(9/15) 

- board-app 프로젝트 수행 
  - 052. Web Application Server 구조로 전환하기 - 웹 기술 도입

### 51일(9/16) 

- board-app 프로젝트 수행 
  - 052. Web Application Server 구조로 전환하기 - 웹 기술 도입(계속)
  - 053. 명령처리 부분에 Command 패턴을 적용하기
  - 054. Command 객체의 사용법 통일하기 - 인터페이스 활용
  - 055. 애노테이션과 리플렉션 API를 활용하여 객체 자동 생성하기

### 52일(9/19) 

- board-app 프로젝트 수행 
  - 055. 애노테이션과 리플렉션 API를 활용하여 객체 자동 생성하기(계속)
  - 056. 웹서버와 애플리케이션 서버 기능 분리하기
  - 057. 웹 애플리케이션 서버를 자바 표준 웹 기술로 대체하기: Servlet/JSP

### 53일(9/20) 

- 서블릿 프로그래밍
  - JavaEE 기술 명세
  - JavaEE와 Servlet/JSP의 관계
  - JavaEE 버전과 하위 기술들
  - JavaEE 구현 서버
  - 웹애플리케이션을 배포하고 실행하는 원리
- board-app 프로젝트 수행 
  - 057. 웹 애플리케이션 서버를 자바 표준 웹 기술로 대체하기: Servlet/JSP(계속)

### 54일(9/21) 

- 서블릿 프로그래밍
  - Servlet 인터페이스의 메서드 호출 규칙
  - GenericServlet과 HttpServlet 클래스
- board-app 프로젝트 수행 
  - 057. 웹 애플리케이션 서버를 자바 표준 웹 기술로 대체하기: Servlet/JSP(계속)
  - 058. 서블릿이 사용할 자원을 공유하기
  - 059. 공동 보관소를 사용하여 서블릿이 사용할 자원을 공유하기

### 55일(9/22) 

- 서블릿 프로그래밍
  - ServletContext, HttpSession, ServletRequest, JspContext 보관소 생명주기와 사용법
  - JSP 구동 원리와 JSP element 사용법
- board-app 프로젝트 수행 
  - 059. 공동 보관소를 사용하여 서블릿이 사용할 자원을 공유하기(계속)
  - 060. 리스너를 이용하여 자원을 준비하기
  - 061. JSP를 이용하여 출력문을 자동으로 생성하기: MVC 모델1

 ### 56일(9/23) 

- 서블릿 프로그래밍
  - JSP로 만드는 서블릿 클래스의 규격
- board-app 프로젝트 수행 
  - 061. JSP를 이용하여 출력문을 자동으로 생성하기: MVC 모델1(계속)
- 팀별 프로젝트
  - 프로젝트 비전 및 주요 요구사항의 UI 프로토타입 발표
    - 5팀: 김연정, 최지연, 장슬기, 박진우, 임동현, 주영
    - 2팀: 장현경, 조영아, 유종현, 김민구, 박지민, 최유민
    - 3팀: 임은지, 최종찬, 박병민, 유제동, 이헌식
    - 1팀: 황의찬, 유성민, 윤주현, 안치운, 조주연, 임가온
    - 4팀: 김라윤, 김봉경, 신우섭
    - 6팀: 김원태, 문채원
  - Use-case 모델링
    - 액터 식별 방법 및 액터의 관계
    - 유스케이션 식별 방법 및 유스케이스 관계
    
### 57일(9/26) 

- 서블릿 프로그래밍
  - EL(Expression Language) 사용법
- board-app 프로젝트 수행 
  - 061. JSP를 이용하여 출력문을 자동으로 생성하기: MVC 모델1(계속)
  - 062. JSP에 있는 자바 코드를 Servlet으로 분리하기: MVC 모델2
  - 063. OGNL 표기법으로 객체 프로퍼티를 좀 더 쉽게 다루기: EL 문법 사용

### 58일(9/27) 

- 서블릿 프로그래밍
  - JSTL(JSP Standard Tag Library) 사용법
  - 세션의 구동 원리와 다루는 방법
- board-app 프로젝트 수행 
  - 063. OGNL 표기법으로 객체 프로퍼티를 좀 더 쉽게 다루기: EL 문법 사용(계속)
  - 064. JSP에서 자바 코드를 제거하기: JSTL 사용
  - 065. 로그인, 로그아웃 처리하기: HttpSession, Cookie 사용

### 59일(9/28) 

- 서블릿 프로그래밍
  - 쿠키의 구동 원리와 다루는 방법
- board-app 프로젝트 수행 
  - 065. 로그인, 로그아웃 처리하기: HttpSession, Cookie 사용(계속)
  - 066. 로그인 기능 활용하기: HttpSession 활용
  - 067. 로그인이 필요한 요청인 경우 로그인으로 유도하기: Filter 활용

### 60일(9/29) 

- 서블릿 프로그래밍
  - 필터 사용법
  - GET/POST 프로토콜의 동작 원리
  - POST 방식으로 한글 데이터를 보낼 때 한글이 깨지는 이유
- board-app 프로젝트 수행 
  - 067. 로그인이 필요한 요청인 경우 로그인으로 유도하기: Filter 활용(계속)
  - 068. POST 방식으로 데이터 보내기: GET/POST 요청

### 61일(9/30) 

- 서블릿 프로그래밍
  - 파일 업로드를 처리하는 방법
- board-app 프로젝트 수행 
  - 069. 파일을 업로드하기: multipart/form-data MIME 타입
- 팀별 프로젝트
  - 요구사항 정의
    - 우아한1팀: 황의찬, 유성민, 윤주현, 안치운, 조주연, 임가온
    - 6팀: 김원태, 문채원
    - 일석이조: 장현경, 조영아, 유종현, 김민구, 박지민, 최유민
    - 쎄스코: 김연정, 최지연, 장슬기, 박진우, 임동현, 주영
    - Gang of Three(GoT)조: 김라윤, 김봉경, 신우섭
    - 상부3조: 임은지, 최종찬, 박병민, 유제동, 이헌식

### 62일(10/04) 

- 서블릿 프로그래밍
  - Servlet 3.0 에 추가된 API를 사용하여 파일 업로드를 처리하는 방법
- board-app 프로젝트 수행 
  - 069. 파일을 업로드하기: multipart/form-data MIME 타입(계속)
  - 070. 파일을 업로드하기 II: Servler API로 파일업로드 처리하기

### 63일(10/05) 

- board-app 프로젝트 수행 
  - 071. DAO에서 비즈니스 로직 분리하기: Controller에서 비즈니스 로직처리
  - 072. Controller에서 비즈니스 로직 분리하기: 서비스 컴포넌트 도입
  - 073. 서비스 객체에 인터페이스 적용하기: 서비스 객체를 교체하기 쉽게 만들기

### 64일(10/06) 

- board-app 프로젝트 수행 
  - 074. 서비스 객체에 트랜잭션 적용하기
  - 075. DB 커넥션을 공유했을 때 발생하는 문제를 해결하기
  - 076. 트랜잭션 관리자 역할을 별도의 클래스로 분리하기

### 65일(10/07) 

- 서블릿 프로그래밍
  - 프론트 컨트롤러 디자인 패턴의 목적과 활용 방법
  - 자바 코드로 서블릿을 배치하는 방법
- board-app 프로젝트 수행 
  - 076. 트랜잭션 관리자 역할을 별도의 클래스로 분리하기(계속)
  - 077. Front Controller 디자인 패턴 도입하기
  - 078. 페이지 컨트롤러를 POJO로 전환하기

### 66일(10/11) 

- 스프링 프레임워크
  - Spring IoC 컨테이너 사용법
  - Spring WebMVC 프레임워크 사용법
- board-app 프로젝트 수행 
  - 079. Spring IoC 컨테이너 도입하기: 페이지 컨트롤러 생성 자동화
  - 080. Spring WebMVC 프론트 컨트롤러 도입하기

### 67일(10/12) 

- 스프링 프레임워크
  - Spring IoC 컨테이너 사용법(계속)
  - Spring WebMVC 프레임워크 사용법(계속)
- board-app 프로젝트 수행 
  - 081. CRUD를 수행하는 페이지 컨트롤러를 하나로 합치기
  - 082. Spring WebMVC 프레임워크 사용법

### 68일(10/13) 

- 스프링 프레임워크
  - Spring WebMVC 프레임워크 사용법(계속)
- board-app 프로젝트 수행 
  - 082. Spring WebMVC 프레임워크 사용법(계속)

### 69일(10/14) 

- 스프링 프레임워크
  - Spring WebMVC 프레임워크 사용법(계속)
- board-app 프로젝트 수행 
  - 082. Spring WebMVC 프레임워크 사용법(계속)
  - 083. Spring WebMVC 프레임워크 사용법 II : 기타 설정

### 70일(10/17) 

- 스프링 프레임워크
  - Spring WebMVC 프레임워크 사용법(계속)
- board-app 프로젝트 수행 
  - 084. Root IoC 컨테이너와 멀티 프론트 컨트롤러 사용법
  - 085. Mybatis SQL 매퍼 사용하기

### 71일(10/18) 

- 스프링 프레임워크
  - Spring WebMVC 프레임워크 사용법(계속)
- board-app 프로젝트 수행 
  - 085. Mybatis SQL 매퍼 사용하기(계속)

### 72일(10/19) 

- 스프링 프레임워크
  - Spring WebMVC 프레임워크 사용법(계속)
- board-app 프로젝트 수행 
  - 085. Mybatis SQL 매퍼 사용하기(계속)
  - 086. Mybatis SQL 매퍼 사용하기 II: DAO 구현 자동화
  - 087. 프로젝트에 서블릿 컨테이너(예:톰캣) 삽입하기

## 구글 미트
https://meet.google.com/uou-bbtj-qzf