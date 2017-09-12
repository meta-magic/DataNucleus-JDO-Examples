/**
 * 
 */
package com.desire3d.examples.jdo.repository.impl;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import org.springframework.stereotype.Repository;

import com.desire3d.examples.jdo.PMFConfig;
import com.desire3d.examples.jdo.model.CartItem;
import com.desire3d.examples.jdo.model.ShoppingCart;
import com.desire3d.examples.jdo.repository.ShoppingCartRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author mahesh
 *
 */
@Repository
public class ShoppingCartRepositoryImpl implements ShoppingCartRepository {

	private final PersistenceManagerFactory pmf = PMFConfig.getPersistenceManagerFactory();

	@Override
	public Mono<ShoppingCart> save(ShoppingCart shoppingCart) {
		return Mono.just(pmf.getPersistenceManager().makePersistent(shoppingCart));
	}

	@Override
	public Mono<ShoppingCart> update(ShoppingCart shoppingCart) {
		return Mono.just(pmf.getPersistenceManager().makePersistent(shoppingCart));
	}

	@Override
	public void delete(String cartId) {
		PersistenceManager pm = pmf.getPersistenceManager();
		ShoppingCart shoppingCart = (ShoppingCart) pm.getObjectById(ShoppingCart.class, cartId);
		pm.deletePersistent(shoppingCart);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Flux<ShoppingCart> findAll() {
		PersistenceManager pm = PMFConfig.getPersistenceManagerFactory().getPersistenceManager();
		Query query = pm.newQuery(ShoppingCart.class);
		return Flux.fromIterable((List<ShoppingCart>) query.execute());
	}

	@Override
	public Mono<ShoppingCart> findById(String cartId) {
		return Mono.justOrEmpty((ShoppingCart) pmf.getPersistenceManager().getObjectById(ShoppingCart.class, cartId));
	}

	@SuppressWarnings("unchecked")
	@Override
	public Flux<ShoppingCart> findByCustomerId(String customerId) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Query query = pm.newQuery(ShoppingCart.class);
		query.setFilter("this.customerId==:customerId");
		return Flux.fromIterable((List<ShoppingCart>) query.execute(customerId));
	}

	@Override
	public void removeItem(Long cartItemId) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.deletePersistent(pm.getObjectById(CartItem.class, cartItemId));
	}
}