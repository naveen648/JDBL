package com.example.JPA.Joins.Models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;

    private String name;
    private String authorName;
    private int cost;

    @ManyToOne
    @JoinColumn
    private BookCategory bookCategory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }

    public Book(String name, String authorName, int cost) {
        this.name = name;
        this.authorName = authorName;
        this.cost = cost;
    }

    public Book(String name, String authorName, int cost, int bookCategory) {
        this.name = name;
        this.authorName = authorName;
        this.cost = cost;
        this.bookCategory=new BookCategory();
        this.bookCategory.setId(bookCategory);
    }

    //    public Book(int id, String name, String authorName, int cost) {
//        this.id = id;
//        this.name = name;
//        this.authorName = authorName;
//        this.cost = cost;
//    }

    public Book() {
    }

    @Override
    public String toString()
    {
        return "{id = "+this.getId()+" name = "+this.getName()+", authorName = "+this.getAuthorName()+", cost = "+this.getCost()+"}";
    }
}
