package getstarted.bikes.rol.com.rolbikes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText e1, e2, e3, e4, e5;
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        e3 = (EditText) findViewById(R.id.e3);
        e4 = (EditText) findViewById(R.id.e4);
        e5 = (EditText) findViewById(R.id.e5);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                  if(e1.getText().toString().length()==0 || e2.getText().toString().length()==0||e3.getText().toString().length()==0||e4.getText().toString().length()==0||e5.getText().toString().length()==0)

                {
                    Toast.makeText(Register.this,"Fill Complete Details!!!", Toast.LENGTH_SHORT).show();

                }
                else
                  {
                      Toast.makeText(Register.this,"Details submitted!!!\nWait for Login till verification is complete", Toast.LENGTH_SHORT).show();

                      Intent i = new Intent(Register.this, Login.class);
                      startActivity(i);
                  }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Register.this, Login.class);
                startActivity(i);

            }
        });

    }
}
