package com.harshkumarpatwa.productservicebydeepakkasera.services;

import com.harshkumarpatwa.productservicebydeepakkasera.dto.FakeStoreProductDTO;
import com.harshkumarpatwa.productservicebydeepakkasera.exceptions.ProductNotFoundException;
import com.harshkumarpatwa.productservicebydeepakkasera.models.Category;
import com.harshkumarpatwa.productservicebydeepakkasera.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreServices implements ProductServices {
    RestTemplate restTemplate = new RestTemplate();
    public Product getProductById(Long id){
        FakeStoreProductDTO productDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/"+id,
                FakeStoreProductDTO.class
        );
//        int x = 1/0;
        if(productDto == null){
            throw new ProductNotFoundException(id,"Product not found");
        }
        return convertDtoToProduct(productDto);

    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    public Product[] getAllProducts(){
        FakeStoreProductDTO[] productDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDTO[].class
        );
        Product[] products = new Product[productDto.length];
        int i =0;
        for(FakeStoreProductDTO productDtos : productDto){
            products[i++]=convertDtoToProduct(productDtos);
        }
        return products;
    }
    private Product convertDtoToProduct(FakeStoreProductDTO productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setDescription(productDto.getDescription());
        product.setImage(productDto.getImage());
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());
        Category category = new Category()  ;
        category.setTitle(product.getTitle());
        product.setCategory(category);

        return product;
    }
}
