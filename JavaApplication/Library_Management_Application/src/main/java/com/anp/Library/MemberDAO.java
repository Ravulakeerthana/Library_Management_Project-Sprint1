package com.anp.Library;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

//This class represents a Data Access Object (DAO) for the Member entity, facilitating database operations.
public class MemberDAO { 
	
//The entityManager is an instance of javax.persistence.EntityManager used for interacting with the JPA (Java Persistence API) for database operations.
    private EntityManager entityManager;
    
//Initializes the MemberDAO with an EntityManager to be used for database operations.
    public MemberDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
//saveMember: Persists or updates a Member entity in the database.
    //It uses merge to either insert or update the member, and the transaction is committed.
    public void saveMember(Member member) {
        entityManager.getTransaction().begin();
        entityManager.merge(member);
        entityManager.getTransaction().commit();
    }
    
//updateMember: Updates an existing Member entity in the database. 
    //It uses merge and commits the transaction.
    public void updateMember(Member member) {
        entityManager.getTransaction().begin();
        entityManager.merge(member);
        entityManager.getTransaction().commit();
    }
//getMemberById: Retrieves a Member entity from the database based on the provided ID.

    public Member getMemberById(int id) {
        return entityManager.find(Member.class, id);
    }
    
  //getAllMembers: Retrieves a list of all Member entities from the database using a JPQL (Java Persistence Query Language) query.
 List<Member> getAllMembers() {
        TypedQuery<Member> query = entityManager.createQuery("SELECT DISTINCT m FROM Member m", Member.class);
        return query.getResultList();
    }
 
//deleteMember: Deletes a Member entity from the database based on the provided ID. 
 //It uses remove and commits the transaction if the member exists.
    public void deleteMember(int id) {
        Member member = entityManager.find(Member.class, id);
        if (member != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(member);
            entityManager.getTransaction().commit();
        }
    }
}


