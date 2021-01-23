package historical.com.example.ahmed.historicalplacesbd;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


public class Dhakadiv extends ActionBarActivity {
ImageButton nxt,son,lal,armen,car,sha,sri,m3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhakadiv);
        nxt=(ImageButton)findViewById(R.id.next);
        son=(ImageButton)findViewById(R.id.np);
         lal=(ImageButton)findViewById(R.id.lalba);
        armen=(ImageButton)findViewById(R.id.arm);
        car=(ImageButton)findViewById(R.id.carzn);
        sha=(ImageButton)findViewById(R.id.shahid);
        sri=(ImageButton)findViewById(R.id.martyr);
       m3=(ImageButton)findViewById(R.id.gotomain2);

armen.setOnClickListener(new View.OnClickListener(){
    public  void onClick(View v){
        Intent intent=new Intent(Dhakadiv.this,DatabaseActivity.class);
        intent.putExtra("Name","Armenium Church");
        startActivity(intent);

    }
});
      son.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dhakadiv.this,DatabaseActivity.class);
               intent.putExtra("Name","National Parliament House");
                startActivity(intent);
            }
        });
        lal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dhakadiv.this,DatabaseActivity.class);
                intent.putExtra("Name","Lalbagh Kella");

                startActivity(intent);
            }
        });
        armen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Dhakadiv.this,DatabaseActivity.class);
                intent.putExtra("Name","Armenium Church");
                startActivity(intent);


            }
        });
        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Dhakadiv.this,DatabaseActivity.class);
                intent.putExtra("Name","Curzon Hall");
                startActivity(intent);

            }
        });

        sha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dhakadiv.this,DatabaseActivity.class);
                intent.putExtra("Name","Shahid Minar");
                startActivity(intent);
            }
        });
        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dhakadiv.this,Dhakadivtwo.class);

                startActivity(intent);
            }
        });

        sri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dhakadiv.this,DatabaseActivity.class);
                intent.putExtra("Name","National Martyr Memorial");
                startActivity(intent);
            }
        });
        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dhakadiv.this,MainActivity.class);
               startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dhakadiv, menu);
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
