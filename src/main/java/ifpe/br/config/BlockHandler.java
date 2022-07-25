package ifpe.br.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

import ifpe.br.model.UserBookStore;
import ifpe.br.repository.UserRepository;

@Component
public class BlockHandler {
	
	@Autowired
	UserRepository userRepository;
	
	
	@EventListener
	public void authFail(AuthenticationFailureBadCredentialsEvent eventFail){
		
        String login = (String) eventFail.getAuthentication().getPrincipal();
        Optional<UserBookStore> userOptional = userRepository.findByLogin(login);
        
        if(userOptional.isPresent()) {
        	UserBookStore user = userOptional.get();
        	user.setAttempts(user.getAttempts()+1);
        	
        	if(user.getAttempts() == 3) {
        		user.setBlocked(true);
        		System.out.println("Usuário bloqueado");
        	}
        	
        	userRepository.save(user);
        	
        }
		
	}
	
}
