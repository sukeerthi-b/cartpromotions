package com.cart.promotions;

import com.cart.model.ProductCart;

import java.util.List;

public class NoPromotionProduct implements IPromotion{

  @Override
  public int apply(List<ProductCart> cartList) {
    return 0;
  }
}
