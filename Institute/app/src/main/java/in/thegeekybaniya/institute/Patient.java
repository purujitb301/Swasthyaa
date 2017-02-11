package in.thegeekybaniya.institute;

import java.util.ArrayList;

/**
 * Created by Kabir on 11/02/2017.
 */

class Patient {
    String name,dob,email;

    ArrayList<String> pres;

    public Patient() {
    }

    public Patient(String name, String dob, String email,  ArrayList<String> pres) {
        this.name = name;
        this.dob = dob;
        this.email = email;



        this.pres = pres;
    }
}
