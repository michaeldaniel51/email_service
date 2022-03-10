package com.dannycodes.email.entities;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Random;


@Entity
public class Email {


    private String firstname;
    private String lastname;
    private String password;
    private String department;
    private int mailboxCapacity = 500;
    @Id
    private String email;
    private String alternateEmail = "anybody@dmail.com";


    public Email(String firstname, String lastname, String password, String department, int mailboxCapacity, String alternateEmail) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.department = department;
        this.mailboxCapacity = mailboxCapacity;
        this.email = showInfo();
        this.alternateEmail = alternateEmail;
    }

    public Email() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getAlternateEmail() {
        return alternateEmail;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String randomPassword(int lenght) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@#$%^&*";
        char[] password = new char[lenght];
        for (int i = 0; i < lenght; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);

    }

    public String c() {

        int passwordLength = 12;
        String passwordCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@#$%^&*";
         char[] password = new char[passwordLength];
         for (int i = 0; i<passwordLength; i++){
             Random ran = new Random();
             int g = ran.nextInt(passwordCharacters.length());
             password[i] = passwordCharacters.charAt(g);
         }

         return new String(password);

}

    public String theDepartment() {
        String []departmentSet = {"DEVELOPER","SALES","ACCOUNTING"};
        Random rnd = new Random();
        int random  = rnd.nextInt(departmentSet.length);
        return departmentSet[random];

    }


    public String getDepartment() {
        return department;
    }


    public void setDepartment(String department) {
        this.department = department;
    }


    public int getMailboxCapacity() {
        return mailboxCapacity;
    }


    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }



    public void changePassword(String password){
        this.password = password;
    }

    public String showInfo(){
        String companySuffix = "dmail.com";
        return firstname.toLowerCase() + lastname.toLowerCase() + "@" + companySuffix;
    }

    @Override
    public String toString() {
        return "Email{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                ", department='" + department + '\'' +
                ", mailboxCapacity=" + mailboxCapacity +
                ", email='" + email + '\'' +
                ", alternateEmail='" + alternateEmail + '\'' +
                '}';
    }
}
