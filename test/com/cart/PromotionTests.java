package com.cart;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import static com.cart.commons.ProductEnum.PRODUCT_A;
import static com.cart.commons.ProductEnum.PRODUCT_B;
import static com.cart.commons.ProductEnum.PRODUCT_C;
import static com.cart.commons.ProductEnum.PRODUCT_D;

import com.cart.model.Product;
import com.cart.model.ProductCart;
import com.cart.promotions.Context;
import com.cart.promotions.PromotionForMultiProduct;
import com.cart.promotions.PromotionForSingleProduct;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PromotionTests {
    private Context context = new Context();
    @Before
    public void setUp() throws Exception {
        context.add(new PromotionForSingleProduct(PRODUCT_A.getCode(), 3, 130));
        context.add(new PromotionForSingleProduct(PRODUCT_B.getCode(), 2, 45));
        context.add(new PromotionForMultiProduct(PRODUCT_C.getCode(), PRODUCT_D.getCode(), 30));
    }

    @After
    public void tearDown() throws Exception {}

    /**
     * scenarioA
     * 1-A
     * 1-B
     * 1-C
     *
     * result 100
     */
    @Test
    public void scenarioA() {
        //Given
        List<ProductCart> result = mockScenarioA();
        //When
        int totalPrice = context.apply(result);
        //Then
        assertTrue(totalPrice == 100);
    }

    private List<ProductCart> mockScenarioA() {
        List<ProductCart> result = new ArrayList<>();
        result.add(new ProductCart(new Product(PRODUCT_A.getCode(), PRODUCT_A.getPrice()), 1));
        result.add(new ProductCart(new Product(PRODUCT_B.getCode(), PRODUCT_B.getPrice()), 1));
        result.add(new ProductCart(new Product(PRODUCT_C.getCode(), PRODUCT_C.getPrice()), 1));
        return result;
    }
    /**
     * scenarioB
     * 5-A
     * 5-B
     * 1-C
     *
     * result 370
     */
    @Test
    public void scenarioB() {
        fail("Not yet implemented");
    }

    /**
     * scenarioC
     * 3-A
     * 5-B
     * 1-C
     * 1-D
     * result 280
     */
    @Test
    public void scenarioC() {
        fail("Not yet implemented");
    }
}
