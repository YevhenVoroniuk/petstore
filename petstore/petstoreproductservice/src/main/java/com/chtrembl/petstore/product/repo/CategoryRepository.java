package com.chtrembl.petstore.product.repo;

import com.chtrembl.petstore.product.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Yevhen_Voroniuk
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
