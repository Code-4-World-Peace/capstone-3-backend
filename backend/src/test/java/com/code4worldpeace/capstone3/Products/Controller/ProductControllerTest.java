package com.code4worldpeace.capstone3.Products.Controller;

import com.code4worldpeace.capstone3.Products.Model.Request.ProductRequest;
import com.code4worldpeace.capstone3.Products.Model.Response.ProductResponse;
import com.code4worldpeace.capstone3.Products.Services.ProductService;
import com.code4worldpeace.capstone3.Shared.Dto.ProductDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ProductControllerTest {
    @Test
    public void testNewControllerWithNullService() {
        boolean exceptionThrown = false;
        try {
            new ProductController(null);
        } catch (Exception e) {
            exceptionThrown = true;
        }
        Assertions.assertTrue(exceptionThrown, "ProductController constructor allowed null product service.");
    }

    @Test
    public void testCreateProduct() {
        ProductService service = Mockito.mock(ProductService.class);
        when(service.createProduct(any(ProductDto.class))).thenReturn(new ProductDto());

        ProductRequest request = new ProductRequest();

        ProductResponse expected = new ProductResponse();
        ProductResponse actual = new ProductController(service).createProduct(request);
        Assertions.assertEquals(expected, actual);
    }

    // Ask mark about testing for product creation success/failure, whether it needs to be done or if it's already
    // tested enough in the spring framework?

}
