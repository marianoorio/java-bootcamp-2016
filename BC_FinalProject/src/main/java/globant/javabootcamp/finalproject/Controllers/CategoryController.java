package globant.javabootcamp.finalproject.Controllers;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import globant.javabootcamp.finalproject.Entities.Category;

public interface CategoryController {
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Category categoryRequest);
	
	@RequestMapping(value = "/{categoryId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long categoryId);
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Category categoryRequest);
	
	@RequestMapping(value= "/{categoryId}",method = RequestMethod.GET)
	public ResponseEntity<Category> read(@PathVariable Long categoryId);
	
	@RequestMapping(value= "/byCode/{code}", method = RequestMethod.GET)
	public ResponseEntity<Category> findByCode(@PathVariable String code);
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Category>> findAll();
}
