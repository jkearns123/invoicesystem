package com.jade.domain;

import java.util.Objects;

public class Email {
    private String emailId, emailAddress;

    public Email() {
    }

    private Email(Builder builder){
        this.emailId = builder.emailId;
        this.emailAddress = builder.emailAddress;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public static class Builder{
        private String emailId, emailAddress;

        public Builder emailId(String emailId){
            this.emailId = emailId;
            return this;
        }


        public Builder emailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder copy(Email email){
            this.emailId = email.emailId;
            this.emailAddress = email.emailAddress;

            return this;
        }

        public Email build(){return new Email(this);}

    }

    @Override
    public String toString() {
        return "Email{" +
                "emailId='" + emailId + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Email email = (Email) o;

        return emailId.equals(email.emailId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailId);
    }
}
