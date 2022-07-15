package com.bitcamp.board;

public class BoardTest {
  public static void main(String[] args) {
    Board[] arr = new Board[100];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = new Board();
    }
  }
}
