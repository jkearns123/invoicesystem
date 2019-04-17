package com.jade.domain;

public class Email {
    private String emailAddress;

    public Email() {
    }

    private Email(Builder builder){
        this.emailAddress = builder.emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public static class Builder{
        private String emailAddress;


        public Builder emailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Email build(){return new Email(this);}

    }

    @Override
    public String toString() {
        return "Email{" +
                "emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
