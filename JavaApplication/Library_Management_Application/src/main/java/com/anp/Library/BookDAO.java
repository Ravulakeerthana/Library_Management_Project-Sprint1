package com.anp.Library;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

//This class represents a Data Access Object (DAO) for the Book entity, facilitating database operations.
public class BookDAO {
	
//The entityManager is an instance of javax.persistence.EntityManager used for interacting with the JPA (Java Persistence API) for database operations.
    private EntityManager entityManager;
    
//Initializes the BookDAO with an EntityManager to be used for database operations.
    public BookDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
//saveBook: Persists or updates a Book entity in the database.
    //It uses merge to either insert or update the book, and the transaction is committed.
    public void saveBook(Book book) {
        entityManager.getTransaction().begin();
        entityManager.merge(book);
        entityManager.getTransaction().commit();
    }
    
//updateBook: Updates an existing Book entity in the database. 
   // It uses merge and commits the transaction.
     public void updateBook(Book book) {
        entityManager.getTransaction().begin();
        entityManager.merge(book);
        entityManager.getTransaction().commit();
    }
     
   // getBookById: Retrieves a Book entity from the database based on the provided ID.
    public Book getBookById(int id) {
        return entityManager.find(Book.class, id);
    }
    
//getAllBooks: Retrieves a list of all Book entities from the database using a JPQL (Java Persistence Query Language) query.
    public List<Book> getAllBooks() {
        TypedQuery<Book> query = entityManager.createQuery("SELECT DISTINCT b FROM Book b", Book.class);
        return query.getResultList();
    }
    
//deleteBook: Deletes a Book entity from the database based on the provided ID. 
    //It uses remove and commits the transaction if the book exists.
    public void deleteBook(int id) {
        Book book = entityManager.find(Book.class, id);
        if (book != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(book);
            entityManager.getTransaction().commit();
        }
    }
}



