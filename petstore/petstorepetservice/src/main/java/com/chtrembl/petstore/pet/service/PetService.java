package com.chtrembl.petstore.pet.service;

import com.chtrembl.petstore.pet.model.Pet;
import com.chtrembl.petstore.pet.repo.PetRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yevhen_Voroniuk
 */
@Service
@RequiredArgsConstructor
public class PetService {

  private final PetRepository petRepository;

  @Transactional(readOnly = true)
  public List<Pet> getPets() {
    return petRepository.findAll();
  }
}
