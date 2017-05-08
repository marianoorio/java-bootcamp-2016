package globant.javabootcamp.finalproject.Services;

import globant.javabootcamp.finalproject.Exceptions.NotFoundException;

public interface LoginService {
	
	/**
	 * Login an user's account into the system
	 * 
	 * @param username
	 * Username to login into the system.
	 * @param password
	 * Username's password.
	 * @throws NotFoundException
	 * If no exists the username OR if not matches the username and password.
	 */
	public void login(String username, String password) throws NotFoundException;
	
	/**
	 * Log out an user's account previously login.
	 * 
	 * @param username
	 * Username to logout.
	 * @throws NotFoundException
	 * If no exists the username OR if not are the username login.
	 */
	public void logout(String username) throws NotFoundException;
	
	public boolean isLogged(Long userId);
}
