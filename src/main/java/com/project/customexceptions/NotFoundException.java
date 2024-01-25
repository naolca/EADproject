package com.project.customexceptions;

public class NotFoundException extends Exception {
  public NotFoundException(String message) {
    super(message);
  }
}
