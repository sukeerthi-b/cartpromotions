package com.cart.promotions;

import java.util.List;

import com.cart.model.ProductCart;

public interface IPromotion {
  
  int apply(List<ProductCart> cartList);
}
