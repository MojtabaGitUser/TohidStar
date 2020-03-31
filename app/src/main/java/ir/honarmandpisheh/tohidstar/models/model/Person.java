package ir.honarmandpisheh.tohidstar.models.model;

import io.realm.RealmObject;

public class Person   {

    private String firstName,lastName,personalCode,mobileNumber;
    Occupation occupation;


    public Person() {
    }

    public Person(String firstName, String lastName, String personalCode, String mobileNumber, Occupation occupation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalCode = personalCode;
        this.mobileNumber = mobileNumber;
        this.occupation = occupation;
    }

    public enum Occupation{
        FOREMAN,
        WORKER,
        MANAGER
    }

    public Person(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }




}
