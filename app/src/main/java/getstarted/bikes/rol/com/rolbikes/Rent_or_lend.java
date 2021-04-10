package getstarted.bikes.rol.com.rolbikes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Rent_or_lend extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_or_lend);

    }

    public void lend_bike(View view){
        Intent i = new Intent(getApplicationContext(), LendBike.class);
        startActivity(i);
    }
    public void rent_bike(View view){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
}
