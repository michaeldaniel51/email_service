package com.dannycodes.email.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Random;


@Data
@Entity
public class Email {


    @Id
    private int emailId;
    private String firstname;
    private String lastname;
    private String password;
    private String department;
    private int mailboxCapacity = 500;
    private String email;
    private String alternateEmail = "anybody@dmail.com";
    private int messageId;



    public String randomPassword(int lenght) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@#$%^&*";
        char[] password = new char[lenght];
        for (int i = 0; i < lenght; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);

    }

    public String password() {

        int passwordLength = 12;
        String passwordCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@#$%^&*";
         char[] password = new char[passwordLength];
         for (int i = 0; i<passwordLength; i++){
             Random ran = new Random();
             int resolvedpassword = ran.nextInt(passwordCharacters.length());
             password[i] = passwordCharacters.charAt(resolvedpassword);
         }

         return new String(password);

}

    public String theDepartment() {
        String []departmentSet = {"DEVELOPER","SALES","ACCOUNTING"};
        Random rnd = new Random();
        int random  = rnd.nextInt(departmentSet.length);
        return departmentSet[random];

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
