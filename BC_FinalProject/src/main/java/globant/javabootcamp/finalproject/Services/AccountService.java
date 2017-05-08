package globant.javabootcamp.finalproject.Services;

import java.util.List;

import globant.javabootcamp.finalproject.Entities.Account;
import globant.javabootcamp.finalproject.Exceptions.AlreadyExistsException;
import globant.javabootcamp.finalproject.Exceptions.NotFoundException;

/**
 * 
 * Interface for User's Services
 * Provides CRUD Operations 
 * 
 */
public interface AccountService {
	
	/**
	 *  Creates a new account in the system.
	 *  
	 * @param account 
	 * The account to be created.
	 * @throws AlreadyExistsException
	 * If the username alreadyExists.
	 */
	public void create(Account account)throws AlreadyExistsException;
	
	/**
	 * Obtains an existent account by its identifier field.
	 * 
	 * @param id
	 * The account's identifier field for request the user to get
	 * @return
	 * The account requested if it exists.
	 * @throws NotFoundException
	 * If the account is not found.
	 */
	public Account read(Long id) throws NotFoundException;
	
	/**
	 * Updates an existent account.
	 * Usually it is an account obtained previously with some fields modified.
	 * 
	 * @param account
	 * The account to be updated.
	 * @throws NotFoundException
	 * If the account is not found.
	 */
	public void update(Account account) throws NotFoundException;
	
	/**
	 * Deletes an existent account by its identifier field.
	 * 
	 * @param accountId
	 * The account's identifier field for request the delete of it.
	 * @throws NotFoundException
	 * If the account is not found.
	 */
	public void delete(Long accountId) throws NotFoundException;
	
	/**
	 * Obtains a list of accounts that shares the name requested.
	 * 
	 * @param name
	 * The shared name by accounts which are want to get.
	 * @return
	 * The list of accounts that shares the name requested.
	 * @throws NotFoundException
	 * If no one account have the name requested.
	 */
	public Account findByUsername(String username) throws NotFoundException;
	
	/**
	 * Obtains a list of all persisted accounts.
	 * 
	 * @return 
	 * The list of all accounts on system.
	 */
	public List<Account> findAll();
	
	/**
	 * Obtains the number of existent accounts.
	 * 
	 * @return
	 * The size of the accounts container.
	 */
	public long size();
	
	/**
	 * Deletes all persisted accounts.
	 */
	public void deleteAll();
}
