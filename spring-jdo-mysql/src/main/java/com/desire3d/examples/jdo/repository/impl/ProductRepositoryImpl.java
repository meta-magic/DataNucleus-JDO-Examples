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

/**
 * @author mahesh
 */

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Override
	public Product save(Product product) {
		PersistenceManager pm = PMFConfig.getPersistenceManagerFactory().getPersistenceManager();
		return pm.makePersistent(product);
	}

	@Override
	public Product update(Product product) {
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
		return pm.makePersistent(oldProduct);
	}

	@Override
	public void delete(Long productId) {
		PersistenceManager pm = PMFConfig.getPersistenceManagerFactory().getPersistenceManager();
		Product product = pm.getObjectById(Product.class, productId);
		pm.deletePersistent(product);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAll() {
		PersistenceManager pm = PMFConfig.getPersistenceManagerFactory().getPersistenceManager();
		Query query = pm.newQuery(Product.class);
		return (List<Product>) query.execute();
	}

	@Override
	public Product findById(Long productId) {
		PersistenceManager pm = PMFConfig.getPersistenceManagerFactory().getPersistenceManager();
		Product product = pm.getObjectById(Product.class, productId);
		return product;
	}
}
