package com.jade.domain;

public class User {
    private String userId;
    private Name name;
    private Contact contact;
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
}
