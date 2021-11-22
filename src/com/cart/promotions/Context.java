package com.cart.promotions;

import com.cart.model.ProductCart;

import java.util.ArrayList;
import java.util.List;

public class Context implements IPromotion{

  List<IPromotion> promotions = new ArrayList<>();
  
  @Override
  public int apply(List<ProductCart> cartList) {
    //default calculation has to be applied after promotions apply
    promotions.add(new NoPromotionProduct());
    List<ProductCart> list = new ArrayList<>(cartList);
    return promotions.stream().reduce(0, (partial, promotion) -> (partial + promotion.apply(list)), Integer::sum);
  }
  
  public void add(IPromotion promotion) {
    promotions.add(promotion);
  }
  
  public void remove(IPromotion promotion) {
    promotions.remove(promotion);
  }
}
