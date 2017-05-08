package globant.javabootcamp.finalproject.Services;

import java.util.List;

import globant.javabootcamp.finalproject.Entities.Category;
import globant.javabootcamp.finalproject.Exceptions.AlreadyExistsException;
import globant.javabootcamp.finalproject.Exceptions.NotFoundException;

/**
 * 
 * Interface for Category's Services
 * Provides CRUD Operations 
 * 
 */
public interface CategoryService {

	/**
	 *  Creates a new category in the system.
	 *  
	 * @param account 
	 * The category to be created.
	 * @throws AlreadyExistsException
	 * If the code alreadyExists.
	 */
	public void create(Category category)throws AlreadyExistsException;
	
	/**
	 * Obtains an existent category by its identifier field.
	 * 
	 * @param id
	 * The category's identifier field for request the user to get
	 * @return
	 * The category requested if it exists.
	 * @throws NotFoundException
	 * If the category is not found.
	 */
	public Category read(Long id) throws NotFoundException;

	/**
	 * Updates an existent category.
	 * Usually it is a category obtained previously with some fields modified.
	 * 
	 * @param category
	 * The category to be updated.
	 * @throws NotFoundException
	 * If the category is not found.
	 */
	public void update(Category category) throws NotFoundException;
	
	/**
	 * Deletes an existent category by its identifier field.
	 * 
	 * @param id
	 * The category's identifier field for request the delete of it.
	 * @throws NotFoundException
	 * If the category is not found.
	 */
	public void delete(Long id) throws NotFoundException;

	/**
	 * Obtains the category with the code requested.
	 * 
	 * @param code
	 * The code of category which are want to get.
	 * @return
	 * The category that have the code requested.
	 * @throws NotFoundException
	 * If no one category have the code requested.
	 */
	public Category findByCode(String code) throws NotFoundException;
	
	/**
	 * Obtains a list of all persisted categories.
	 * 
	 * @return 
	 * The list of all categories on system.
	 */
	public List<Category> findAll();
	
	/**
	 * Obtains the number of existent categories.
	 * 
	 * @return
	 * The size of the categories container.
	 */
	public long size();
	
	/**
	 * Deletes all persisted categories.
	 */
	public void deleteAll();
}
