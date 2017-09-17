package com.bookshop.helpTests;

import java.util.NoSuchElementException;

public class IncorrectSymbol extends IllegalArgumentException{
  public IncorrectSymbol(String message){
    super(message);
  }
}
