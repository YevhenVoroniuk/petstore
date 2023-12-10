package com.chtrembl.petstore.pet.repo;

import com.chtrembl.petstore.pet.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Yevhen_Voroniuk
 */
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}
