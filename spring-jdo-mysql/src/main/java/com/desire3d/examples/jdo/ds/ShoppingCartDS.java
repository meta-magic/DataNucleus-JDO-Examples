/**
 * 
 */
package com.desire3d.examples.jdo.ds;

import org.springframework.stereotype.Component;

import com.desire3d.examples.jdo.model.CartItem;
import com.desire3d.examples.jdo.model.ShoppingCart;
import com.desire3d.examples.jdo.repository.ShoppingCartRepository;
import com.desire3d.examples.jdo.util.SessionSimulator;

import reactor.core.publisher.Mono;

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

	public Mono<ShoppingCart> addItem(CartItem item) {
		String customerId = SessionSimulator.getLoggedInCustomer();
		Iterable<ShoppingCart> shoppingCarts = repository.findByCustomerId(customerId).toIterable();
		ShoppingCart shoppingCart;

		if (shoppingCarts.iterator().hasNext()) {
			shoppingCart = new ShoppingCart();
			shoppingCart.setCustomerId(customerId);
			shoppingCart.addItem(item);
		} else {
			shoppingCart = shoppingCarts.iterator().next();
			shoppingCart.addItem(item);
		}
		return repository.update(shoppingCart);
	}
}