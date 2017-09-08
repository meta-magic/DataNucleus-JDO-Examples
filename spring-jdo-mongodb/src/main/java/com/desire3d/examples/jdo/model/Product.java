/**
 * 
 */
package com.desire3d.examples.jdo.model;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * @author mahesh
 *
 */
@PersistenceCapable(table = "product")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3448933197977350009L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private Long productId;

	@Persistent
	private String category;

	@Persistent
	private String name;

	@Persistent
	private String description;

	@Persistent
	private Double price;

	public Product() {
		super();
	}

	public Product(Long productId, String category, String name, String description, Double price) {
		super();
		this.productId = productId;
		this.category = category;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}