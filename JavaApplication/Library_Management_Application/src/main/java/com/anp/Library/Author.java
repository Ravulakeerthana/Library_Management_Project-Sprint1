package com.anp.Library;

import javax.persistence.*;
import java.util.List;

//The @Entity annotation indicates that this class is an entity that will be mapped to a database table.
@Entity
public class Author {

    @Id     //The @Id annotation specifies the primary key field of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // indicates that the primary key values are automatically generated by the database.
    
    //attributes of the Author entity
    private Long id;

    private String name;
    private int age;
    private String country;
    private String genre;
    private String awards;
    
 /*Author class represents an entity with attributes such as name, age, country, genre,and awards. 
  It is linked to a list of Book entities through a one-to-many relationship. */
    @OneToMany(mappedBy = "author") 
    private List<Book> books;       


    
    // Default constructor
    public Author() {
    }

    // Constructor with parameters
    public Author(long id, String name, int age, String country, String genre, String awards) {
    	this.id = id;
        this.name = name;
        this.age = age;
        this.country = country;
        this.genre = genre;
        this.awards = awards;
    }

    // Getter and setter methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    
    /* The toString method is overridden to provide a string representation of the Author object, 
    including its attributes and the associated Book objects.*/

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", age=" + age + ", country=" + country + ", genre=" + genre
				+ ", awards=" + awards + ", books=" + books + "]";
	}
}



