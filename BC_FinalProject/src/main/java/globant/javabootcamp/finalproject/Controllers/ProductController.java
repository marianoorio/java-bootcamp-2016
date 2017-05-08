package globant.javabootcamp.finalproject.Controllers;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import globant.javabootcamp.finalproject.Entities.Product;

public interface ProductController {
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Product productRequest);
	
	@RequestMapping(value = "/{productId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long productId);
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Product productRequest);
	
	@RequestMapping(value= "/{productId}",method = RequestMethod.GET)
	public ResponseEntity<Product> read(@PathVariable Long productId);
	
	@RequestMapping(value= "/byName/{name}", method = RequestMethod.GET)
	public ResponseEntity<Product> findByName(@PathVariable String name);
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Product>> findAll();
	
	@RequestMapping(value = "/byCategory/{categoryId}", method = RequestMethod.GET)
	public ResponseEntity<Collection<Product>> findByCategory(@PathVariable Long categoryId);
}
