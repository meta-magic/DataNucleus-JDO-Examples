/**
 * 
 */
package com.desire3d.examples.jdo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desire3d.examples.jdo.ds.ShoppingCartDS;
import com.desire3d.examples.jdo.model.CartItem;
import com.desire3d.examples.jdo.model.ShoppingCart;
import com.desire3d.examples.jdo.repository.ShoppingCartRepository;

/**
 * @author mahesh
 *
 */
@RestController
@RequestMapping(value = "/ShoppingCart")
public class ShoppingCartController {

	private final ShoppingCartDS service;
	private final ShoppingCartRepository repository;

	public ShoppingCartController(ShoppingCartDS service, ShoppingCartRepository repository) {
		super();
		this.service = service;
		this.repository = repository;
	}

	@PostMapping("/addItem")
	public ShoppingCart addItem(@RequestBody CartItem item) {
		return service.addItem(item);
	}

	@PostMapping("/save")
	public ShoppingCart save(@RequestBody ShoppingCart shoppingCart) {
		return repository.save(shoppingCart);
	}

	@PostMapping("/update")
	public ShoppingCart update(@RequestBody ShoppingCart shoppingCart) {
		return repository.update(shoppingCart);
	}

	@GetMapping("/findAll")
	public List<ShoppingCart> findAll() {
		return repository.findAll();
	}

	@GetMapping("/findById/{id}")
	public ShoppingCart findById(@PathVariable String id) {
		return repository.findById(id);
	}

	@GetMapping("/findByCustomerId/{customerId}")
	public List<ShoppingCart> findByCustomerId(@PathVariable String customerId) {
		return repository.findByCustomerId(customerId);
	}

	@DeleteMapping("/removeItem/{cartItemId}")
	public void removeItem(@PathVariable Long cartItemId) {
		repository.removeItem(cartItemId);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable String id) {
		repository.delete(id);
	}
}