package com.example.springentitymanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springentitymanager.entity.Contact;
import com.example.springentitymanager.repository.ContactRepository;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    
    @Autowired
    private ContactRepository contactRepository;

    @GetMapping({"", "/"})
    public List<Contact> getContacts() {
        return contactRepository.getContacts();
    }

    @PostMapping({"", "/"})
    public void createContact(@RequestBody Contact contact) {
        contactRepository.saveContact(contact);
    
    }

    @PutMapping({"", "/"})
    public void updateContact(@RequestBody Contact contact) {
        contactRepository.updateContact(contact);
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactRepository.deleteContact(id);
    }

    

}
