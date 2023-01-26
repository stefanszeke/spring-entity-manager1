package com.example.springentitymanager.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springentitymanager.entity.Contact;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class ContactRepository {

    @Autowired
    private EntityManager entityManager;

    // get request
    public List<Contact> getContacts() {
        return entityManager.createQuery("SELECT c FROM Contact c", Contact.class).getResultList();
    }

    // post request
    @Transactional
    public void saveContact(Contact contact) {
        entityManager.createQuery("INSERT INTO Contact (name, email, adress) VALUES (:name, :email, :adress)")
            .setParameter("name", contact.getName())
            .setParameter("email", contact.getEmail())
            .setParameter("adress", contact.getAdress())
            .executeUpdate();

            System.out.println(contact.getName() + " Contact saved!");
    }

    // put request
    @Transactional
    public void updateContact(Contact contact) {
        entityManager.createQuery("UPDATE Contact SET name = :name, email = :email, adress = :adress WHERE id = :id")
            .setParameter("name", contact.getName())
            .setParameter("email", contact.getEmail())
            .setParameter("adress", contact.getAdress())
            .setParameter("id", contact.getId())
            .executeUpdate();

            System.out.println(contact.getName() + " Contact updated!");
    }

    // delete request
    @Transactional
    public void deleteContact(Long id) {
        entityManager.createQuery("DELETE FROM Contact WHERE id = :id")
            .setParameter("id", id)
            .executeUpdate();

            System.out.println("Contact deleted!");
    }





    
}

// entity manager operations:
// 1. persist - save : entityManager.persist(entityManager);
// 2. merge - update : entityManager.merge(entityManager);
// 3. remove - delete : entityManager.remove(entityManager);
// 4. find - read : entityManager.find(entityManager);
// 5. getReference - read : entityManager.getReference(entityManager);

// custom query:
// entityManager.createQuery("SELECT c FROM Contact c WHERE c.name = :name", Contact.class)