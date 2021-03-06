package com.jade.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "user")
public class User{

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="user_id")
    private String userId;

    @OneToOne(cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn(name="user_id", referencedColumnName="name_Id")
    @JoinColumn(name = "name", referencedColumnName = "name_id")
    private Name name;

    @OneToOne(cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn(name="user_id", referencedColumnName="contact_Id")
    @JoinColumn(name = "contact", referencedColumnName = "contact_id")
    private Contact contact;

    @OneToOne(cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn(name="user_id", referencedColumnName="email_Id")
    @JoinColumn(name = "email", referencedColumnName = "email_id")
    private Email email;

    private User() {
    }

    private User(Builder builder) {
        this.userId = builder.userId;
        this.name = builder.name;
        this.contact = builder.contact;
        this.email = builder.email;
    }

    public String getUserId() {
        return userId;
    }

    public Name getName() {
        return name;
    }

    public Contact getContact() {
        return contact;
    }

    public Email getEmail() {
        return email;
    }

    public static class Builder {

        private String userId;
        private Name name;
        private Contact contact;
        private Email email;

        public Builder name(Name name){
            this.name = name;
            return this;
        }

        public Builder contact(Contact contact){
            this.contact = contact;
            return this;
        }

        public Builder email(Email email){
            this.email = email;
            return this;
        }

        public Builder userId( String userId) {
            this.userId = userId;
            return this;
        }

        public Builder Copy(User user){
            this.userId = user.userId;
            this.name = user.name;
            this.contact = user.contact;
            this.email = user.email;

            return this;
        }


        public User build() {
            return new User(this);
        }

    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name=" + name +
                ", contact=" + contact +
                ", email=" + email +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return userId.equals(user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
