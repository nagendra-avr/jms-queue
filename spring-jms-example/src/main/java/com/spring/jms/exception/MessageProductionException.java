package com.spring.jms.exception;

public class MessageProductionException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public MessageProductionException(String message, Throwable cause) {
    super(message, cause);
  }
}
