package com.code4worldpeace.capstone3.Products.Services;

import java.util.*;

import com.code4worldpeace.capstone3.Shared.Dto.ProductDto;

public interface ProductService {

	ProductDto createProduct(ProductDto productDto);

	List<ProductDto> getProducts();

	ProductDto updateProductByName(String name, ProductDto requestedUpdate);

}
