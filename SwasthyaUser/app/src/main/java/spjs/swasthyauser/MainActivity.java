package spjs.swasthyauser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    EditText aadharNumber = (EditText)findViewById(R.id.editText);
    Button verify = (Button)findViewById(R.id.button);

    String aadharString = aadharNumber.getText().toString();

    if(aadharString.length() != 12) {
        Toast toast = Toast.makeText(this, "Please enter a valid 12-digit aadhar number", Toast.LENGTH_SHORT);
        toast.show();
        break;
    } else {
        Intent intent = new Intent(this, onAadharEntered.class);
        startActivity(intent);
    }
}
}
