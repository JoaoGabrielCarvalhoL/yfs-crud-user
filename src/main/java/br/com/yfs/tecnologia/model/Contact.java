package br.com.yfs.tecnologia.model;

import javax.persistence.*;
import java.util.Objects;
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cellphone;
    private String telephone;

    public Contact(){
    }

    public Contact(String cellphone, String telephone) {
        this.cellphone = cellphone;
        this.telephone = telephone;
    }

    public Long getId() {
        return id;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Cellphone: " + getCellphone() + " - Telephone: " + getTelephone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(id, contact.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
