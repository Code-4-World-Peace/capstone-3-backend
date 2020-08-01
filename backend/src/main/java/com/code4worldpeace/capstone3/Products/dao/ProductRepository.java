package com.code4worldpeace.capstone3.Products.dao;

import org.springframework.stereotype.Repository;

import com.code4worldpeace.capstone3.Products.Model.Product;

import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

	Product findByName(String name);
}
