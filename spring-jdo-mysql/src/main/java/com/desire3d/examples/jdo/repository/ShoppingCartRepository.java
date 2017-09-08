/**
 * 
 */
package com.desire3d.examples.jdo.repository;

import java.util.List;

import com.desire3d.examples.jdo.model.ShoppingCart;

/**
 * @author mahesh
 *
 */
public interface ShoppingCartRepository {

	public ShoppingCart save(ShoppingCart shoppingCart);

	public ShoppingCart update(ShoppingCart shoppingCart);

	public void delete(String cartId);

	public List<ShoppingCart> findAll();

	public ShoppingCart findById(String cartId);

	public void removeItem(Long cartItemId);

	public List<ShoppingCart> findByCustomerId(String customerId);

}