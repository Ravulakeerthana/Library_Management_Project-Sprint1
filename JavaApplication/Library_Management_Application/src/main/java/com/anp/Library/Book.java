package com.anp.Library;

import javax.persistence.*;

//The @Entity annotation indicates that this class is an entity that will be mapped to a database table.
@Entity
public class Book {

    @Id    //The @Id annotation specifies the primary key field of the entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //indicates that the primary key values are automatically generated by the database.
    
    //attributes of the Book entity.
    private int id;

    private String title;
    private String genre;
    private int pages;
    private double price;
    private boolean available;

    
   /*Book class represents a book entity with attributes such as title, genre, pages, price, and availability. 
   It is linked to an Author entity through a many-to-one relationship,
    indicating that many books can be associated with a single author.*/ 
    @ManyToOne
    private Author author;

    
    // Default constructor
    public Book() {
    }

    // Constructor with parameters
    public Book(int id,String title, String genre, int pages, double price, boolean available, Author author) {
    	
    	this.id =id;
        this.title = title;
        this.genre = genre;
        this.pages = pages;
        this.price = price;
        this.available = available;
        this.author = author;
    }

    // Getter and setter methods

    public int getId() {
        return id;
    }

	public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

/*The toString method is overridden to provide a string representation of the Book object,
    including its attributes and the associated Author object.*/
@Override
public String toString() {
	return "Book [id=" + id + ", title=" + title + ", genre=" + genre + ", pages=" + pages + ", price=" + price
			+ ", available=" + available + ", author=" + author + "]";
}
}