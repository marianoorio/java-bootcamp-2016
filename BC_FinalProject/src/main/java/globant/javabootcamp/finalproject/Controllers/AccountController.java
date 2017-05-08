package globant.javabootcamp.finalproject.Controllers;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import globant.javabootcamp.finalproject.Entities.Account;

/**
 * 
 * Interface of the account's controller
 *
 */
public interface AccountController {
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Account accountRequest);
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Account userRequest);
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long accountId);
	
	@RequestMapping(value= "/{userId}",method = RequestMethod.GET)
	public ResponseEntity<Account> read(@PathVariable Long userId);
	
	@RequestMapping(value= "/byUsername/{username}", method = RequestMethod.GET)
	public ResponseEntity<Account> findByUsername(@PathVariable String username);
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Account>> findAll();
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public ResponseEntity<Void> login(@RequestBody Account account);
	
	@RequestMapping(value = "/logout/{username}",method = RequestMethod.GET)
	public ResponseEntity<Void> logout(@PathVariable String username);
}
