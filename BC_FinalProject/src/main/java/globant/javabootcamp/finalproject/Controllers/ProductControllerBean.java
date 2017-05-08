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

import globant.javabootcamp.finalproject.Entities.Category;
import globant.javabootcamp.finalproject.Entities.Product;
import globant.javabootcamp.finalproject.Exceptions.AlreadyExistsException;
import globant.javabootcamp.finalproject.Exceptions.InvalidCategoryException;
import globant.javabootcamp.finalproject.Exceptions.NotFoundException;
import globant.javabootcamp.finalproject.Services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/products")
@Api(value="Products")
public class ProductControllerBean implements ProductController{
	
	@Autowired
	private ProductService productService;
	
	@Override
	@ApiOperation(value = "create", notes="add a new product",nickname = "createNewProduct")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok"),
	        @ApiResponse(code = 204, message = "No Content",
	            response = void.class),
	        @ApiResponse(code = 400, message = "Bad Request",
            response = void.class)})
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@ApiParam(value = "new product's attributes", required = true)@RequestBody Product productRequest){
		ResponseEntity<Void> response;
		try{
			productService.create(productRequest);
			response  = new ResponseEntity<>(HttpStatus.OK);
		}
		catch(AlreadyExistsException e){
			response  = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(InvalidCategoryException e){
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	@Override
	@ApiOperation(value = "delete", notes="deletes an existent product",nickname = "deleteProduct")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok"),
	        @ApiResponse(code = 204, message = "No Content",
	            response = void.class) })
	@RequestMapping(value = "/{productId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@ApiParam(value = "product's id", required = true)@PathVariable Long productId){
		ResponseEntity<Void> response;
		try{
			productService.delete(productId);
			response  = new ResponseEntity<>(HttpStatus.OK);
		}
		catch(NotFoundException e){
			response  = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@Override
	@ApiOperation(value = "update", notes="updates an existent product",nickname = "updateProduct")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok"),
	        @ApiResponse(code = 204, message = "No Content",
	            response = void.class),
	        @ApiResponse(code = 400, message = "Bad Request",
            response = void.class)})
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@ApiParam(value = "updated product's attributes", required = true)@RequestBody Product productRequest){
		ResponseEntity<Void> response;
		try{
			productService.update(productRequest);
			response  = new ResponseEntity<>(HttpStatus.OK);
		}
		catch(NotFoundException e){
			response  = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch(InvalidCategoryException e){
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	@Override
	@ApiOperation(value = "read", notes="returns a product by its Id",nickname = "readById")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok", response = Category.class),
	        @ApiResponse(code = 204, message = "No Content") })
	@RequestMapping(value= "/{productId}",method = RequestMethod.GET)
	public ResponseEntity<Product> read(@ApiParam(value = "product's id", required = true)@PathVariable Long productId){
		ResponseEntity<Product> response;
		try{
			Product product = productService.read(productId);
			response  = new ResponseEntity<Product>(product,HttpStatus.OK);
		}
		catch(NotFoundException e){
			response  = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@Override
	@ApiOperation(value = "read", notes="returns a product by its name",nickname = "readByName")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok", response = Category.class),
	        @ApiResponse(code = 204, message = "No Content") })
	@RequestMapping(value= "/byName/{name}", method = RequestMethod.GET)
	public ResponseEntity<Product> findByName(@ApiParam(value = "product's name", required = true)@PathVariable String name){
		ResponseEntity<Product> response;
		try{
			Product product = productService.findByName(name);
			response  = new ResponseEntity<>(product,HttpStatus.OK);
		}
		catch(NotFoundException e){
			response  = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@Override
	@ApiOperation(value = "findAll", notes="returns all products",nickname = "findAllProducts")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok")})
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Product>> findAll(){
		ResponseEntity<Collection<Product>> response = null;
		Collection<Product> products = productService.findAll();
		response = new ResponseEntity<>(products, HttpStatus.OK);
		return response;
	}
	
	@Override
	@ApiOperation(value = "findByCategory", notes="returns all products from a category given",nickname = "findProductsByCategory")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok")})
	@RequestMapping(value = "/byCategory/{categoryId}", method = RequestMethod.GET)
	public ResponseEntity<Collection<Product>> findByCategory(@ApiParam(value = "category's id", required = true)@PathVariable Long categoryId){
		ResponseEntity<Collection<Product>> response = null;
		Collection<Product> products = productService.findByCategory(categoryId);
		response = new ResponseEntity<>(products, HttpStatus.OK);
		return response;
	}
}
