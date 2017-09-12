/**
 * 
 */
package com.desire3d.examples.jdo.repository.impl;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.springframework.stereotype.Repository;

import com.desire3d.examples.jdo.PMFConfig;
import com.desire3d.examples.jdo.model.Product;
import com.desire3d.examples.jdo.repository.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author mahesh
 */

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Override
	public Mono<Product> save(Product product) {
		PersistenceManager pm = PMFConfig.getPersistenceManagerFactory().getPersistenceManager();
		return Mono.just(pm.makePersistent(product));
	}

	@Override
	public Mono<Product> update(Product product) {
		PersistenceManager pm = PMFConfig.getPersistenceManagerFactory().getPersistenceManager();
		Product oldProduct = pm.getObjectById(Product.class, product.getProductId());
		if (product.getCategory() != null)
			oldProduct.setCategory(product.getCategory());
		if (product.getName() != null)
			oldProduct.setName(product.getName());
		if (product.getDescription() != null)
			oldProduct.setDescription(product.getDescription());
		if (product.getPrice() != null)
			oldProduct.setPrice(product.getPrice());
		return Mono.just(pm.makePersistent(oldProduct));
	}

	@Override
	public void delete(Long productId) {
		PersistenceManager pm = PMFConfig.getPersistenceManagerFactory().getPersistenceManager();
		Product product = pm.getObjectById(Product.class, productId);
		pm.deletePersistent(product);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Flux<Product> findAll() {
		PersistenceManager pm = PMFConfig.getPersistenceManagerFactory().getPersistenceManager();
		Query query = pm.newQuery(Product.class);
		return Flux.fromIterable((List<Product>) query.execute());
	}

	@Override
	public Mono<Product> findById(Long productId) {
		PersistenceManager pm = PMFConfig.getPersistenceManagerFactory().getPersistenceManager();
		Product product = pm.getObjectById(Product.class, productId);
		return Mono.justOrEmpty(product);
	}
}
