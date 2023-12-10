package com.chtrembl.petstore.product.model;

import com.chtrembl.petstore.product.repo.CategoryRepository;
import com.chtrembl.petstore.product.repo.ProductRepository;
import com.chtrembl.petstore.product.repo.TagRepository;
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
	private List<Product> products = new ArrayList<>();

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private TagRepository tagRepository;

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Transactional
	@EventListener({ContextRefreshedEvent.class})
	public void saveDataToDb() {
		log.info("Saving preloaded categories to DB");
		var categories = products.stream().map(Product::getCategory).collect(Collectors.toSet());
		categoryRepository.saveAll(categories);

		log.info("Saving preloaded tags to DB");
		var tags = products.stream().flatMap(pet -> pet.getTags().stream()).collect(Collectors.toSet());
		tagRepository.saveAll(tags);

		log.info("Saving preloaded products to DB");
		productRepository.saveAll(products);

		log.info("Preloaded data saved to DB");
	}
}