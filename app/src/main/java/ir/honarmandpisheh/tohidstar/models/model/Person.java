package ir.honarmandpisheh.tohidstar.models.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import io.realm.RealmObject;
import ir.honarmandpisheh.tohidstar.BR;

public class Person extends BaseObservable {

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
//    @Bindable
    public String getFirstName() {
        return firstName;

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
//        notifyPropertyChanged(BR.model);
    }
//    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
//        notifyPropertyChanged(BR.model);
    }
//    @Bindable
    public String getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
//        notifyPropertyChanged(BR.model);
    }
//    @Bindable
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
//        notifyPropertyChanged(BR.model);
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public boolean isFirstNameValid(){
        return firstName!=null && firstName.length()>0 ;
    }
    public boolean isLastNameValid(){
        return lastName!=null&&lastName.length()>0;
    }
    public boolean isMobileNumberValid(){
        return mobileNumber!=null &&mobileNumber.length()>9 && mobileNumber.length()<12;
    }
    public boolean isPersonalCodeValid(){
        return personalCode!=null && personalCode.length()==10;
    }
    public void clean(){
        firstName="";
        lastName="";
        personalCode="";
        mobileNumber="";
        occupation=null;
    }

}
