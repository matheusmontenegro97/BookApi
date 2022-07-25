package ifpe.br.config;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ifpe.br.model.UserBookStore;
import ifpe.br.repository.UserRepository;

@Service
@Transactional
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	UserRepository userRepository;

	public UserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException{
		final UserBookStore userBookStore = userRepository.findByLogin(login)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with login: " + login));
		return new User(userBookStore.getUsername(), userBookStore.getPassword(), true, true, true,true, userBookStore.getAuthorities());
	}
}
