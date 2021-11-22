package com.cart.promotions;

import com.cart.model.ProductCart;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PromotionForMultiProduct implements IPromotion {

  private String productCode1;
  private String productCode2;
  private int discoutPrice;

  public PromotionForMultiProduct(String productCode1, String productCode2, int discountPrice) {
    this.productCode1 = productCode1;
    this.productCode2 = productCode2;
    this.discoutPrice = discountPrice;
  }

  @Override
  public int apply(List<ProductCart> cartList) {
    return 0;
  }
}
