package globant.javabootcamp.finalproject.Services;

import java.util.List;

import globant.javabootcamp.finalproject.Entities.Product;
import globant.javabootcamp.finalproject.Exceptions.AlreadyExistsException;
import globant.javabootcamp.finalproject.Exceptions.InvalidCategoryException;
import globant.javabootcamp.finalproject.Exceptions.NotFoundException;

/**
 * 
 * Interface for Product's Services
 * Provides CRUD Operations 
 * 
 */
public interface ProductService {

	/**
	 * Creates a new Product into the system.
	 * 
	 * @param product
	 * The product to be created.
	 * @throws AlreadyExistsException
	 * If the product's id already exists.
	 * @throws InvalidCategoryException
	 * If the product's category is invalid.
	 */
	public void create(Product product)throws AlreadyExistsException, InvalidCategoryException;
	
	/**
	 * Obtains an existent product by its identifier field.
	 * 
	 * @param id
	 * The product's identifier field for request the user to get
	 * @return
	 * The product requested if it exists.
	 * @throws NotFoundException
	 * If the product is not found.
	 */
	public Product read(Long id) throws NotFoundException;

	/**
	 * Updates an existent product.
	 * Usually it is a product obtained previously with some fields modified.
	 * 
	 * @param product
	 * The product to be updated.
	 * @throws NotFoundException
	 * If the product is not found.
	 */
	public void update(Product product) throws NotFoundException, InvalidCategoryException;
	
	/**
	 * Deletes an existent product by its identifier field.
	 * 
	 * @param id
	 * The product's identifier field for request the delete of it.
	 * @throws NotFoundException
	 * If the product is not found.
	 */
	public void delete(Long id) throws NotFoundException;

	/**
	 * Obtains the product with the name requested.
	 * 
	 * @param name
	 * The name of product which are want to get.
	 * @return
	 * The first product that have the name requested.
	 * @throws NotFoundException
	 * If no one product have the name requested.
	 */
	public Product findByName(String name) throws NotFoundException;
	
	/**
	 * Obtains a list of products with the category requested.
	 * 
	 * @param name
	 * The category which are want to get.
	 * @return
	 * The list of products that shares the category requested.
	 * @throws NotFoundException
	 * If no one product have the category requested.
	 */
	public List<Product> findByCategory(Long categoryId);	
	
	/**
	 * Obtains a list of all persisted products.
	 * 
	 * @return
	 * The list of all items in the system.
	 */
	public List<Product> findAll();
	
	/**
	 * Obtains the number of existent products.
	 * 
	 * @return
	 * The size of the products container.
	 */
	public long size();
	
	/**
	 * Deletes all persisted products.
	 */
	public void deleteAll();
}
