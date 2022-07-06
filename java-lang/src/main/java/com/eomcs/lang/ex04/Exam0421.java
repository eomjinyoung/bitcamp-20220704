package com.eomcs.lang.ex04;

//# 부동소수점 변수 - 변수의 메모리 크기
//
public class Exam0421 {
  public static void main(String[] args) {
    
    // 4바이트 부동소수점 변수
    //- 유효자릿수 7자리 부동소수점 저장 가능
    //- 10 진수로 부동소수점을 표현할 경우 소수점을 제외한 숫자가 7 개인 경우 정상적으로 메모리에 저장된다는 의미
    //
    float f;

    f = 9.876545f; // 소수점을 떼면 숫자의 개수가 7개이다.
    System.out.println(f);

    f = 987654.5f; // 소수점을 떼면 숫자의 개수가 7개이다.
    System.out.println(f);

    // 소수점을 뗐을 때 앞에 0만 있을 경우 그 0은 자릿수에서 제외한다.
    f = 0.000009876545f; // 소수점을 떼면 숫자가 13개 이지만, 앞의 0을 제외하면 실제 7개이다.
    System.out.println(f); // OK
    
    // 주의!
    //- 유효자릿수가 7자리를 넘어가면 정상적으로 값을 저장되지 않을 수 있다.
    f = 9.8765456f; // 맨 뒤의 값이 반올림 된다.
    System.out.println(f);
    
    f = 9876545.6f; // 맨 뒤의 값이 반올림 된다.
    System.out.println(f);
  }
}
