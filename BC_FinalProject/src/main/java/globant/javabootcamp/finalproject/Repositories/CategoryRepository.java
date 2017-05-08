package globant.javabootcamp.finalproject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import globant.javabootcamp.finalproject.Entities.Category;

/**
 * 
 * Repository for Category's entities
 * Using JpaRepository for operations
 *
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	public Category findByCode(String code);
}
