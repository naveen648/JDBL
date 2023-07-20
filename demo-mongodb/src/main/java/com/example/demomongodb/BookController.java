package com.example.demomongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository bookrepository;

    @GetMapping("/getBooks")
    public List<Book> getBooks(){
        return bookrepository.findAll();
    }

    @PostMapping("/insertBook")
    public void insertBook(@RequestBody CreateRequest request){
        Book book=new Book(request.getName(), request.getAuthorName(), request.getCost());
        bookrepository.save(book);
    }

    @GetMapping("/getBookByAuthor/{name}")
    public List<Book> getBookByAuthorName(@RequestParam(value="name")String name){
        return bookrepository.findByAuthorName(name);
    }
}
