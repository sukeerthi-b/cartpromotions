package com.cart.promotions;

import com.cart.model.ProductCart;

import java.util.List;
import java.util.stream.Collectors;

public class PromotionForMultiProduct implements IPromotion{

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
    List<ProductCart> discountCart = cartList.stream()
        .filter(cart -> this.productCode1.equals(cart.getProduct().getCode()) || this.productCode2.equals(cart.getProduct().getCode())).collect(Collectors.toList());
    int discuountProductsPrice = 0;
    if (discountCart.size() == 2) {
      ProductCart productCart1 = discountCart.get(0);
      ProductCart productCart2 = discountCart.get(1);
      int productCount1 = productCart1.getCount();
      int productCount2 = productCart2.getCount();
      if (productCount1 == productCount2) {
        discuountProductsPrice = productCount2 * this.discoutPrice;
      } else if (productCount1 < productCount2) {
        discuountProductsPrice = (productCount1 * this.discoutPrice) + ((productCount2 - productCount1) * productCart2.getProduct().getPrice());
      } else {
        discuountProductsPrice = (productCount2 * this.discoutPrice) + ((productCount1 - productCount2) * productCart1.getProduct().getPrice());
      }
      cartList.removeAll(discountCart);
      return discuountProductsPrice;
    }
    return 0;
  }

}
