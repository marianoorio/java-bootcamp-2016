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
import globant.javabootcamp.finalproject.Exceptions.AlreadyExistsException;
import globant.javabootcamp.finalproject.Exceptions.NotFoundException;
import globant.javabootcamp.finalproject.Services.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/categories")
@Api(value="Categories")
public class CategoryControllerBean implements CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@Override
	@ApiOperation(value = "create", notes="add a new category",nickname = "createNewCategory")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok"),
	        @ApiResponse(code = 204, message = "No Content",
	            response = void.class) })
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@ApiParam(value = "new category's attributes", required = true)@RequestBody Category categoryRequest){
		ResponseEntity<Void> response;
		try{
			categoryService.create(categoryRequest);
			response  = new ResponseEntity<>(HttpStatus.OK);
		}
		catch(AlreadyExistsException e){
			response  = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@Override
	@ApiOperation(value = "delete", notes="deletes an existent category",nickname = "deleteCategory")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok"),
	        @ApiResponse(code = 204, message = "No Content",
	            response = void.class) })
	@RequestMapping(value = "/{categoryId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@ApiParam(value = "category's id", required = true)@PathVariable Long categoryId){
		ResponseEntity<Void> response;
		try{
			categoryService.delete(categoryId);
			response  = new ResponseEntity<>(HttpStatus.OK);
		}
		catch(NotFoundException e){
			response  = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@Override
	@ApiOperation(value = "update", notes="updates an existent category",nickname = "updateCategory")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok"),
	        @ApiResponse(code = 204, message = "No Content",
	            response = void.class) })
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@ApiParam(value = "updated category's attributes", required = true)@RequestBody Category categoryRequest){
		ResponseEntity<Void> response;
		try{
			categoryService.update(categoryRequest);
			response  = new ResponseEntity<>(HttpStatus.OK);
		}
		catch(NotFoundException e){
			response  = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@Override
	@ApiOperation(value = "read", notes="returns a category by its Id",nickname = "readById")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok", response = Category.class),
	        @ApiResponse(code = 204, message = "No Content") })
	@RequestMapping(value= "/{categoryId}",method = RequestMethod.GET)
	public ResponseEntity<Category> read(@ApiParam(value = "category's id", required = true)@PathVariable Long categoryId){
		ResponseEntity<Category> response;
		try{
			Category category = categoryService.read(categoryId);
			response  = new ResponseEntity<Category>(category,HttpStatus.OK);
		}
		catch(NotFoundException e){
			response  = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@Override
	@ApiOperation(value = "findByCode", notes="return a category by the code",nickname = "findCategoryByCode")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok", response = Category.class),
	        @ApiResponse(code = 204, message = "No Content") })
	@RequestMapping(value= "/byCode/{code}", method = RequestMethod.GET)
	public ResponseEntity<Category> findByCode(@ApiParam(value = "category's code", required = true)@PathVariable String code){
		ResponseEntity<Category> response;
		try{
			Category category = categoryService.findByCode(code);
			response  = new ResponseEntity<>(category,HttpStatus.OK);
		}
		catch(NotFoundException e){
			response  = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@Override
	@ApiOperation(value = "findAll", notes="returns all categories",nickname = "findAllCategories")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok")})
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Category>> findAll(){
		ResponseEntity<Collection<Category>> response = null;
		Collection<Category> categories = categoryService.findAll();
		response = new ResponseEntity<>(categories, HttpStatus.OK);
		return response;
	}
}
