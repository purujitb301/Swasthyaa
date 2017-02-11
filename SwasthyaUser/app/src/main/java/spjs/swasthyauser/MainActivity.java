package spjs.swasthyauser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button verify;
    EditText aadhar;
    String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verify = (Button)findViewById(R.id.button);
        aadhar = (EditText)findViewById(R.id.editText);
        a = aadhar.getText().toString();

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(a.length() == 12)) {

                    Toast toast = Toast.makeText(MainActivity.this, "Aadhar Card verification successful", Toast.LENGTH_SHORT);
                    toast.show();
                    Intent intent = new Intent(MainActivity.this, onAadharEntered.class);
                    startActivity(intent);
                }
                else  {
                    Toast toast = Toast.makeText(MainActivity.this, "Please enter a valid 12-digit aadhar number", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

    }

}


