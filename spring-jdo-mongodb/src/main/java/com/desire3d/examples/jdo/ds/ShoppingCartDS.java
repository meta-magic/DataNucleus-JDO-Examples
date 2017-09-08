/**
 * 
 */
package com.desire3d.examples.jdo.ds;

import java.util.List;

import org.springframework.stereotype.Component;

import com.desire3d.examples.jdo.model.CartItem;
import com.desire3d.examples.jdo.model.ShoppingCart;
import com.desire3d.examples.jdo.repository.ShoppingCartRepository;
import com.desire3d.examples.jdo.util.SessionSimulator;

/**
 * @author mahesh
 *
 */
@Component
public final class ShoppingCartDS {
	
	private final ShoppingCartRepository repository;

	public ShoppingCartDS(ShoppingCartRepository repository) {
		super();
		this.repository = repository;
	}
	
	public ShoppingCart addItem(CartItem item) {
		String customerId = SessionSimulator.getLoggedInCustomer();
		List<ShoppingCart> shoppingCartList = repository.findByCustomerId(customerId);
		ShoppingCart shoppingCart;
		if (shoppingCartList.isEmpty()) {
			shoppingCart = new ShoppingCart();
			shoppingCart.setCustomerId(customerId);
			shoppingCart.addItem(item);
		} else {
			shoppingCart = shoppingCartList.get(0);
			shoppingCart.addItem(item);
		}
		return repository.update(shoppingCart);
	}
}