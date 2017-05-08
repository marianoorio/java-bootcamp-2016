package globant.javabootcamp.finalproject.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import globant.javabootcamp.finalproject.Entities.OrderInvoice;

/**
 * 
 * Repository for OrderInvoice's entities
 * Using JpaRepository for operations
 *
 */
@Repository
public interface OrderInvoiceRepository extends JpaRepository<OrderInvoice, Long>{

	public List<OrderInvoice> findByAccountId(Long accountId);
}
