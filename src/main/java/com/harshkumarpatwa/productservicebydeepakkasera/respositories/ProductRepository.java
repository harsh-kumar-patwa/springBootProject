package com.harshkumarpatwa.productservicebydeepakkasera.respositories;

import com.harshkumarpatwa.productservicebydeepakkasera.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Override
    Optional<Product> findById(Long id);
    @Override
    Product save(Product product);
}
