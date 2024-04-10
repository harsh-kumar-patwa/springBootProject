package com.harshkumarpatwa.productservicebydeepakkasera.controllers;

import com.harshkumarpatwa.productservicebydeepakkasera.dto.ExceptionDto;
import com.harshkumarpatwa.productservicebydeepakkasera.models.Product;
import com.harshkumarpatwa.productservicebydeepakkasera.services.ProductServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    private ProductServices productServices;
    public ProductController(ProductServices productServices){
        this.productServices=productServices;
    }
    @GetMapping("/products")
    public Product[] getAllProducts(){
        return productServices.getAllProducts();
    }
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id")Long id){
//        ResponseEntity<Product> responseEntity = null;
//        ResponseEntity<ExceptionDto> exceptionDtoResponseEntity = null;
//        Product product = null;
//        try{
//            product = productServices.getProductById(id);
//            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
//            return responseEntity;
//        }
//        catch(RuntimeException runtimeException){
//            ExceptionDto exceptionDto = new ExceptionDto();
//            exceptionDto.setMessage("Product not found");
//            exceptionDtoResponseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
//            return exceptionDtoResponseEntity;
//        }
        return productServices.getProductById(id);
    }
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productServices.createProduct(product);
    }
}
