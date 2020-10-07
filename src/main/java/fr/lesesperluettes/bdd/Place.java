package fr.lesesperluettes.bdd;

import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
public class Place {

    @Id
    @GeneratedValue()
    private Integer id;

    @Audited
    private String name;

    @Audited
    private String address;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

