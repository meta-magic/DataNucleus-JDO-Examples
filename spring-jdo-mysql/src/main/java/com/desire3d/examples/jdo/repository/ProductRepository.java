/**
 * 
 */
package com.desire3d.examples.jdo.repository;

import com.desire3d.examples.jdo.model.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author mahesh
 *
 */
public interface ProductRepository {

	public Mono<Product> save(Product product);

	public Mono<Product> update(Product product);

	public void delete(Long productId);

	public Flux<Product> findAll();

	public Mono<Product> findById(Long productId);
}
