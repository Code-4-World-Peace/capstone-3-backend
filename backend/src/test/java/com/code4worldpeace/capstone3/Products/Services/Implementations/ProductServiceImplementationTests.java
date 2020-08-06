package com.code4worldpeace.capstone3.Products.Services.Implementations;


import com.code4worldpeace.capstone3.Products.dao.ProductRepository;
import com.code4worldpeace.capstone3.Shared.Dto.ProductDto;
import com.code4worldpeace.capstone3.Shared.Utils.SkuGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ProductServiceImplementationTests {
    @Test
    public void testCreateProduct_emptyRequest() {
        ProductDto productDto = new ProductDto();
        ProductRepository repository = Mockito.mock(ProductRepository.class);
        SkuGenerator skuGenerator = new SkuGenerator();
        boolean expected = true;
        boolean actual = false;
        try {
            new ProductServiceImplementation(repository, skuGenerator).createProduct(productDto);
        } catch (NullPointerException e) {
            actual = e.getMessage().equals("Name cannot be null");
        }
        Assertions.assertEquals(expected, actual);
    }
}
