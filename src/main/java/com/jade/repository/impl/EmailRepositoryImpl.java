//package com.jade.repository.impl;
//
//import com.jade.domain.Email;
//import com.jade.repository.EmailRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Repository("InMemory3")
//public class EmailRepositoryImpl implements EmailRepository {
//
//    private static EmailRepositoryImpl repository = null;
//    private Set<Email> emails;
//
//    private EmailRepositoryImpl(){
//        this.emails = new HashSet<>();
//    }
//
//    private Email findEmail(final String emailId){
//        for(Email e : this.emails){
//            if(e.getEmailId().equals(emailId)) return e;
//        }
//        return null;
//    }
//
//    public static EmailRepositoryImpl getRepository(){
//        if(repository == null) repository = new EmailRepositoryImpl();
//        return repository;
//    }
//
//
//    @Override
//    public Email create(Email email) {
//        this.emails.add(email);
//        return email;
//    }
//
//    @Override
//    public Email update(Email email) {
//        Email toDelete = findEmail(email.getEmailId());
//        if(toDelete != null){
//            this.emails.remove(toDelete);
//            return create(email);
//        }
//        return null;
//    }
//
//    @Override
//    public void delete(String s) {
//        Email email = findEmail(s);
//        if(email != null) this.emails.remove(email);
//    }
//
//    @Override
//    public Email read(String s) {
//        Email email = findEmail(s);
//        return email;
//    }
//
//
//    public Set<Email> getAll() {
//        return this.emails;
//    }
//}
