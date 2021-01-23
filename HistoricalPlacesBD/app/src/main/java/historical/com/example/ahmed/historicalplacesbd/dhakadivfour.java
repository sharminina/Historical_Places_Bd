package historical.com.example.ahmed.historicalplacesbd;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class dhakadivfour extends ActionBarActivity {
ImageButton next_five,shek,jangal,shah,m4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhakadivfour);
        next_five=(ImageButton)findViewById(R.id.nxtpagefive);
        shek=(ImageButton)findViewById(R.id.muzibur);
        jangal=(ImageButton)findViewById(R.id.jangolbari);
        shah=(ImageButton)findViewById(R.id.shah_mahmud);
        m4=(ImageButton)findViewById(R.id.gotomain4);

        shek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(dhakadivfour.this,DatabaseActivity.class);
                intent.putExtra("Name","Sheikh Mujibur Rahmans Tomb");
                startActivity(intent);
            }
        });
        jangal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(dhakadivfour.this,JangalbariFort.class);
                startActivity(intent);
            }
        });
        shah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(dhakadivfour.this,ShahMahmudMosque.class);
                startActivity(intent);
            }
        });
        m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(dhakadivfour.this,MainActivity.class);
                startActivity(intent);
            }
        });



        next_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(dhakadivfour.this,dhakadiv_five.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dhakadivfour, menu);
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
