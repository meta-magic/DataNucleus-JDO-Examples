/**
 * 
 */
package com.desire3d.examples.jdo.repository;

import com.desire3d.examples.jdo.model.ShoppingCart;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author mahesh
 *
 */
public interface ShoppingCartRepository {

	public Mono<ShoppingCart> save(ShoppingCart shoppingCart);

	public Mono<ShoppingCart> update(ShoppingCart shoppingCart);

	public void delete(String cartId);

	public Flux<ShoppingCart> findAll();

	public Mono<ShoppingCart> findById(String cartId);

	public void removeItem(Long cartItemId);

	public Flux<ShoppingCart> findByCustomerId(String customerId);
}