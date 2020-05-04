package com.daiwei.learnandroidviews;

public final class User {
  private final String firstName;
  private final String lastName;

  User(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }
}
