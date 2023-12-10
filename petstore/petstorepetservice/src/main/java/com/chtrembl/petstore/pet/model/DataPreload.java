package com.chtrembl.petstore.pet.model;

import com.chtrembl.petstore.pet.repo.CategoryRepository;
import com.chtrembl.petstore.pet.repo.PetRepository;
import com.chtrembl.petstore.pet.repo.TagRepository;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("data")
public class DataPreload {
	private List<Pet> pets = new ArrayList<>();

	@Autowired
	private PetRepository petRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private TagRepository tagRepository;

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	@Transactional
	@EventListener({ContextRefreshedEvent.class})
	public void saveDataToDb() {
		log.info("Saving preloaded categories to DB");
		var categories = pets.stream().map(Pet::getCategory).collect(Collectors.toSet());
		categoryRepository.saveAll(categories);

		log.info("Saving preloaded tags to DB");
		var tags = pets.stream().flatMap(pet -> pet.getTags().stream()).collect(Collectors.toSet());
		tagRepository.saveAll(tags);

		log.info("Saving preloaded pets to DB");
		petRepository.saveAll(pets);

		log.info("Preloaded data saved to DB");
	}
}