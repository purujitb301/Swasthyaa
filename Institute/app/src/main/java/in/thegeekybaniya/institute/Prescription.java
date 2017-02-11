package in.thegeekybaniya.institute;

import java.util.ArrayList;

/**
 * Created by Kabir on 11/02/2017.
 */

public class Prescription {


    String url, nextAppointment;
    ArrayList<Medicine> meds;


    public Prescription(String url, String nextAppointment, ArrayList<Medicine> meds) {
        this.url = url;
        this.nextAppointment = nextAppointment;
        this.meds = meds;
    }

    public Prescription() {
    }
}
