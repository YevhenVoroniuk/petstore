package com.chtrembl.petstore.product.service;

import com.chtrembl.petstore.product.model.Product;
import com.chtrembl.petstore.product.repo.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yevhen_Voroniuk
 */
@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  @Transactional(readOnly = true)
  public List<Product> getProducts() {
    return productRepository.findAll();
  }
}
