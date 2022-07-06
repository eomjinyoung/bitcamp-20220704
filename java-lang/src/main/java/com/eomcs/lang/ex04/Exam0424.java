package com.eomcs.lang.ex04;

//# 부동소수점 변수 - 변수와 리터럴의 크기 II
//
public class Exam0424 {
  public static void main(String[] args) {
    
    double d;

    // 주의!
    // - 잘못된 리터럴 값을 변수에 저장해봐야 소용없다!
    
    d = 99999.8888877777f;
    System.out.println(d);
    // 4바이트 크기를 넘어가는 부동소수점 리터럴은 이미 짤린 값이기 때문에 제대로 저장될 수 없다.
    
    
    d = 99999.8888877777f;
    System.out.println(d);
    
    // 주의!
    // 정수의 경우 리터럴을 표현할 때 
    // 값이 그 크기를 넘어가면 컴파일 오류가 발생하지만,
    // 부동소수점의 경우 리터럴이 메모리의 크기를 넘어갈 때
    // 컴파일 오류 대신 단지 값이 짤린다.

    
    // 변수의 크기에 맞춰 부동소수점의 리터럴을 지정하라.
    float f = 99999.88f;
    System.out.println(f);
    
    d = 99999.8888877777;
    System.out.println(d);

    // 4바이트 부동소수점을 8바이트 메모리에 저장할 때
    // 계산 방식에 의해 소수점 이하의 수가 근사 값으로 바뀐다.
    // => 8바이트 메모리에 값을 저장할 때는 8바이트 리터럴을 사용하라.
    d = 99999.88f;
    System.out.println(d);
  }
}

