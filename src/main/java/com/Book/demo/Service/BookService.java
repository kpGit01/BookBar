package com.Book.demo.Service;

import com.Book.demo.Entity.Book;
import com.Book.demo.Repository.BookRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

	public Book updateBook(Book book) {
		return bookRepository.save(book);
		
	}

	public void deleteBook(Integer id) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(id);
	}

	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}
}