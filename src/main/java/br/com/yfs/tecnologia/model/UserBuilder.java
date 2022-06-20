package br.com.yfs.tecnologia.model;

public class UserBuilder {

    private User user;

    private UserBuilder() {
        user = new User();
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public UserBuilder fullName(String fullName) {
        user.setFullName(fullName);
        return this;
    }
    public UserBuilder email(String email) {
        user.setEmail(email);
        return this;
    }
    public UserBuilder cellphone(String cellphone) {
        user.setCellphone(cellphone);
        return this;
    }
    public UserBuilder telephone(String telephone) {
        user.setTelephone(telephone);
        return this;
    }
    public UserBuilder address(Address address) {
        user.setAddress(address);
        return this;
    }

    public User build() {
        return this.user;
    }

}
