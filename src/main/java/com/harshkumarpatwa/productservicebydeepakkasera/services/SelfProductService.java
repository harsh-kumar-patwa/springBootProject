package com.harshkumarpatwa.productservicebydeepakkasera.services;

import com.harshkumarpatwa.productservicebydeepakkasera.models.Category;
import com.harshkumarpatwa.productservicebydeepakkasera.models.Product;
import com.harshkumarpatwa.productservicebydeepakkasera.respositories.CategoryRepository;
import com.harshkumarpatwa.productservicebydeepakkasera.respositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@Primary
public class SelfProductService implements ProductServices {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product[] getAllProducts() {

        return new Product[0];
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new RuntimeException("Product not found");
        }
        return optionalProduct.get();
    }
    public Product createProduct(Product product) {
        Category category = product.getCategory();
        Category savedCategory = null;
        if(category.getId()==null){
            savedCategory  = categoryRepository.save(category);
            product.setCategory(savedCategory);
        }
        return productRepository.save(product);
    }
}
