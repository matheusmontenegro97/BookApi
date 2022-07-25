package ifpe.br.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifpe.br.model.UserBookStore;
import ifpe.br.repository.UserRepository;
import ifpe.br.utils.Roles;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private Roles roles;
		
	public UserBookStore createUser(UserBookStore user) throws Exception {
		validaPassword(user.getPassword());
		
		if(user.getRole().equalsIgnoreCase("USER")) {
			user.setRoles(roles.RoleUser());
		}
		else if(user.getRole().equalsIgnoreCase("ADMIN")) {
			user.setRoles(roles.RoleAdmin());
		}
		
		return userRepository.save(user);
	}
	
	public List<UserBookStore> auditUsers(){
		return userRepository.findAll();
	}
	
	private void validaPassword(String password) throws Exception {
		String regex = "^(?=(.*[a-z]){3,})(?=(.*[A-Z]){2,})(?=(.*[0-9]){2,})(?=(.*[!@#$%^&*()\\-__+.]){1,}).{8,}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(password);
				
		if(!matcher.matches()) {
			throw new Exception("A senha não é forte o bastante!");
		}
	}

}
