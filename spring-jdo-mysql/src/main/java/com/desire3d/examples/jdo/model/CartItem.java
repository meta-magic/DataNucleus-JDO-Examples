/**
 * 
 */
package com.desire3d.examples.jdo.model;

import java.io.Serializable;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Mahesh Pardeshi
 *
 */
@PersistenceCapable(table = "cart_item")
public class CartItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7178402473309473944L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private Long cartItemId;

	private Long productId;

	private Integer quantity;

	@JsonIgnore
	@Column(name = "cartId")
	private ShoppingCart shoppingCart;

	public CartItem() {
		super();
	}

	public CartItem(Long productId, Integer quantity, Double price) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}

	public Long getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(Long cartItemId) {
		this.cartItemId = cartItemId;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}