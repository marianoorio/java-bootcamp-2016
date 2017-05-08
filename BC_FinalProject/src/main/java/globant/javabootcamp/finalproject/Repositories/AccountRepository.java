package globant.javabootcamp.finalproject.Repositories;

import globant.javabootcamp.finalproject.Entities.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * 
 * Repository for Account's entities
 * Using JpaRepository for operations
 *
 */
@Repository
public interface AccountRepository extends JpaRepository<Account,Long>{

	public Account findByUsername(String username);
}
