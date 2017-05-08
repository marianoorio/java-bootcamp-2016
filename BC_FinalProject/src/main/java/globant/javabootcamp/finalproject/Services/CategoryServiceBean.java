package globant.javabootcamp.finalproject.Services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import globant.javabootcamp.finalproject.Entities.Category;
import globant.javabootcamp.finalproject.Exceptions.AlreadyExistsException;
import globant.javabootcamp.finalproject.Exceptions.NotFoundException;
import globant.javabootcamp.finalproject.Repositories.CategoryRepository;

@Service
public class CategoryServiceBean implements CategoryService{

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void create(Category category) throws AlreadyExistsException {
		Category categoryPersisted = categoryRepository.findByCode(category.getCode());
		if(categoryPersisted != null){
			logger.info(category.getCode() + " failed to save. Already Exists.");
			throw new AlreadyExistsException();
		}
		categoryRepository.save(category);
		logger.info(category.getCode() + " saved successfull.");	
	}

	@Override
	public Category read(Long id) throws NotFoundException {
		Category categoryPersisted = categoryRepository.findOne(id);
		if(categoryPersisted == null){
			logger.info("categoryId: " + id + " failed to read. Not Exists.");
			throw new NotFoundException();
		}
		logger.info("categoryId: " + id + " was read successfull.");
		return categoryPersisted;
	}

	@Override
	public void update(Category category) throws NotFoundException {
		Category categoryPersisted = categoryRepository.findOne(category.getId());
		if(categoryPersisted == null){
			logger.info("categoryId: " + category.getId() + " failed to update. Not Exists.");
			throw new NotFoundException();
		}
		categoryRepository.save(category);
		logger.info("categoryId: " + category.getId() + " updated successfull.");
	}

	@Override
	public void delete(Long id) throws NotFoundException {
		Category categoryPersisted = categoryRepository.findOne(id);
		if(categoryPersisted == null){
			logger.info("categoryId: " + id + " deleted to update. Not Exists.");
			throw new NotFoundException();
		}
		categoryRepository.delete(id);
		logger.info("categoryId: " + id + " deleted successfull.");
		
	}

	@Override
	public Category findByCode(String code) throws NotFoundException {
		Category categoryPersisted = categoryRepository.findByCode(code);
		if(categoryPersisted == null){
			logger.info("category: " + code + " failed to read. Not Exists.");
			throw new NotFoundException();
		}
		logger.info("category: " + code + " was read successfull.");
		return categoryPersisted;
	}

	@Override
	public List<Category> findAll() {
		List<Category> allCategories = new ArrayList<>();
		categoryRepository.findAll().forEach(allCategories::add);
		return allCategories;
	}

	@Override
	public long size() {
		return categoryRepository.count();
	}

	@Override
	public void deleteAll() {
		categoryRepository.deleteAll();
	}

}
