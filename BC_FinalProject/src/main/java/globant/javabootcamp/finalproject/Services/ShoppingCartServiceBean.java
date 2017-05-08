package globant.javabootcamp.finalproject.Services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import globant.javabootcamp.finalproject.Entities.CartProduct;
import globant.javabootcamp.finalproject.Entities.OrderInvoice;
import globant.javabootcamp.finalproject.Exceptions.AlreadyExistsException;
import globant.javabootcamp.finalproject.Exceptions.NotFoundException;
import globant.javabootcamp.finalproject.Repositories.AccountRepository;
import globant.javabootcamp.finalproject.Repositories.CartProductRepository;
import globant.javabootcamp.finalproject.Repositories.OrderInvoiceRepository;
import globant.javabootcamp.finalproject.Repositories.ProductRepository;

@Service
public class ShoppingCartServiceBean implements ShoppingCartService{

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private CartProductRepository cartProductRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderInvoiceRepository orderInvoiceRepository;
	
	@Override
	public void create(CartProduct cartProduct) throws NotFoundException, AlreadyExistsException{
		Long accountId = cartProduct.getAccount().getId();
		if(!accountRepository.exists(accountId)){
			logger.info("Failed to add account's cart product. AccountId: " + cartProduct.getAccount().getId() + " not exists.");
			throw new NotFoundException();
		}
		Long productId = cartProduct.getProduct().getId();
		if(!productRepository.exists(productId)){
			logger.info("Failed to add account's cart product. ProductId: " + productId + " not exists.");
			throw new NotFoundException();
		}
		if(cartProductRepository.findByAccountIdAndProductId(accountId, productId) != null){
			logger.info("Failed to add account's cart product. AccountId " + accountId + " && ProductId: " + productId + " already exists.");
			throw new AlreadyExistsException();
		}
		if((cartProduct.getQuantity() <= 0) || (cartProduct.getQuantity() > productRepository.findOne(productId).getQuantity())){
			logger.info("Failed to add account's cart product. Invalid quantity");
			throw new NotFoundException();
		}
		cartProductRepository.save(cartProduct);
		logger.info("CartProduct: " + cartProduct.getId() + " successfull created.");
	}
	
	@Override
	public CartProduct read(Long id) throws NotFoundException{
		CartProduct cartProductPersisted = cartProductRepository.findOne(id);
		if(cartProductPersisted == null){
			logger.info("Failed to read cartProductId: " + id + " . CartProduct not exists");
			throw new NotFoundException();
		}
		logger.info("CartProductId: " + cartProductPersisted.getId() + " successfull read");
		return cartProductPersisted;
	}
	
	@Override
	public void update(CartProduct cartProduct) throws NotFoundException{
		
		Long accountId = cartProduct.getAccount().getId();
		if(!accountRepository.exists(accountId)){
			logger.info("Failed to remove account's cart product. AccountId: " + accountId + " not exists.");
			throw new NotFoundException();
		}
		
		Long productId = cartProduct.getProduct().getId();
		if(!productRepository.exists(productId)){
			logger.info("Failed to remove account's cart product. ProductId: " + productId + " not exists on the account's cart.");
			throw new NotFoundException();
		}
		if((cartProduct.getQuantity() <= 0) || (cartProduct.getQuantity() > productRepository.findOne(productId).getQuantity())){
			logger.info("Failed to add account's cart product. Invalid quantity");
			throw new NotFoundException();
		}
		cartProductRepository.save(cartProduct);
		logger.info("CartProductId: " + cartProduct.getId() + " successfull updated.");
		
	}
	
	@Override
	public void delete(Long id) throws NotFoundException {
		if(!cartProductRepository.exists(id)){
			logger.info("CartProductId: " + id + " failed to delete. Not Exists.");
			throw new NotFoundException();
		}
		cartProductRepository.delete(id);
		logger.info("CartProduct: " + id + " successfull deleted.");
	}
	
	
	@Override
	public List<CartProduct> findByAccountId(Long accountId) throws NotFoundException{
		if(!accountRepository.exists(accountId)){
			logger.info("Failed to reads account's cart products. AccountId: " + accountId + " not exists.");
			throw new NotFoundException();
		}
		List<CartProduct> accountProducts = new ArrayList<>();
		cartProductRepository.findByAccountId(accountId)
		.forEach(accountProducts::add);
		logger.info("CartProducts of accountId: " + accountId + " successfull read.");
		return accountProducts;
	}

	@Override
	public void deleteAllByAccountId(Long accountId) throws NotFoundException{
		if(!accountRepository.exists(accountId)){
			logger.info("Failed to deletes account's cart products. AccountId: " + accountId + " not exists.");
			throw new NotFoundException();
		}
		List<CartProduct> accountProducts = new ArrayList<>();
		cartProductRepository.findByAccountId(accountId)
		.forEach(accountProducts::add);
		for(CartProduct cartProduct: accountProducts){
			cartProductRepository.delete(cartProduct.getId());
		}
		logger.info("CartProducts of accountId: " + accountId + " successfull deleted.");
	}

	@Override
	public void checkOut(Long accountId) throws NotFoundException {
		if(!accountRepository.exists(accountId)){
			logger.info("Failed to make checkout. AccountId: " + accountId + " not exists.");
			throw new NotFoundException();
		}
		List<CartProduct> accountProducts = new ArrayList<>();
		cartProductRepository.findByAccountId(accountId)
		.forEach(accountProducts::add);
		if(accountProducts.size()>0){
			OrderInvoice order = new OrderInvoice(accountRepository.findOne(accountId), accountProducts);
			/*order.setAccount(accountRepository.findOne(accountId));
			order.generate(accountProducts);*/
			orderInvoiceRepository.save(order);
			deleteAllByAccountId(accountId);
			logger.info("Checkout of accountId: " + accountId + " successfull maked. Size: " + order.getProducts().size());
		}else{
			logger.info("Failed to make checkout. AccountId: " + accountId + " not have products on cart.");
			throw new NotFoundException();
		}
			
		
	}

	@Override
	public List<OrderInvoice> findAllOrderInvoiceByAccountId(Long accountId) throws NotFoundException {
		if(!accountRepository.exists(accountId)){
			logger.info("Failed to reads account's orderInvoices. AccountId: " + accountId + " not exists.");
			throw new NotFoundException();
		}
		List<OrderInvoice> accountInvoices = new ArrayList<>();
		orderInvoiceRepository.findByAccountId(accountId)
		.forEach(accountInvoices::add);
		logger.info("OrderInvoices of accountId: " + accountId + " successfull read.");
		return accountInvoices;
	}
}
