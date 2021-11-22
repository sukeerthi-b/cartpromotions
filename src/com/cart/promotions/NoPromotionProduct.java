package com.cart.promotions;

import com.cart.model.ProductCart;

import java.util.List;

public class NoPromotionProduct implements IPromotion{

  @Override
  public int apply(List<ProductCart> cartList) {
    if(cartList == null) {
      return 0;
    }
    return  cartList.stream()
        .reduce(0, (partialvalue, cart) -> partialvalue + cart.getProduct().getPrice() * cart.getCount(), Integer::sum);
  }
}
