package globant.javabootcamp.finalproject.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * Data Class for Product Entity
 *
 */
@ApiModel(value = "Product entity", description = "Data class for products")
@Entity
@Table(name = "product")
public class Product {
	
	@ApiModelProperty(value = "Product's id", required = true)
	@Column(name = "id")
	@Id
	@GeneratedValue
	private Long id;
	

	@ApiModelProperty(value = "Product's name", required = true)
	@Column(name = "name")
	@NotNull
	private String name;

	@ApiModelProperty(value = "Product's description", required = true)
	@Column(name = "description")
	@NotNull
	private String description;
	
	@ApiModelProperty(value = "Product's price", required = true)
	@Column(name = "price")
	@NotNull
	private float price;
	
	@ApiModelProperty(value = "Product's stock quantity", required = true)
	@Column(name = "quantity")
	@NotNull
	private int quantity;
	
	@ApiModelProperty(value = "Product's category", required = true)
	@ManyToOne(optional = false)
	@JoinColumn(name = "category_id", referencedColumnName="id")
	@NotNull
	private Category category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
}
