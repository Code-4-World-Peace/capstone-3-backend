package com.code4worldpeace.capstone3.Products.Services.Implementations;

import com.code4worldpeace.capstone3.Exceptions.ProductAlreadyExistsException;
import com.code4worldpeace.capstone3.Products.Model.Product;
import com.code4worldpeace.capstone3.Products.Services.ProductService;
import com.code4worldpeace.capstone3.Products.dao.ProductRepository;
import com.code4worldpeace.capstone3.Shared.Dto.ProductDto;
import com.code4worldpeace.capstone3.Shared.Utils.SkuGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductServiceImplementation implements ProductService {

    private final ProductRepository productRepository;
    private final SkuGenerator skuGenerator;

    ProductServiceImplementation(ProductRepository productRepository, SkuGenerator skuGenerator) {
        this.productRepository = productRepository;
        this.skuGenerator = skuGenerator;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        if (productRepository.findByName(productDto.getName()) != null) {
            throw new ProductAlreadyExistsException("Product is already in inventory");
        }
        String name = productDto.getName();
        if (name == null || name.isBlank()) {
            throw new NullPointerException("Name cannot be null or empty");
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        product.setSku(skuGenerator.generateSku(20));
        ProductDto returnValue = new ProductDto();
        Product storedProductDetails = productRepository.save(product);
        BeanUtils.copyProperties(storedProductDetails, returnValue);
        return returnValue;
    }

    @Override
    public List<ProductDto> getProducts() {


        List<Product> productList = (List<Product>) productRepository.findAll();

        List<ProductDto> productDtoList = new ArrayList<ProductDto>();

        for (Product product : productList) {

            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);

            productDtoList.add(productDto);
        }

        return productDtoList;
    }

    @Override
    public ProductDto updateProductByName(String name, ProductDto requestedUpdate) {

        Product updateProduct = new Product();
        BeanUtils.copyProperties(requestedUpdate, updateProduct);

        Product oldProductData = productRepository.findByName(name);

        ProductDto returnValue = new ProductDto();

        // If requested name is already in use, error out and dont allow the update
        if (productRepository.findByName(requestedUpdate.getName()) != null && !requestedUpdate.getName().equals(name))
            throw new ProductAlreadyExistsException("Unable to perform update. Product already exists with that name.");

        if (requestedUpdate.getStock() <= 0)
            throw new IllegalArgumentException("Invalid quantity: " + requestedUpdate.getStock());

        if (oldProductData == null) {

            //throw new UserNotFoundException("Product Not Found");
            throw new ProductAlreadyExistsException("Unable to perform update. Product with name: " + name + " not found.");
        } else {

            updateProduct.setId(oldProductData.getId());
            updateProduct.setSku(oldProductData.getSku());

            Product updatedProductDetails = productRepository.save(updateProduct);


            BeanUtils.copyProperties(updatedProductDetails, returnValue);

            return returnValue;
        }
    }
}
