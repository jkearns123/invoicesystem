package com.jade.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import org.hibernate.annotations.Parameter;

@Entity(name = "name")
public class Name {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="name_id")
    private String nameId;
    private String firstName;
    private String lastName;



    private Name() {
    }

    private Name(Builder builder){
        this.nameId = builder.nameId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public String getNameId() {
        return nameId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static class Builder{
        private String nameId, firstName, lastName;

        public Builder nameId(String nameId){
            this.nameId = nameId;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder copy(Name name){
            this.nameId = name.nameId;
            this.firstName = name.firstName;
            this.lastName = name.lastName;

            return this;
        }

        public Name build(){return new Name(this);}

    }

    @Override
    public String toString() {
        return "Name{" +
                "nameId='" + nameId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Name name = (Name) o;

        return nameId.equals(name.nameId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameId);
    }
}
