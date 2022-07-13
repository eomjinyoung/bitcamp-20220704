/*
 * 게시판 관리 애플리케이션
 * 비트캠프-20220704
 */
package com.bitcamp.board;

public class App {
  public static void main(String[] args) {

    System.out.println("[게시판 애플리케이션]");
    System.out.println();
    System.out.println("환영합니다!");
    System.out.println();

    java.util.Scanner keyboardInput = new java.util.Scanner(System.in);

    final int SIZE = 3;

    int[] no = new int[SIZE];
    String[] title = new String[SIZE];
    String[] content = new String[SIZE];
    String[] writer = new String[SIZE];
    String[] password = new String[SIZE];
    int[] viewCount = new int[SIZE];
    long[] createdDate = new long[SIZE];

    int boardCount = 0; // 저장된 게시글의 개수

    while (true) {
      System.out.println("메뉴:");
      System.out.println("  1: 게시글 목록");
      System.out.println("  2: 게시글 상세보기");
      System.out.println("  3: 게시글 등록");
      System.out.println();
      System.out.print("메뉴를 선택하세요[1..3](0: 종료) ");
      
      int menuNo = keyboardInput.nextInt();
      keyboardInput.nextLine(); // 입력한 숫자 뒤에 남아 있는 줄바꿈 코드 제거

      
      if (menuNo == 0) {
        break;

      } else if (menuNo == 1) {
        System.out.println("[게시글 목록]");
        System.out.println("번호 제목 조회수 작성자 등록일");

        System.out.print(1);
        System.out.print("\t");
        System.out.print("제목입니다1");
        System.out.print('\t');
        System.out.print(20 + "\t");
        System.out.print("홍길동\t");
        System.out.print("2022-07-08\r\n");

        System.out.print(2 + "\t" + "제목입니다2\t" +
            11 + "\t" + "홍길동\t" + "2022-07-08\n");

        System.out.println(3 + "\t제목입니다3\t" +
            31 + "\t" + "임꺽정\t2022-07-08");

        System.out.printf("%d\t%s\t%d\t%s\t%s\n",
            4, "제목입니다4", 45, "유관순", "2022-07-08");

      } else if (menuNo == 2) {
        System.out.println("[게시글 상세보기]");

        System.out.print("조회할 게시글 번호? ");
        String input = keyboardInput.nextLine();
        int boardNo = Integer.parseInt(input);

        System.out.printf("번호: %d\n", no[boardNo]);
        System.out.printf("제목: %s\n", title[boardNo]);
        System.out.printf("내용: %s\n", content[boardNo]);
        System.out.printf("조회수: %d\n", viewCount[boardNo]);
        System.out.printf("작성자: %s\n", writer[boardNo]);
        java.util.Date date = new java.util.Date(createdDate[boardNo]);
        System.out.printf("등록일: %tY-%1$tm-%1$td %1$tH:%1$tM\n", date);
      
      } else if (menuNo == 3) {
        System.out.println("[게시글 등록]");

        System.out.print("제목? ");
        title[boardCount] = keyboardInput.nextLine();

        System.out.print("내용? ");
        content[boardCount] = keyboardInput.nextLine();

        System.out.print("작성자? "); 
        writer[boardCount] = keyboardInput.nextLine();

        System.out.print("암호? ");
        password[boardCount] = keyboardInput.nextLine();

        /*
        if (boardCount == 0) {
          no[boardCount] = 1;
        } else {
          no[boardCount] = no[boardCount - 1] + 1;
        }
        */
        no[boardCount] = boardCount == 0 ? 1 : no[boardCount - 1] + 1;

        viewCount[boardCount] = 0;
        createdDate[boardCount] = System.currentTimeMillis();
        
        boardCount++;

      } else {
        System.out.println("메뉴 번호가 옳지 않습니다!");
      }
      
      System.out.println(); // 메뉴를 처리한 후 빈 줄 출력
    } // while

    System.out.println("안녕히 가세요!");
    keyboardInput.close();
  }
}
