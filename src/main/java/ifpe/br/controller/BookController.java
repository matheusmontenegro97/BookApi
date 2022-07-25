package ifpe.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifpe.br.model.Book;
import ifpe.br.service.BookService;

@RestController
@RequestMapping("/api/v1")
public class BookController {
	
	@Autowired
	BookService service;
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/book/{idBook}")
	public ResponseEntity<Book> returnBook(@PathVariable(value = "idBook") Long idBook) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(service.returnBookById(idBook));
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/books")
	public ResponseEntity<List<Book>> returnListBook() throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(service.returnListBooks());
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/book")
	public ResponseEntity<Book> createBook(@RequestBody Book book){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createBook(book));
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/book/{idBook}")
	public ResponseEntity<Book> updateBook(@PathVariable(value = "idBook") Long idBook, @RequestBody Book book) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(service.updateBook(idBook, book));
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/book/{idBook}")
	public void deleteBook(@PathVariable(value = "idBook") Long idBook) throws Exception {
		service.deleteBook(idBook);
	}
}
