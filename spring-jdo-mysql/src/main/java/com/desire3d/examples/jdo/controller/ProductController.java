/**
 * 
 */
package com.desire3d.examples.jdo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desire3d.examples.jdo.model.Product;
import com.desire3d.examples.jdo.repository.ProductRepository;

/**
 * @author mahesh
 *
 */
@RestController
@RequestMapping(value = "/Product")
public class ProductController {

	@Autowired
	private ProductRepository repository;

	@PostMapping("/save")
	public Product save(@RequestBody Product product) {
		return repository.save(product);
	}

	@PostMapping("/update")
	public Product update(@RequestBody Product product) {
		return repository.update(product);
	}

	@GetMapping("/findAll")
	public List<Product> findAll() {
		return repository.findAll();
	}

	@GetMapping("/findById/{id}")
	public Product findById(@PathVariable Long id) {
		return repository.findById(id);
	}

	@GetMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		repository.delete(id);
	}
}
