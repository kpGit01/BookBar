package com.Book.demo.Controller;

import com.Book.demo.Entity.Book;
import com.Book.demo.Service.BookService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Allows  frontend to call the API
public class BookController {

    private final BookService bookService;

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = bookService.addBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Book> getBookByTitle(@PathVariable("title") String title) {
        return bookService.getBookByTitle(title)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PutMapping("/update")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        Book updatedBook = bookService.updateBook(book);
        return new ResponseEntity<>(updatedBook, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") Integer id) {
         bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/GetAllBooks")
    public ResponseEntity<List<Book>> getAll() {
    	List<Book> books = bookService.getAllBooks();
    	return ResponseEntity.ok(books);
       
    }
    
    
    
    
}