package ifpe.br.utils;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import ifpe.br.model.Role;

@Component
public class Roles {
	
	public Set<Role> RoleUser() {
		Set<Role> roleUser = new HashSet<Role>();
		roleUser.add(new Role("ROLE_USER"));
		
		return roleUser;
	}

	public Set<Role> RoleAdmin() {
		Set<Role> roleUser = new HashSet<Role>();
		roleUser.add(new Role("ROLE_ADMIN"));
		
		return roleUser;
	}
}
