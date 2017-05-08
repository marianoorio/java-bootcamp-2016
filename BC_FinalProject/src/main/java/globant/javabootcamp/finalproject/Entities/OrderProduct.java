package globant.javabootcamp.finalproject.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * Data Class for OrderProduct Entity
 *
 */
@ApiModel(value = "OrderProduct entity", description = "Data class for products in invoices")
@Entity
public class OrderProduct {

	@ApiModelProperty(value = "OrderProduct's id", required = true)
	@Column(name = "id")
	@Id
	@GeneratedValue
	private Long id;
	
	@ApiModelProperty(value = "Id of product on the OrderInvoice", required = true)
	@Column(name = "product_id")
	@NotNull
	private Long productId;
	
	@ApiModelProperty(value = "Quantity of the product on the OrderInvoice", required = true)
	@Column(name = "quantity")
	@NotNull
	private int quantity;

	@ApiModelProperty(value = "OrderInvoice assosiated at OrderProduct", required = true)
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_invoice_id")
	@JsonBackReference
	private OrderInvoice orderInvoice;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProduct_id() {
		return productId;
	}

	public void setProduct_id(Long productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public OrderInvoice getOrderInvoice() {
		return orderInvoice;
	}

	public void setOrderInvoice(OrderInvoice orderInvoice) {
		this.orderInvoice = orderInvoice;
	}	
}
