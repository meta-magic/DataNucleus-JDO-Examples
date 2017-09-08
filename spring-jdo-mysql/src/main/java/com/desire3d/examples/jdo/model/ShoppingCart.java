/**
 * 
 */
package com.desire3d.examples.jdo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Unique;

/**
 * @author Mahesh Pardeshi
 *
 */
@PersistenceCapable(table = "shopping_cart")
public class ShoppingCart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3898880301582195848L;

	@PrimaryKey
	@Persistent(customValueStrategy = "uuid")
	private String cartId;

	@Unique
	private String customerId;

	@Persistent(mappedBy = "shoppingCart")
	private List<CartItem> items;

	public ShoppingCart() {
		super();
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	public List<CartItem> addItem(CartItem item) {
		if (items == null) {
			items = new ArrayList<CartItem>();
		}
		item.setShoppingCart(this);
		items.add(item);
		return items;
	}
}