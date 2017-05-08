package globant.javabootcamp.finalproject.Services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import globant.javabootcamp.finalproject.Entities.Category;
import globant.javabootcamp.finalproject.Entities.Product;
import globant.javabootcamp.finalproject.Exceptions.AlreadyExistsException;
import globant.javabootcamp.finalproject.Exceptions.InvalidCategoryException;
import globant.javabootcamp.finalproject.Exceptions.NotFoundException;
import globant.javabootcamp.finalproject.Repositories.CategoryRepository;
import globant.javabootcamp.finalproject.Repositories.ProductRepository;

@Service
public class ProductServiceBean implements ProductService{

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void create(Product product) throws AlreadyExistsException, InvalidCategoryException {
		Product productPersisted = productRepository.findOne(product.getId());
		if(productPersisted != null){
			logger.info(product.getId() + " failed to save. Already Exists.");
			throw new AlreadyExistsException();
		}
		Category categoryPersisted = categoryRepository.findOne(product.getCategory().getId());
		if(categoryPersisted == null){
			logger.info(product.getId() + " failed to save. Invalid category.");
			throw new InvalidCategoryException();
		}
		productRepository.save(product);
		logger.info(product.getId() + " saved successfull.");	
	}

	@Override
	public Product read(Long id) throws NotFoundException {
		Product productPersisted = productRepository.findOne(id);
		if(productPersisted == null){
			logger.info("productId: " + id + " failed to read. Not Exists.");
			throw new NotFoundException();
		}
		logger.info("productId: " + id + " was read successfull.");
		return productPersisted;
	}

	@Override
	public void update(Product product) throws NotFoundException, InvalidCategoryException {
		Product productPersisted = productRepository.findOne(product.getId());
		if(productPersisted == null){
			logger.info("productId: " + product.getId() + " failed to update. Not Exists.");
			throw new NotFoundException();
		}
		Category categoryPersisted = categoryRepository.findOne(product.getCategory().getId());
		if(categoryPersisted == null){
			logger.info(product.getId() + " failed to upload. Invalid category.");
			throw new InvalidCategoryException();
		}
		productRepository.save(product);
		logger.info("productId: " + product.getId() + " updated successfull.");
	}

	@Override
	public void delete(Long id) throws NotFoundException {
		Product productPersisted = productRepository.findOne(id);
		if(productPersisted == null){
			logger.info("productId: " + id + " failed to delete. Not Exists.");
			throw new NotFoundException();
		}
		productRepository.delete(id);
		logger.info("productId: " + id + " deleted successfull.");
		
	}

	@Override
	public Product findByName(String name) throws NotFoundException {
		Product productPersisted = productRepository.findByName(name);
		if(productPersisted == null){
			logger.info("product: " + name + " failed to read. Not Exists.");
			throw new NotFoundException();
		}
		logger.info("productname: " + name + " was read successfull.");
		return productPersisted;
	}

	@Override
	public List<Product> findAll() {
		List<Product> allProducts = new ArrayList<>();
		productRepository.findAll().forEach(allProducts::add);
		return allProducts;
	}

	@Override
	public List<Product> findByCategory(Long categoryId){
		List<Product> products = new ArrayList<>();
		productRepository.findByCategoryId(categoryId).forEach(products::add);
		return products;
	}
	
	@Override
	public long size() {
		return productRepository.count();
	}

	@Override
	public void deleteAll() {
		productRepository.deleteAll();
	}
}
