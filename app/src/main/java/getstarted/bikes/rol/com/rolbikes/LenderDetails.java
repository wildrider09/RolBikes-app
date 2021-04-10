package getstarted.bikes.rol.com.rolbikes;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LenderDetails extends AppCompatActivity {

    private String pho;

    TextView details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lender_details);
        details = (TextView) findViewById(R.id.textView4);

        Intent iin = getIntent();
        Bundle b = iin.getExtras();
        if (b != null) {
            final String j = (String) b.get("model");
            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            final DatabaseReference bikeDataRef = database.getReference("Bikes").child(j);
            bikeDataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    bikeDetailsClass hjy = dataSnapshot.getValue(bikeDetailsClass.class);
                    pho = hjy.getNumber();
                    details.setText("Bike model - " +j+ "\n\n" + "Owner's name - " + hjy.getName() + "\n\n" +
                            "Price - ₹ " + hjy.getPrice() + " per hour\n\n" +
                            "Helmet Availability - " + hjy.isVno() + "\n\n" +
                            "Bike Availablity - " + hjy.isAvailability() + "\n\n");
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }

    }

    public void contact(View view) {
//        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel" + pho));
//        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//            return;
//        }
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", pho, null)));
//        startActivity(intent);
    }
}
