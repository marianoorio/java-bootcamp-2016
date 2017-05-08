package globant.javabootcamp.finalproject.Controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import globant.javabootcamp.finalproject.Entities.CartProduct;
import globant.javabootcamp.finalproject.Entities.OrderInvoice;
import globant.javabootcamp.finalproject.Exceptions.AlreadyExistsException;
import globant.javabootcamp.finalproject.Exceptions.NotFoundException;
import globant.javabootcamp.finalproject.Services.LoginService;
import globant.javabootcamp.finalproject.Services.ShoppingCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/{accountId}/Cart")
@Api(value="ShoppingCart")
public class ShoppingCartControllerBean implements ShoppingCartController{
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Autowired
	private LoginService loginService;
	
	@Override
	@ApiOperation(value = "create", notes="add a new account's cartProduct",nickname = "createNewCartProduct")
	@ApiResponses(value = {
			@ApiResponse(code = 401, message = "Unauthorized",
				response = void.class),
			@ApiResponse(code = 200, message = "Ok"),
	        @ApiResponse(code = 204, message = "No Content",
	            response = void.class),
	        @ApiResponse(code = 400, message = "Bad Request",
            response = void.class)})
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@ApiParam(value = "account's id", required = true)@PathVariable Long accountId,
									   @ApiParam(value = "new cartProduct's attributes", required = true)@RequestBody CartProduct cartProductRequest){
		ResponseEntity<Void> response;
		if(!accountId.equals(cartProductRequest.getAccount().getId()) || !loginService.isLogged(accountId)){
			response = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}else{
			try{
				shoppingCartService.create(cartProductRequest);
				response  = new ResponseEntity<>(HttpStatus.OK);
			}
			catch(AlreadyExistsException e){
				response  = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			catch(NotFoundException e){
				response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}
		return response;
	}
	
	@Override
	@ApiOperation(value = "read", notes="gets an existent account",nickname = "readAccount")
	@ApiResponses(value = {
			@ApiResponse(code = 401, message = "Unauthorized",
				response = void.class),
			@ApiResponse(code = 200, message = "Ok", response = CartProduct.class),
	        @ApiResponse(code = 204, message = "No Content") })
	@RequestMapping(value= "/{cartProductId}",method = RequestMethod.GET)
	public ResponseEntity<CartProduct> read(@ApiParam(value = "account's id", required = true)@PathVariable Long accountId,
											@ApiParam(value = "cartProduct's id", required = true)@PathVariable Long cartProductId){
		ResponseEntity<CartProduct> response;
		if(!loginService.isLogged(accountId)){
			response = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}else{
			try{
				CartProduct cartProduct = shoppingCartService.read(cartProductId);
				response  = new ResponseEntity<>(cartProduct, HttpStatus.OK);
			}
			catch(NotFoundException e){
				response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}
		return response;
	}
	
	@Override
	@ApiOperation(value = "update", notes="updates an existent cartProduct",nickname = "updateCartProduct")
	@ApiResponses(value = {
			@ApiResponse(code = 401, message = "Unauthorized",
				response = void.class),
			@ApiResponse(code = 200, message = "Ok"),
	        @ApiResponse(code = 400, message = "Bad Request",
            response = void.class)})
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@ApiParam(value = "account's id", required = true)@PathVariable Long accountId, 
									   @ApiParam(value = "updated cartProduct's id", required = true)@RequestBody CartProduct cartProductRequest){
		ResponseEntity<Void> response;
		if(!accountId.equals(cartProductRequest.getAccount().getId())|| !loginService.isLogged(accountId)){
			response = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}else{
			try{
				if(cartProductRequest.getId() == null){
					response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				}else{
					shoppingCartService.update(cartProductRequest);
					response  = new ResponseEntity<>(HttpStatus.OK);
				}
			}
			catch(NotFoundException e){
				response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}
		return response;
	}
	
	@Override
	@ApiOperation(value = "delete", notes="deletes an existent cartProduct",nickname = "deleteCatProduct")
	@ApiResponses(value = {
			@ApiResponse(code = 401, message = "Unauthorized",
				response = void.class),
			@ApiResponse(code = 200, message = "Ok"),
	        @ApiResponse(code = 204, message = "No Content",
	            response = void.class) })
	@RequestMapping(value = "/{cartProductId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@ApiParam(value = "account's id", required = true)@PathVariable Long accountId, 
									   @ApiParam(value = "cartProduct's id", required = true)@PathVariable Long cartProductId){
		ResponseEntity<Void> response;
		if(!loginService.isLogged(accountId)){
		response = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}else{
			try{
				shoppingCartService.delete(cartProductId);
				response  = new ResponseEntity<>(HttpStatus.OK);
			}
			catch(NotFoundException e){
				response  = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		}
		return response;
	}
	
	@Override
	@ApiOperation(value = "findByAccountId", notes="returns all cartProducts of an account",nickname = "getAllCartProductsOfAccount")
	@ApiResponses(value = {
			@ApiResponse(code = 401, message = "Unauthorized",
					response = void.class),
				@ApiResponse(code = 200, message = "Ok"),
		        @ApiResponse(code = 204, message = "No Content",
		            response = void.class) })
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<CartProduct>> findByAccountId(@ApiParam(value = "account's id", required = true)@PathVariable Long accountId){
		ResponseEntity<Collection<CartProduct>> response = null;
		if(!loginService.isLogged(accountId)){
			response = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}else{
			Collection<CartProduct> cartProducts;
			try {
				cartProducts = shoppingCartService.findByAccountId(accountId);
				response = new ResponseEntity<>(cartProducts, HttpStatus.OK);
			}catch (NotFoundException e) {
				response  = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		}
		return response;
	}
	
	@Override
	@ApiOperation(value = "deleteAllByAccountId", notes="deletes all cartProducts of an account",nickname = "deleteAllCartProductsOfAccount")
	@ApiResponses(value = {
			@ApiResponse(code = 401, message = "Unauthorized",
					response = void.class),
				@ApiResponse(code = 200, message = "Ok"),
		        @ApiResponse(code = 204, message = "No Content",
		            response = void.class) })
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAllByAccountId(@ApiParam(value = "account's id", required = true)@PathVariable Long accountId){
		ResponseEntity<Void> response = null;
		if(!loginService.isLogged(accountId)){
			response = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}else{
			try {
				shoppingCartService.deleteAllByAccountId(accountId);;
				response = new ResponseEntity<>(HttpStatus.OK);
			}catch (NotFoundException e) {
				response  = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		}
		return response;
	}

	@Override
	@ApiOperation(value = "makeCheckout", notes="make a checkout of an account's cartProducts",nickname = "checkoutOfAccount")
	@ApiResponses(value = {
			@ApiResponse(code = 401, message = "Unauthorized",
					response = void.class),
				@ApiResponse(code = 200, message = "Ok"),
		        @ApiResponse(code = 204, message = "No Content",
		            response = void.class) })
	@RequestMapping(value = "/checkout",method = RequestMethod.POST)
	public ResponseEntity<Void> makeCheckout(@ApiParam(value = "account's id", required = true)@PathVariable Long accountId) {
		ResponseEntity<Void> response = null;
		if(!loginService.isLogged(accountId)){
			response = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}else{
			try {
				shoppingCartService.checkOut(accountId);
				response = new ResponseEntity<>(HttpStatus.OK);
			}catch (NotFoundException e) {
				response  = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		}
		return response;
	}
	
	@Override
	@ApiOperation(value = "findAllCheckout", notes="returns all checkout of an account",nickname = "getCheckoutsOfAccount")
	@ApiResponses(value = {
			@ApiResponse(code = 401, message = "Unauthorized",
					response = void.class),
				@ApiResponse(code = 200, message = "Ok"),
		        @ApiResponse(code = 204, message = "No Content",
		            response = void.class) })
	@RequestMapping(value = "/checkout",method = RequestMethod.GET)
	public ResponseEntity<Collection<OrderInvoice>> findAllCheckouts(@ApiParam(value = "account's id", required = true)@PathVariable Long accountId) {
		ResponseEntity<Collection<OrderInvoice>> response = null;
		if(!loginService.isLogged(accountId)){
			response = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}else{
			Collection<OrderInvoice> orderInvoices;
			try {
				orderInvoices = shoppingCartService.findAllOrderInvoiceByAccountId(accountId);
				response = new ResponseEntity<>(orderInvoices, HttpStatus.OK);
			}catch (NotFoundException e) {
				response  = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		}
		return response;
	}
}
