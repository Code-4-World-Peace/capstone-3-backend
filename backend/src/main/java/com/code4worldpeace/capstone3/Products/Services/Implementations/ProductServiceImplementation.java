package com.code4worldpeace.capstone3.Products.Services.Implementations;

import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.code4worldpeace.capstone3.Exceptions.*;
import com.code4worldpeace.capstone3.Products.Model.Product;
import com.code4worldpeace.capstone3.Products.Services.ProductService;
import com.code4worldpeace.capstone3.Products.dao.ProductRepository;
import com.code4worldpeace.capstone3.Shared.Dto.ProductDto;
import com.code4worldpeace.capstone3.Shared.Utils.SkuGenerator;


@Service
public class ProductServiceImplementation implements ProductService {

	private final ProductRepository productRepository;
	private final SkuGenerator skuGenerator;
	
	public ProductServiceImplementation(ProductRepository productRepository, SkuGenerator skuGenerator) {
		this.productRepository = productRepository;
		this.skuGenerator = skuGenerator;
	}

	@Override
	public ProductDto createProduct(ProductDto productDto) {

		if(productRepository.findByName(productDto.getName()) != null) {
			
			throw new ProductAlreadyExistsException("Product is already in inventory");
		}
		else {
			
			Product product = new Product();
			BeanUtils.copyProperties(productDto, product);
			
			product.setSku(skuGenerator.generateSku(20));
			
			ProductDto returnValue = new ProductDto();
			
			Product storedProductDetails = productRepository.save(product);
			BeanUtils.copyProperties(storedProductDetails, returnValue);
			
			return returnValue;
		}
		
	}
	
}
