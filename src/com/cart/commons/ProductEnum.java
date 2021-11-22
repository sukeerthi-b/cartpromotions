package com.cart.commons;

public enum ProductEnum {
  PRODUCT_A("A", 50), PRODUCT_B("B", 30), PRODUCT_C("C", 20), PRODUCT_D("D", 15);
  private final String code;
  private final Integer price;

  ProductEnum(String code, Integer price) {
      this.code = code;
      this.price = price;
  }

  public String getCode() {
    return code;
  }

  public Integer getPrice() {
    return price;
  }
}