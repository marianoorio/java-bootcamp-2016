package globant.javabootcamp.finalproject.Services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import globant.javabootcamp.finalproject.Entities.Account;
import globant.javabootcamp.finalproject.Exceptions.NotFoundException;
import globant.javabootcamp.finalproject.Repositories.AccountRepository;

@Service
public class LoginServiceBean implements LoginService{

	private Logger logger = Logger.getLogger(this.getClass());
	
	private List<Long> users = new ArrayList<>();
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public void login(String username, String password) throws NotFoundException{
		Account account = accountRepository.findByUsername(username);
		if (account == null){
			logger.info("User: " + username + " not exists.");
			throw new NotFoundException();
		}
		if(account.validPassword(password)){
			users.add(account.getId());
			logger.info("User: " + username + " log in successfull.");
		}else{
			logger.info("User's password don't match.");
			throw new NotFoundException();
		}
		
	}

	@Override
	public void logout(String username) throws NotFoundException{
		Account account = accountRepository.findByUsername(username);
		if (account == null){
			logger.info("User: " + username + " not exists.");
			throw new NotFoundException();
		}
		if(users.contains(account.getId())){
			users.remove(account.getId());
			logger.info("User: " + username + " log out successfull.");
		}else{
			logger.info("User: " + username + " not logged.");
			throw new NotFoundException();
		}
			
	}

	@Override
	public boolean isLogged(Long userId) {
		return users.contains(userId);
	}

}
