package globant.javabootcamp.finalproject.Controllers;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import globant.javabootcamp.finalproject.Entities.CartProduct;
import globant.javabootcamp.finalproject.Entities.OrderInvoice;

public interface ShoppingCartController {
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@PathVariable Long accountId, @RequestBody CartProduct cartProductRequest);
	
	@RequestMapping(value= "/{cartProductId}",method = RequestMethod.GET)
	public ResponseEntity<CartProduct> read(@PathVariable Long accountId,@PathVariable Long cartProductId);
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable Long accountId, @RequestBody CartProduct cartProductRequest);
	
	@RequestMapping(value = "/{cartProductId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long accountId, @PathVariable Long cartProductId);
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<CartProduct>> findByAccountId(@PathVariable Long accountId);
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAllByAccountId(@PathVariable Long accountId);
	
	@RequestMapping(value = "/checkout",method = RequestMethod.POST)
	public ResponseEntity<Void> makeCheckout(@PathVariable Long accountId);
	
	@RequestMapping(value = "/checkout",method = RequestMethod.GET)
	public ResponseEntity<Collection<OrderInvoice>> findAllCheckouts(@PathVariable Long accountId);

}
