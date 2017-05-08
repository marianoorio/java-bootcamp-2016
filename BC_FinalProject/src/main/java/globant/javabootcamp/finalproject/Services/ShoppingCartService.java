package globant.javabootcamp.finalproject.Services;

import java.util.List;

import globant.javabootcamp.finalproject.Entities.CartProduct;
import globant.javabootcamp.finalproject.Entities.OrderInvoice;
import globant.javabootcamp.finalproject.Exceptions.AlreadyExistsException;
import globant.javabootcamp.finalproject.Exceptions.NotFoundException;

/**
 * 
 * Interface for ShoppingCart's Services
 * Provides CRUD Operations 
 * 
 */
public interface ShoppingCartService {
	
	/**
	 * Creates a new CartProduct into the system.
	 * 
	 * @param cartProduct
	 * The CartProduct to be created.
	 * @throws NotFoundException
	 * If not exists the account owner OR if not exists the product associated.
	 *@throws AlreadyExistsException
	 * If already exists a CartProduct with the same account owner and product associated.
	 */
	public void create(CartProduct cartProduct) throws NotFoundException, AlreadyExistsException;
	
	/**
	 * Obtains an existent category by its identifier field.
	 * 
	 * @param id
	 * The cartProduct's identifier field for request the user to get
	 * @return
	 * The cartProduct requested if it exists.
	 * @throws NotFoundException
	 * If the cartProduct's is not found.
	 */
	public CartProduct read(Long id) throws NotFoundException;
	
	/**
	 * Updates an existent cartProduct.
	 * Usually it is a cartProduct obtained previously with some fields modified.
	 * 
	 * @param cartProduct
	 * The cartProduct to be updated.
	 * @throws NotFoundException
	 * If the cartProduct is not found.
	 */
	public void update(CartProduct cartProduct) throws NotFoundException;
	
	/**
	 * Deletes an existent cartProduct by its identifier field.
	 * 
	 * @param id
	 * The cartProduct's identifier field for request the delete of it.
	 * @throws NotFoundException
	 * If the cartProduct is not found.
	 */
	public void delete(Long id) throws NotFoundException;

	/**
	 * Obtains a list of cartProducts with the account owner requested.
	 * 
	 * @param accountId
	 * The accountId of cartProducts which are want to get.
	 * @return
	 * The list of cartProducts that shares the accountId requested.
	 * @throws NotFoundException
	 * If no one cartProduct have the accountId requested.
	 */
	public List<CartProduct> findByAccountId(Long accountId) throws NotFoundException;
	
	/**
	 * Deletes all cartProducts of an account.
	 * 
	 * @param accountId
	 * The accountId of cartProducts which are want to get.
	 * @throws NotFoundException
	 * If the account not exists OR if the account not have any cartProduct.
	 */
	public void deleteAllByAccountId(Long accountId) throws NotFoundException;
	
	/**
	 * Makes the checkout of the account's cartProducts
	 * 
	 * @param accountId
	 * The accountId of the account that want to make the checkout.
	 * @throws NotFoundException
	 * If the account not exists OR if the account not have any cartProducts.
	 */
	public void checkOut(Long accountId) throws NotFoundException;
	
	/**
	 * Obtains a list of purchase made of an account. 
	 * 
	 * @param accountId
	 * The accountId of the account that want to obtains the orderInvoices.
	 * @return
	 * The list of OrderInvoices from an account.
	 * @throws NotFoundException
	 * If the account not exists OR if the account not have any orderInvoice.
	 */
	public List<OrderInvoice> findAllOrderInvoiceByAccountId(Long accountId) throws NotFoundException;
}
