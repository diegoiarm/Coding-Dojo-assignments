package com.codingdojo.mostrar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mostrar.models.Book;
import com.codingdojo.mostrar.repositories.BookRepository;

@Service
public class BookService {
	// Agregando el book al repositorio como una dependencia
	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	// Devolviendo todos los libros.
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}

	// Creando un libro.
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}

	// Obteniendo la información de un libro.
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}

	// Actualizar un libro.
	public Book updateBook(Long id, String title, String desc, String lang, int numberOfPages) {
		Optional<Book> optionalBook = bookRepository.findById(id);

		if (optionalBook.isPresent()) {
			Book book = optionalBook.get();
			book.setTitle(title);
			book.setDescription(desc);
			book.setLanguage(lang);
			book.setNumberOfPages(numberOfPages);

			return bookRepository.save(book);
		} else {
			throw new IllegalArgumentException("No se ha encontrado ningún libro con el ID entregado.");
		}

	}

	// Eliminar un libro.
	public void deleteBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);

		if (optionalBook.isPresent()) {
			Book book = optionalBook.get();
			book.getId();
			bookRepository.deleteById(id);
		} else {
			throw new IllegalArgumentException("No se ha encontrado ningún libro con el ID entregado.");
		}
	}
}