package com.bitcamp;

import java.util.ArrayList;
import java.util.Scanner;

public class Selector {
  public static void main(String[] args) {

    String[] names = {
        "조주연","김라윤","최지연","이헌식","조영아","안치운",
        "장현경","박병민","유제동","김봉경","최종찬","장슬기",
        "김원태","유성민","문채원","유종현","박지민","신우섭",
        "주  영","황의찬","임은지","임동현","김민구",
        "박진우","임가온","김연정","최유민","윤주현"
    };

    ArrayList<String> list = new ArrayList<>();

    for (String name : names) {
      list.add(name);
    }

    for (int i = 0; i < 100; i++) {
      int i1 = (int)(Math.random() * list.size());
      int i2 = (int)(Math.random() * list.size());

      String temp = list.get(i1);
      list.set(i1, list.get(i2));
      list.set(i2, temp);
    }

    Scanner keyboardInput = new Scanner(System.in);

    System.out.println("준비!!!");
    keyboardInput.nextLine();

    while (list.size() > 0) {
      int no = (int)(Math.random() * list.size());
      System.out.println("===> " + list.remove(no));
      keyboardInput.nextLine();
    }

    keyboardInput.close();
  }
}

//   ------------  칠 판  --------------->    문    <-----
//      1       2       3             4       5       6
//1:[김라윤][조영아][안치운]      [이헌식][최지연][김봉경]
//2:[장슬기][임동현][최종찬]      [박병민][유성민][장현경]
//3:[박지민][조주연][유종현]      [문채원][김원태][유제동]
//4:[임은지][황의찬][주  영]      [김민구][      ][신우섭]
//5:[윤주현][최유민][김연정]      [임가온][      ][박진우]


