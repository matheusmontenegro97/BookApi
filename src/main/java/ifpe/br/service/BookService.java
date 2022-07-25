package ifpe.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifpe.br.model.Book;
import ifpe.br.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository repository;
	
	public List<Book> returnListBooks(){
		return repository.findAll();
	}
	
	public Book returnBookById(Long idBook) throws Exception {
		return repository.findById(idBook).orElseThrow(()-> new Exception("No has found book with id: "+ idBook));
	}
	
	public Book createBook(Book book) {
		return repository.save(book);
	}
	
	public Book updateBook(Long idBook, Book book) throws Exception {
		Book bookOptional = repository.findById(idBook).orElseThrow(()-> new Exception("No has found book with id: "+ idBook));
		
		book.setIdBook(bookOptional.getIdBook());
		
		return repository.save(book);
		
	}
	
	public void deleteBook(Long idBook) throws Exception{
		repository.findById(idBook).orElseThrow(()-> new Exception("No has found book with id: "+ idBook));
		
		repository.deleteById(idBook);
	}

}
