package com.harshkumarpatwa.productservicebydeepakkasera.services;

import com.harshkumarpatwa.productservicebydeepakkasera.models.Product;

public interface ProductServices {
    Product[] getAllProducts();
    Product getProductById(Long id);
    Product createProduct(Product product);
}
