package br.com.yfs.tecnologia.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
public class User {

    /*Verificar com Yan
    0xD125A5768B5C465D9A34939BB8E48A210000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
    */
    /*@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 150)
    private String fullName;

    @Column(nullable = false, length = 30)
    private String email;

    @Column(nullable = false, length = 15)
    private String cellphone;

    @Column(nullable = false, length = 15)
    private String telephone;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Address address;
    public User() {
    }
    public User(String fullName, String email, String cellphone, String telephone) {
        this.fullName = fullName;
        this.email = email;
        this.cellphone = cellphone;
        this.telephone = telephone;
    }
    public static User builder() {
        return new User();
    }
    public User fullName(String fullName) {
        this.fullName = fullName;
        return this;
    }
    public User email(String email) {
        this.email = email;
        return this;
    }
    public User cellphone(String cellphone) {
        this.cellphone = cellphone;
        return this;
    }
    public User telephone(String telephone) {
        this.telephone = telephone;
        return this;
    }
    public User address(Address address) {
        this.address = address;
        return this;
    }

    public Long getId() {
        return id;
    }

   public String getFullName() {
        return fullName;
   }
   public void setFullName(String fullName) {
        this.fullName = fullName;
   }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
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

    public void setAddress(Address address) {
        this.address = address;
    }


    @Override
    public String toString(){
        return "[User]\nName: " + getFullName() + " Email: " + getEmail() +
                " \nCellphone: " + getCellphone() + " Telephone: " + getTelephone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
