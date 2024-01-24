package com.anp.Library;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

//This class represents a Data Access Object (DAO) for the Author entity, facilitating database operations.
public class AuthorDAO {   

	
//The entityManager is an instance of javax.persistence.EntityManager used for interacting with the JPA (Java Persistence API) for database operations.
    private EntityManager entityManager;

    
  //Initializes the AuthorDAO with an EntityManager to be used for database operations.
    public AuthorDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
//saveAuthor: Persists or updates an Author entity in the database.
 //It uses merge to either insert or update the author, and the transaction is committed.
    public void saveAuthor(Author author) {
        entityManager.getTransaction().begin();
        entityManager.merge(author);
        entityManager.getTransaction().commit();
    }

    //updateAuthor: Updates an existing Author entity in the database. 
    //It uses merge and commits the transaction.
    public void updateAuthor(Author author) {
        entityManager.getTransaction().begin();
        entityManager.merge(author);
        entityManager.getTransaction().commit();
    }
    
//getAuthorById: Retrieves an Author entity from the database based on the provided ID.
    public Author getAuthorById(int id) {
        return entityManager.find(Author.class, id);
    }
    
//getAllAuthors: Retrieves a list of all Author entities from the database using a JPQL (Java Persistence Query Language) query.

    public List<Author> getAllAuthors() {
        TypedQuery<Author> query = entityManager.createQuery("SELECT DISTINCT a FROM Author a", Author.class);
        return query.getResultList();
    }

    //deleteAuthor: Deletes an Author entity from the database based on the provided ID
    //It uses remove and commits the transaction if the book exists.
    public void deleteAuthor(int id) {
        Author author = entityManager.find(Author.class, id);
        if (author != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(author);
            entityManager.getTransaction().commit();
            
        }
    }
}






