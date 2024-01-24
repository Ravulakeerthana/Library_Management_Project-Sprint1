package com.anp.Library;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

// The LibraryMain class serves as the main entry point of the application
// demonstrating the usage of LibraryDAO to interact with the database.

public class LibraryMain {    

    public static void main(String[] args) {
        // Creating EntityManagerFactory
   EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("libraryPersistenceUnit");

        // Creating EntityManager
    EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            
            BookDAO bookDAO = new BookDAO(entityManager);
            AuthorDAO authorDAO = new AuthorDAO(entityManager);
            MemberDAO memberDAO = new MemberDAO(entityManager);

            
     System.out.println("***-------WELCOME TO LIBRARY_MANAGEMENT DATABASES--------***");


            // Create and save an Author
   Author author1= new Author(1,"Harper Lee", 89, "United States", "Fiction","Pulitzer Prize for Fiction");
   Author author2= new Author(2,"Agatha Christie", 85, "United Kingdom", "Mystery", "Damehood and Grand Master Award");
   Author author3= new  Author(3,"Isaac Asimov", 72, "United States", "Science Fiction", "Hugo Award and Nebula Award");
   Author author4= new Author(4,"Dan Brown", 57, "United States", "Thriller", "New York Times Best Seller");
   Author author5= new Author(5,"Nicholas Sparks", 55, "United States", "Romance", "Nicholas Sparks Foundation Humanitarian Award");
            
            
            authorDAO.saveAuthor(author1);
            authorDAO.saveAuthor(author2);
            authorDAO.saveAuthor(author3);
            authorDAO.saveAuthor(author4);
            authorDAO.saveAuthor(author5);
            
                 System.out.println();
       System.out.println("----Author Data added successfully-----");
                 System.out.println();

           
                  // Create and save a Book
        Book book1= new Book(1,"To Kill a Mockingbird", "Fiction", 336, 52.99, true , author1);
       	Book book2= new Book(2,"Murder on the Orient Express", "Mystery", 256, 144.99, false, author2 );
       	Book book3= new Book(3,"Foundation", "Science Fiction", 400, 96.99, true, author3);
       	Book book4= new Book(4,"The Da Vinci Code", "Thriller", 454, 88.99, true, author4);
        Book book5= new Book(5,"The Notebook", "Romance", 272, 125.99, false, author5);

                  bookDAO.saveBook(book1);
                  bookDAO.saveBook(book2);
                  bookDAO.saveBook(book3);
                  bookDAO.saveBook(book4);
                  bookDAO.saveBook(book5);
                  
                  System.out.println();
          System.out.println("-----Book Data added successfully----- ");
                  System.out.println();


                     // Create and save a Member
            Member  member1 =new Member(1,"Alice Johnson", 30, "123 Main St, Cityville", "Gold", true);
            Member  member2 =new Member(2,"Bob Anderson", 45, "456 Oak St, Townsville", "Silver", false);
        	Member	member3 =new Member(3,"Charlie Brown", 28, "789 Elm St, Villagetown", "Bronze", true);
   			Member	member4 =new Member(4,"Diana Smith", 35, "101 Pine St, Hamletville", "Platinum", true);
   			Member 	member5 =new Member(5,"Eva Martinez", 40, "202 Cedar St, Boroughburg", "Gold", false);

                   memberDAO.saveMember(member1);
                   memberDAO.saveMember(member2);
                   memberDAO.saveMember(member3);
                   memberDAO.saveMember(member4);
                   memberDAO.saveMember(member5);
                   
                   System.out.println();
          System.out.println("-----Member Data added successfully----  ");
                   System.out.println();
                   
         System.out.println("--------------------------------------------------");

         // Updating author details based on ID		
      Author updatedAuthor3 = new Author(3,"J.K. Rowling", 56, "United Kingdom", "Fantasy", "Order of the British Empire and Hans Christian Andersen Literature Award");
                   
                   authorDAO.saveAuthor(updatedAuthor3);
                   
                   System.out.println();
        System.out.println("-----Author record 3 updated successfully----- ");
                   System.out.println();

                   
        System.out.println("--------------------------------------------------");
                   
                // Deleting  member record based on ID
              int memberIdToDelete = 2;
               memberDAO.deleteMember(2);

                   System.out.println();
       System.out.println("------Member record 2 deleted successfully----- ");
                   System.out.println();
                   
       System.out.println("--------------------------------------------------");

                   
            // Retrieve and display all books
            List<Book> allBooks = bookDAO.getAllBooks();
            System.out.println("All Books:");
            for (Book b : allBooks) {
                System.out.println(b.getTitle() + " by " + b.getAuthor().getName());
            }

            // Retrieve and display all authors
            List<Author> allAuthors = authorDAO.getAllAuthors();
            System.out.println("\nAll Authors:");
            for (Author a : allAuthors) {
                System.out.println(a.getName() + " - " + a.getAwards());
            }

            // Retrieve and display all members
            List<Member> allMembers = memberDAO.getAllMembers();
            System.out.println("\nAll Members:");
            for (Member m : allMembers) {
                System.out.println(m.getName() + " - " + m.getMembershipType());
            }

        } 
        
        finally {
        	
            // Close EntityManager and EntityManagerFactory
        	
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
            if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
                entityManagerFactory.close();
            }
        }
    }
    
}


/*This class (LibraryMain) demonstrates the creation, update, and deletion of authors, books, and members using DAO classes. 
It also retrieves and displays all books, authors, and members from the database. 
The application  provides a practical example of how to interact with a database in a library management system
using JPA and DAO design patterns.*/









