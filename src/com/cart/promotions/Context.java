package com.cart.promotions;

import com.cart.model.ProductCart;

import java.util.ArrayList;
import java.util.List;

public class Context implements IPromotion{

  List<IPromotion> promotions = new ArrayList<>();
  
  @Override
  public int apply(List<ProductCart> cartList) {
    return 0;
  }
  
  public void add(IPromotion promotion) {
    promotions.add(promotion);
  }
  
  public void remove(IPromotion promotion) {
    promotions.remove(promotion);
  }
}
