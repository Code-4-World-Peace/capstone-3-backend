package com.code4worldpeace.capstone3.Products.Controller;

import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.code4worldpeace.capstone3.Products.Model.Request.ProductRequest;
import com.code4worldpeace.capstone3.Products.Model.Response.ProductResponse;
import com.code4worldpeace.capstone3.Products.Services.ProductService;
import com.code4worldpeace.capstone3.Shared.Dto.ProductDto;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "products")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {

		if(productService == null) {
			throw new IllegalArgumentException("Product Service cannot be null.");
		}
		
		this.productService = productService;
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
	)	
	public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
		
		ProductDto productDto = new ProductDto();
		BeanUtils.copyProperties(productRequest, productDto);
		
		ProductDto createdProduct = productService.createProduct(productDto);
		
		ProductResponse returnValue = new ProductResponse();
		BeanUtils.copyProperties(createdProduct, returnValue);
		
		return returnValue;
	}
}
