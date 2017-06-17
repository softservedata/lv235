package com.softserve.edu.users;

interface ILogin {
    IPassword setLogin(String login);
}

interface IPassword {
    IFirstname setPassword(String password);
}

interface IFirstname {
    ILastname setFirstname(String firstname);
}

interface ILastname {
    IBuild setLastname(String lastname);
}

interface IBuild {
	IBuild setEmail(String email);
    IUser build();
}

// POJO
public class User implements ILogin, IPassword, IFirstname, ILastname, IBuild, IUser {
    private String login;
    private String password;
    private String firstname;
    private String lastname;
    private String email;

    // public User(String login, String password, String firstname, String
    // lastname, String email) {
    // this.login = login;
    // this.password = password;
    // this.firstname = firstname;
    // this.lastname = lastname;
    // this.email = email;
    // }

    private User() {
    }

    public static ILogin get() {
        return new User();
    }

    // set

    public IPassword setLogin(String login) {
        this.login = login;
        return this;
    }

    public IFirstname setPassword(String password) {
        this.password = password;
        return this;
    }

    public ILastname setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public IBuild setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public IUser build() {
        return this;
    }

    public IBuild setEmail(String email) {
        this.email = email;
        return this;
    }

    // get

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

}
