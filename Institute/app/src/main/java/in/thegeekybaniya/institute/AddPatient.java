package in.thegeekybaniya.institute;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AddPatient extends AppCompatActivity {

    Button btnFinish, btnCheck, btnAddMed;
    EditText etAadhar, etMed, etFrequency;
    DatabaseReference mrootRef= FirebaseDatabase.getInstance().getReference();
    DatabaseReference mpatientRef= mrootRef.child("patients");
    DatabaseReference mpresRef=mrootRef.child("prescriptions");

    Patient patient;

    Prescription prescription;

ArrayList<Medicine> md;

    ArrayList<String>pres;

    private static final String TAG = "AddPatient";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);

        btnFinish= (Button) findViewById(R.id.btnFinish);
        btnAddMed= (Button) findViewById(R.id.btnAddMed);
        btnCheck= (Button) findViewById(R.id.btnCheck);
        etAadhar= (EditText) findViewById(R.id.etAadhar);
        etMed= (EditText) findViewById(R.id.editText4);
        etFrequency= (EditText) findViewById(R.id.editText5);

        md= new ArrayList<>();
        pres=new ArrayList<>();








        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aadhar= etAadhar.getText().toString();
                md.add(new Medicine(etMed.getText().toString(), etFrequency.getText().toString()));

                String uid1;


                prescription=new Prescription("hello", "hello", md);
               String uid= mpresRef.push().getKey();

                int l= uid.length();

                char a= uid.charAt(l-1);

                 uid1 = new String();

                StringBuffer outputBuffer = new StringBuffer(l-1);
                for (int i = 0; i < l-1; i++){
                    outputBuffer.append(uid.charAt(i));
                }


                Log.d(TAG, "onClick: ");
                outputBuffer.append(++a);


                uid1=outputBuffer.toString();






                mpresRef.push().setValue(prescription);

                Log.d(TAG, "onClick: "+ uid);

                pres.add(uid1);

                patient= new Patient("Gagan", "12/9/98", "GKU@gmail.com",pres );


                mpatientRef.child(aadhar).setValue(patient);






            finish();
            }
        });

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });


    }
}
