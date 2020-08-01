package com.code4worldpeace.capstone3.Products.Controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.code4worldpeace.capstone3.Products.Model.Product;
import com.code4worldpeace.capstone3.Products.Model.Response.ProductResponse;
import com.code4worldpeace.capstone3.Products.Services.ProductService;
import com.code4worldpeace.capstone3.Shared.Dto.ProductDto;
import com.code4worldpeace.capstone3.Products.dao.ProductRepository;

class ProductControllerTest {

	class TestProductService implements ProductService {

		@Override
		public ProductDto createProduct(ProductDto productDto) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	@Test
	final void test_CreateProductControllerSuccess() {
		
		final TestProductService productService = new TestProductService();
		
		ProductController actual = new ProductController(productService);
		
		assertTrue(actual != null);

	}
	
	@Test
	final void test_CreateProductControllerFail() {
		
		try {
			ProductController actual = new ProductController(null);
		} catch(Exception e) {
			return;
		}

		fail("ProductController constructor allowed null product service.");
	}

//	@Test
//	final void test_CreateProductSuccess() {
//		
//		final TestProductService productService = new TestProductService();

//		ProductDto testProduct = new ProductDto();
//		
//		ProductDto createdProduct = productService.createProduct(testProduct);

//	}

	// Ask mark about testing for product creation success/failure, whether it needs to be done or if it's already
	// tested enough in the spring framework?
	
}
