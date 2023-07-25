package com.example.JPA;
import com.example.JPA.Models.Book;
import com.example.JPA.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Autowired
	BookRepository bookRepository;
	//Note: Don't keep it inside the run() function (OR) Above Main Function, bcoz it causes error in sequence Id Generation

	@Override
	public void run(String... args) throws Exception {

//		Set<Book> books=new HashSet<>();
		List<Book> books=new ArrayList<>();
		Book b1=new Book("C++", "Snowden",150);
		Book b2=new Book("C#","Joe",265);
		Book b3=new Book("Java","Ivar",956);
		Book b4=new Book("JPA","Ragnar",500);

		books.add(b1);
		books.add(b2);
		books.add(b3);
		books.add(b4);

//		bookRepository.save(b1);
//		bookRepository.save(b2);
//		bookRepository.save(b3);
//		bookRepository.save(b4);

		bookRepository.saveAll(books);

//		System.out.println(bookRepository.findByAuthor("Naveen"));

//		System.out.println(bookRepository.findById(1));
//		System.out.println(bookRepository.findByName("JPA"));
//		System.out.println(bookRepository.findByAuthorName("Naveen"));
//		System.out.println(bookRepository.findByCost(500));

//		List<Book> books=new ArrayList<>();

//		Book b1=new Book(1,"Java","Naveen",956);
//		bookRepository.save(b1);

//		Book b1=new Book();
//		b1.setId(1);
//		b1.setName("JDBC");
//		b1.setAuthorName("Naveen");
//		b1.setCost(350);
//		bookRepository.save(b1);
	}
}