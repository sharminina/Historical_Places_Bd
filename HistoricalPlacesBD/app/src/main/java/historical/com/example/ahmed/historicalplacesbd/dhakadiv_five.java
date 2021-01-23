package historical.com.example.ahmed.historicalplacesbd;

import android.content.Intent;
import android.media.Image;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class dhakadiv_five extends ActionBarActivity {
ImageButton my_lodge,war,dhnbari,tar,dhksh,m4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhakadiv_five);
        my_lodge=(ImageButton)findViewById(R.id.shashi_lodge);
        dhnbari=(ImageButton)findViewById(R.id.dhanbari);
        war=(ImageButton)findViewById(R.id.war_bot);
        tar=(ImageButton)findViewById(R.id.star);
        dhksh=(ImageButton)findViewById(R.id.dhakesh);
        m4=(ImageButton)findViewById(R.id.gotomain3);
        my_lodge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(dhakadiv_five.this,ShashiLodge.class);
                        startActivity(intent);
            }
        });
        dhnbari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(dhakadiv_five.this,DhanbariMosque.class);
                startActivity(intent);
            }
        });

        war.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(dhakadiv_five.this,WariBoteshwar.class);
                startActivity(intent);
            }
        });
        tar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(dhakadiv_five.this,StarMosque.class);
                startActivity(intent);
            }
        });
        dhksh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(dhakadiv_five.this,DatabaseActivity.class);
                intent.putExtra("Name","Dhakeshwari Temple");
                startActivity(intent);
            }
        });
        m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(dhakadiv_five.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dhakadiv_five, menu);
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
