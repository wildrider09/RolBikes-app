package getstarted.bikes.rol.com.rolbikes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    public static String mod;

    ListView mainListView;
    private ArrayAdapter<String> listAdapter ;
    String bike_name="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainListView = (ListView) findViewById( R.id.mainListView );
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference bikeDataRef = database.getReference("Bikes");


        String[] bikes = new String[] { };
        ArrayList<String> planetList = new ArrayList<String>();
        planetList.addAll( Arrays.asList(bikes) );

        listAdapter = new ArrayAdapter<String>(this, R.layout.bikes_list, planetList);

        bikeDataRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnap:dataSnapshot.getChildren()) {
                    bikeDetailsClass hjy = postSnap.getValue(bikeDetailsClass.class);
                    bike_name = hjy.getModel();
                    listAdapter.add(bike_name);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mainListView.setAdapter( listAdapter );

        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(),""+adapterView.getItemAtPosition(i).toString(),Toast.LENGTH_SHORT).show();
                Intent ii = new Intent(MainActivity.this, LenderDetails.class);
                ii.putExtra("model",adapterView.getItemAtPosition(i).toString());
                startActivity(ii);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
