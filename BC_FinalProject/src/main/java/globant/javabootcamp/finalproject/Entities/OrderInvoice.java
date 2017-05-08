package globant.javabootcamp.finalproject.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * Data Class for OrderInvoice Entity
 *
 */
@ApiModel(value = "OrderInvoice entity", description = "Data class for invoice of purcharses")
@Entity
public class OrderInvoice {

	@ApiModelProperty(value = "OrderInvoice's id", required = true)
	@Column(name = "id")
	@Id
	@GeneratedValue
	private Long id;
	
	@ApiModelProperty(value = "Id of account of invoice's owner", required = true)
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;
	
	@ApiModelProperty(value = "List of products on the invoice", required = true)
	@OneToMany(mappedBy = "id", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<OrderProduct> products;
	
	@ApiModelProperty(value = "Total of the orderInvoice", required = true)
	@Column(name = "total")
	@NotNull
	private float total;

	public OrderInvoice(){
		
	}
	
	public OrderInvoice(Account account, List<CartProduct> cartProducts){
		this.account = account;
		List<OrderProduct> productsToAdd = new ArrayList<>();
		float totalCart = 0;
		for(CartProduct cartProduct: cartProducts){
			totalCart += cartProduct.getProduct().getPrice() * cartProduct.getQuantity();
			OrderProduct orderProduct = new OrderProduct();
			orderProduct.setProduct_id(cartProduct.getProduct().getId());
			orderProduct.setQuantity(cartProduct.getQuantity());
			orderProduct.setOrderInvoice(this);
			productsToAdd.add(0, orderProduct);
		}
		this.products = productsToAdd;
		this.total = totalCart;
	}
	
	/*public void generate(List<CartProduct> cartProducts){
		products = new ArrayList<>();
		float totalCart = 0;
		for(CartProduct cartProduct: cartProducts){
			totalCart += cartProduct.getProduct().getPrice() * cartProduct.getQuantity();
			OrderProduct orderProduct = new OrderProduct();
			orderProduct.setProduct_id(cartProduct.getProduct().getId());
			orderProduct.setQuantity(cartProduct.getQuantity());
			orderProduct.setOrderInvoice(this);
			products.add(0, orderProduct);
		}
		this.total = totalCart;
	}*/
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<OrderProduct> getProducts() {
		return products;
	}

	public void setProducts(List<OrderProduct> products) {
		this.products = products;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
	
}
