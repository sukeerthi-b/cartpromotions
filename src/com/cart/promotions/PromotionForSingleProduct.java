package com.cart.promotions;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.cart.model.ProductCart;

public class PromotionForSingleProduct implements IPromotion{

  private String code;
  private int discountPrice;
  private int items;
  public PromotionForSingleProduct(String code, int items, int discountPrice) {
    this.code = code;
    this.items = items;
    this.discountPrice = discountPrice;
  }

  public int apply(List<ProductCart> cartList) {
    return 0;
  }
}
