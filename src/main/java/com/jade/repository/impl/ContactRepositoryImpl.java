//package com.jade.repository.impl;
//
//import com.jade.domain.Contact;
//import com.jade.repository.ContactRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Repository("InMemory5")
//public class ContactRepositoryImpl implements ContactRepository {
//
//    private static ContactRepositoryImpl repository = null;
//    private Set<Contact> contacts;
//
//    private ContactRepositoryImpl(){
//        this.contacts = new HashSet<>();
//    }
//
//    private Contact findContact(final String contactId){
//        // version 1.8 + return this.addresses.stream()
//        // .filter(address -> address
//        // .getAddressId().trim()
//        // .equals(addressId)).findAny().orElse(null);
//        for(Contact c : this.contacts){
//            if(c.getContactId().equals(contactId)) return c;
//        }
//        return null;
//    }
//
//    public static ContactRepositoryImpl getRepository(){
//        if(repository == null) repository = new ContactRepositoryImpl();
//        return repository;
//    }
//
//
//    @Override
//    public Set<Contact> getAll() {
//        return this.contacts;
//    }
//
//    @Override
//    public Contact create(Contact contact) {
//        this.contacts.add(contact);
//        return contact;
//    }
//
//    @Override
//    public Contact update(Contact contact) {
//        Contact toDelete = findContact(contact.getContactId());
//        if(toDelete != null){
//            this.contacts.remove(toDelete);
//            return create(contact);
//        }
//        return null;
//    }
//
//    @Override
//    public void delete(String contactId) {
//        Contact contact = findContact(contactId);
//        if(contact != null) this.contacts.remove(contact);
//    }
//
//    @Override
//    public Contact read(final String contactId) {
//        Contact contact = findContact(contactId);
//        return contact;
//    }
//}
