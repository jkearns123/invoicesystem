package com.jade.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "registerdname")
public class Registerdname {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="rname_id")
    private String rnameId;
    private String rfirstName;
    private String rlastName;

    private Registerdname() {
    }

    private Registerdname(Builder builder){
        this.rnameId = builder.rnameId;
        this.rfirstName = builder.rfirstName;
        this.rlastName = builder.rlastName;
    }

    public String getRnameId() {
        return rnameId;
    }

    public String getRfirstName() {
        return rfirstName;
    }

    public String getRlastName() {
        return rlastName;
    }

    public static class Builder{
        private String rnameId, rfirstName, rlastName;

        public Builder rnameId(String rnameId){
            this.rnameId = rnameId;
            return this;
        }

        public Builder rfirstName(String rfirstName) {
            this.rfirstName = rfirstName;
            return this;
        }

        public Builder rlastName(String rlastName) {
            this.rlastName = rlastName;
            return this;
        }

        public Builder copy(Registerdname Registerdname){
            this.rnameId = Registerdname.rnameId;
            this.rfirstName = Registerdname.rfirstName;
            this.rlastName = Registerdname.rlastName;

            return this;
        }

        public Registerdname build(){return new Registerdname(this);}

    }

    @Override
    public String toString() {
        return "Registerdname{" +
                "rnameId='" + rnameId + '\'' +
                ", rfirstName='" + rfirstName + '\'' +
                ", rlastName='" + rlastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Registerdname registerdname = (Registerdname) o;

        return rnameId.equals(registerdname.rnameId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rnameId);
    }
}
