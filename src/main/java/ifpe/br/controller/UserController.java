package ifpe.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifpe.br.model.UserBookStore;
import ifpe.br.service.UserService;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/bookStoreUser")
	public ResponseEntity<UserBookStore> createBookStoreUser(@RequestBody UserBookStore user) throws Exception {
		
		return ResponseEntity.status(HttpStatus.OK).body(service.createUser(user));
		
	}
	
	@GetMapping("/auditUsers")
	public ResponseEntity<List<UserBookStore>> auditUsers(){
		return ResponseEntity.status(HttpStatus.OK).body(service.auditUsers());
	}
		
}
