package com.jade.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import org.hibernate.annotations.Parameter;


@Entity(name = "contact")
public class Contact {


    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="contact_id")
    private String contactId;
    private String cellContact;
    private String workContact;
    private String homeContact;



    private Contact() {
    }

    private Contact(Builder builder){
        this.contactId = builder.contactId;
        this.cellContact = builder.cellContact;
        this.workContact = builder.workContact;
        this.homeContact = builder.homeContact;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getCellContact() {
        return cellContact;
    }

    public String getWorkContact() {
        return workContact;
    }

    public String getHomeContact() {
        return homeContact;
    }

    public static class Builder{
        private String contactId, cellContact, workContact, homeContact;

        public Builder contactId(String contactId){
            this.contactId = contactId;
            return this;
        }
        public Builder cellContact(String cellContact) {
            this.cellContact = cellContact;
            return this;
        }

        public Builder workContact(String workContact) {
            this.workContact = workContact;
            return this;
        }

        public Builder homeContact(String homeContact) {
            this.homeContact = homeContact;
            return this;
        }

        public Builder copy(Contact contact){
            this.contactId = contact.contactId;
            this.cellContact = contact.cellContact;
            this.workContact = contact.workContact;
            this.homeContact = contact.homeContact;

            return this;
        }

        public Contact build(){return new Contact(this);}
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId='" + contactId + '\'' +
                ", cellContact='" + cellContact + '\'' +
                ", workContact='" + workContact + '\'' +
                ", homeContact='" + homeContact + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        return contactId.equals(contact.contactId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactId);
    }
}
