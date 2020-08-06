package com.code4worldpeace.capstone3.Products.Controller;

import com.code4worldpeace.capstone3.Products.Model.Request.ProductRequest;
import com.code4worldpeace.capstone3.Products.Model.Response.ProductResponse;
import com.code4worldpeace.capstone3.Products.Services.ProductService;
import com.code4worldpeace.capstone3.Shared.Dto.ProductDto;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {

        if (productService == null) {
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

    @GetMapping
    public List<ProductResponse> getProducts() {

        List<ProductDto> productDtoList = productService.getProducts();

        List<ProductResponse> productResponseList = new ArrayList<ProductResponse>();

        for (ProductDto productDto : productDtoList) {
            ProductResponse productResponse = new ProductResponse();
            BeanUtils.copyProperties(productDto, productResponse);

            productResponseList.add(productResponse);
        }

        return productResponseList;
    }

    @PutMapping(path = "{name}")
    public ProductResponse updateProduct(@PathVariable String name, @RequestBody ProductRequest productRequestDetails) {

        ProductDto requestedUpdate = new ProductDto();
        BeanUtils.copyProperties(productRequestDetails, requestedUpdate);

        ProductDto updatedProduct = productService.updateProductByName(name, requestedUpdate);

        ProductResponse returnValue = new ProductResponse();
        BeanUtils.copyProperties(updatedProduct, returnValue);

        return returnValue;
    }
}
