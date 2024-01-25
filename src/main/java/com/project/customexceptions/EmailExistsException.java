package com.project.customexceptions;

public class EmailExistsException extends Exception {
  public EmailExistsException(String message) {
    super(message);
  }
}
