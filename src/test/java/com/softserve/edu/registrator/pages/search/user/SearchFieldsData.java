package com.softserve.edu.registrator.pages.search.user;

/**
 * Created by User on 6/30/2017.
 */
public class SearchFieldsData  implements ISearchFields {

    private String firstName;
    private String secondName;
    private String email;

    /*
     * Constructor
     */
    public SearchFieldsData(String firstName, String secondName, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
