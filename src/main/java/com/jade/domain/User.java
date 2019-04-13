package com.jade.domain;

public class User {
    private String userId, userFirstName, userLastName, contactNumber;

    private User() {
    }

    private User(Builder builder) {
        this.userId = builder.userId;
        this.userFirstName = builder.userFirstName;
        this.userLastName = builder.userLastName;
        this.contactNumber = builder.contactNumber;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public static class Builder {

        private String userId, userFirstName, userLastName, contactNumber;

        public Builder userId( String userId) {
            this.userId = userId;
            return this;
        }

        public Builder userFirstName( String userFirstName) {
            this.userFirstName = userFirstName;
            return this;
        }

        public Builder userLastName( String userLastName) {
            this.userLastName = userLastName;
            return this;
        }

        public Builder contactNumber( String contactNumber) {
            this.contactNumber = contactNumber;
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
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
