package com.bitcamp.util;

public class ObjectListTest {

  public static void main(String[] args) {
    ObjectList list = new ObjectList();
    list.add("홍길동");
    list.add("임꺽정");
    list.add("유관순");
    list.add(null); // 목록에 null을 넣을 수 있다.
    list.add("안중근");


    Object obj = list.get(0); // 실제 get()이 리턴하는 것은 String 객체이다.
    System.out.println(obj.toString()); // obj 가 실제 가리키는 것은 String 클래스다.

    obj = list.get(1);
    System.out.println(obj.toString()); // "임꺽정"

    obj = list.get(2);
    System.out.println(obj.toString()); // "유관순"

    // println()
    // - 파라미터 값이 유효한 인스턴스 주소라면 toString()을 호출하여 그 리턴 값을 출력한다.
    //   따라서 굳이 toString()을 명시적으로 호출할 필요가 없다.
    System.out.println(list.get(4).toString()); // "안중근"
    System.out.println(list.get(4)); // "안중근"

    // - 파라미터 값이 null 이라면 그대로 "null"을 만들어 출력한다.
    System.out.println(list.get(3)); // "null" 출력

    // 생각해 볼 문제!
    // - get()이 null을 리턴한다면,
    //   예외 상황인가? 아니면 그냥 정상적인 상황인가?
    // 결론!
    // - null을 리턴한다고 해서 무조건 예외 상황이 아니다.
    // - 의도적으로 null을 저장해놓고 꺼낼 수 있기 때문이다.
    // - 따라서 인덱스를 잘못 지정한 경우와 구분해야 한다.
    //   인덱스를 잘못 지정했으면 예외 상황이지만,
    //   그밖에는 정상적인 상황이다.



  }
}
