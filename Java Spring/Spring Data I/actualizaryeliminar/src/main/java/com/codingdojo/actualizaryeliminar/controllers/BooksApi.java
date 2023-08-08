package com.codingdojo.actualizaryeliminar.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.actualizaryeliminar.models.Book;
import com.codingdojo.actualizaryeliminar.services.BookService;

@RestController
public class BooksApi {
	private final BookService bookService;

	public BooksApi(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping("/api/books")
	public List<Book> index() {
		return bookService.allBooks();
	}

	@RequestMapping(value = "/api/books", method = RequestMethod.POST)
	public Book create(@RequestParam(value = "title") String title, @RequestParam(value = "description") String desc,
			@RequestParam(value = "language") String lang, @RequestParam(value = "pages") Integer numOfPages) {
		Book book = new Book(title, desc, lang, numOfPages);
		return bookService.createBook(book);
	}

	@RequestMapping("/api/books/{id}")
	public Book show(@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		return book;
	}

	@PutMapping("/api/books/{id}")
	public Book updateBook(@PathVariable Long id, @RequestParam String title, @RequestParam String desc,
			@RequestParam String lang, @RequestParam int numberOfPages) {
		Book updatedBook = bookService.updateBook(id, title, desc, lang, numberOfPages);
		return updatedBook;
	}

	@DeleteMapping("api/books/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable Long id) {
		bookService.deleteBook(id);
		return ResponseEntity.ok().body("Libro eliminado exitosamente.");
	}
}
