package com.jade.domain;

public class Contact {
    private String cellContact, workContact, homeContact;

    private Contact() {
    }

    private Contact(Builder builder){
        this.cellContact = builder.cellContact;
        this.workContact = builder.workContact;
        this.homeContact = builder.homeContact;
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
        private String cellContact, workContact, homeContact;


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

        public Contact build(){return new Contact(this);}
    }

    @Override
    public String toString() {
        return "Contact{" +
                "cellContact='" + cellContact + '\'' +
                ", workContact='" + workContact + '\'' +
                ", homeContact='" + homeContact + '\'' +
                '}';
    }
}
