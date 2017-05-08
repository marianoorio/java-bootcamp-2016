package globant.javabootcamp.finalproject.Services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import globant.javabootcamp.finalproject.Entities.Account;
import globant.javabootcamp.finalproject.Exceptions.AlreadyExistsException;
import globant.javabootcamp.finalproject.Exceptions.NotFoundException;
import globant.javabootcamp.finalproject.Repositories.AccountRepository;

@Service
public class AccountServiceBean implements AccountService {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private AccountRepository userRepository;
	
	@Override
	public void create(Account user) throws AlreadyExistsException {
		Account userPersisted = userRepository.findByUsername(user.getUsername());
		if(userPersisted != null){
			logger.info(user.getUsername() + " failed to save. Already Exists.");
			throw new AlreadyExistsException();
		}
		userRepository.save(user);
		logger.info(user.getUsername() + " saved successfull.");
	}

	@Override
	public Account read(Long id) throws NotFoundException {
		Account userPersisted = userRepository.findOne(id);
		if (userPersisted == null){
			logger.info("userId: " + id + " failed to read. Not exists.");
			throw new NotFoundException();
		}
		logger.info("userId: " + id + " was read successfull.");
		return userPersisted;
	}

	@Override
	public void update(Account user) throws NotFoundException {
		Account userPersisted = userRepository.findOne(user.getId());
		if (userPersisted == null){
			logger.info("userId: " + user.getId() + " failed to update. Not exists.");
			throw new NotFoundException();
		}
		userRepository.save(user);
		logger.info("userId: " + user.getId() + " updated successfull.");
	}

	@Override
	public void delete(Long id) throws NotFoundException {
		Account userPersisted = userRepository.findOne(id);
		if (userPersisted == null){
			logger.info("userId: " + id + " failed to delete. Not exists.");
			throw new NotFoundException();
		}
		userRepository.delete(id);
		logger.info("userId: " + id + " deleted successfull.");
	}

	@Override
	public Account findByUsername(String username) throws NotFoundException {
		Account userPersisted = userRepository.findByUsername(username);
		if (userPersisted == null){
			logger.info(username + " failed to read. Not exists.");
			throw new NotFoundException();
		}
		logger.info(username + " read successfull.");
		return userPersisted;
	}

	@Override
	public List<Account> findAll() {
		List<Account> allUsers = new ArrayList<>();
		userRepository.findAll().forEach(allUsers::add);
		return allUsers;
	}

	@Override
	public long size() {
		return userRepository.count();
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
	}
}
