package getstarted.bikes.rol.com.rolbikes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LendBike extends AppCompatActivity {
    private EditText name,model,price,Vno;
    private Switch helmet,avail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lend_bike);
        name=(EditText)findViewById(R.id.editText);
        model=(EditText)findViewById(R.id.editText2);
        Vno=(EditText)findViewById(R.id.editText3);
        price=(EditText)findViewById(R.id.editText4);
        helmet=(Switch)findViewById(R.id.switch1);
        avail=(Switch)findViewById(R.id.switch2);
    }

    public void lend_confirm(View view){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference bikeDataRef = database.getReference("Bikes").child(model.getText().toString());
        final bikeDetailsClass bike = new bikeDetailsClass();
        if(!name.getText().toString().isEmpty() || !model.getText().toString().isEmpty() || !Vno.getText().toString().isEmpty()
                || !price.getText().toString().isEmpty()) {
            bike.setName(name.getText().toString());
            bike.setModel(model.getText().toString());
            bike.setNumber(Vno.getText().toString());
            bike.setPrice(price.getText().toString());

            if(helmet.isChecked())
            bike.setVno(true);
            else
            bike.setVno(false);

            if(avail.isChecked())
            bike.setAvailability(true);
            else
            bike.setAvailability(false);

            bikeDataRef.setValue(bike);
        }
        else {
            Toast.makeText(getApplicationContext(),"Check missing ATTRIBUTES",Toast.LENGTH_SHORT).show();

        }
        Toast.makeText(getApplicationContext(),"Your bike is now visible to users !",Toast.LENGTH_SHORT).show();
        finish();
    }
}
