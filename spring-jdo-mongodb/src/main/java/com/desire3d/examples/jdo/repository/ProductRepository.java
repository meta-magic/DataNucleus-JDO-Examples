/**
 * 
 */
package com.desire3d.examples.jdo.repository;

import java.util.List;

import com.desire3d.examples.jdo.model.Product;

/**
 * @author mahesh
 *
 */
public interface ProductRepository {

	public Product save(Product product);

	public Product update(Product product);

	public void delete(Long productId);

	public List<Product> findAll();

	public Product findById(Long productId);
}
