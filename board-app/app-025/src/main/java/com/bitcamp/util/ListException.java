package com.bitcamp.util;

public class ListException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ListException() {
    super();
  }

  public ListException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public ListException(String message, Throwable cause) {
    super(message, cause);
  }

  public ListException(String message) {
    super(message);
  }

  public ListException(Throwable cause) {
    super(cause);
  }
}
