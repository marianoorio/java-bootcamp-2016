package globant.javabootcamp.finalproject.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import globant.javabootcamp.finalproject.Entities.CartProduct;

/**
 * 
 * Repository for CartProduct's entities
 * Using JpaRepository for operations
 *
 */
@Repository
public interface CartProductRepository extends JpaRepository<CartProduct, Long>{
	
	public List<CartProduct> findByAccountId(Long accountId);
	
	public CartProduct findByAccountIdAndProductId(Long accountId, Long productId);
}
