package com.cart.promotions;

import java.util.List;
import java.util.stream.Collectors;

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

    List<ProductCart> list = cartList.stream().filter(cart -> this.code.equals(cart.getProduct().getCode())).collect(Collectors.toList());
    if (list.size() == 1 && list.get(0).getCount() >= items) {
      ProductCart discountCart = list.get(0);
      int discountedProductPrice = ((discountCart.getCount() / items) * this.discountPrice)
              + (discountCart.getCount() % items * discountCart.getProduct().getPrice());
      cartList.remove(list.get(0));
      return discountedProductPrice;
    }
    return 0;
  }

}
