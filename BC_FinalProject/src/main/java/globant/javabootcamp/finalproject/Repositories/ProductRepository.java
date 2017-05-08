package globant.javabootcamp.finalproject.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import globant.javabootcamp.finalproject.Entities.Product;

/**
 * 
 * Repository for Product's entities
 * Using JpaRepository for operations
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	public Product findByName(String name);
	public List<Product> findByCategoryId(Long categoryId);
}
