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


## 구글 미트
https://meet.google.com/uou-bbtj-qzf