package getstarted.bikes.rol.com.rolbikes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button b1,t1;
    EditText e1,e2;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        e1= (EditText) findViewById(R.id.email);
        e2= (EditText) findViewById(R.id.password);
        b1= (Button) findViewById(R.id.signin);
        t1= (Button) findViewById(R.id.tv_sign_up_button);

               b1.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {


                       if(e1.getText().toString().equals("admin") && e2.getText().toString().equals("admin"))
                       {
                           Intent i = new Intent(Login.this, Rent_or_lend.class);
                           startActivity(i);

                       }
                       else if(e1.getText().toString().length()==0 || e2.getText().toString().length()==0)

                       {
                           Toast.makeText(Login.this,"Fill Complete Details!!!", Toast.LENGTH_SHORT).show();

                       }

                       else
                       {
                           Toast.makeText(Login.this,"Wrong Credentials!!!Try Again", Toast.LENGTH_SHORT).show();

                       }
                   }
               });

   t1.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           Intent i = new Intent(Login.this, Register.class);
           startActivity(i);

       }
   });
    }
}
