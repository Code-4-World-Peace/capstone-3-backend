package com.code4worldpeace.capstone3.Products.Controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductControllerTest {
    @Test
    final void testNewControllerWithNullService() {
        boolean exceptionThrown = false;
        try {
            new ProductController(null);
        } catch (Exception e) {
            exceptionThrown = true;
        }
        Assertions.assertTrue(exceptionThrown, "ProductController constructor allowed null product service.");
    }

    // Ask mark about testing for product creation success/failure, whether it needs to be done or if it's already
    // tested enough in the spring framework?

}
