package globant.javabootcamp.finalproject.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * Data Class for CartProduct Entity
 *
 */
@ApiModel(value = "CartProduct entity", description = "Data class for products on account's cart")
@Entity
public class CartProduct {

	@ApiModelProperty(value = "CartProduct's id", required = true)
	@Column(name = "id")
	@Id
	@GeneratedValue
	private Long id;
	
	@ApiModelProperty(value = "Account owner", required = true)
	@ManyToOne(optional = false)
	@JoinColumn(name = "account_id", referencedColumnName="id")
	@NotNull
	private Account account;
	
	@ApiModelProperty(value = "Product assosiated", required = true)
	@ManyToOne(optional = false)
	@JoinColumn(name = "product_id", referencedColumnName="id")
	@NotNull
	private Product product;
	
	@ApiModelProperty(value = "Quantity of product assosiated", required = true)
	@Column(name = "quantity")
	@NotNull
	private int quantity;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
}
