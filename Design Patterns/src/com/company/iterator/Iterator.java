package com.company.iterator;

public interface Iterator {
  boolean hasNext();
  Product current();
  void next();
}
