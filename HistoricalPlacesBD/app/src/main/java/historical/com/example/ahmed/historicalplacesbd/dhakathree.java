package historical.com.example.ahmed.historicalplacesbd;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class dhakathree extends ActionBarActivity {
ImageButton nxt_three,shoh,ray,budhi,jasi,saat,digh,m6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhakathree);
        nxt_three=(ImageButton)findViewById(R.id.nextpage_four);
        shoh=(ImageButton)findViewById(R.id.uddan);
        ray=(ImageButton)findViewById(R.id.rayer);
       budhi=(ImageButton)findViewById(R.id.budhijibi);
        jasi=(ImageButton)findViewById(R.id.jasimuddin);
        saat=(ImageButton)findViewById(R.id.sat);
      digh=(ImageButton)findViewById(R.id.dighirpar);
        m6=(ImageButton)findViewById(R.id.gotomain6);
        nxt_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(dhakathree.this,dhakadivfour.class);
                startActivity(intent);

            }
        });
        shoh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ine=new Intent(dhakathree.this,Shohrowardi.class);
                startActivity(ine);
            }
        });
        ray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(dhakathree.this,DatabaseActivity.class);
                intent.putExtra("Name","Rayer Bazar Bodhdhovumi");
                startActivity(intent);
            }
        });
        budhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(dhakathree.this,DatabaseActivity.class);
                intent.putExtra("Name","Shahid Buddhijibi Graveyard");
                startActivity(intent);
            }
        });
        jasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(dhakathree.this,Josimuddin.class);
                startActivity(intent);
            }
        });
        saat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(dhakathree.this,DatabaseActivity.class);
                intent.putExtra("Name","Shat Moshjid");
                startActivity(intent);
            }
        });
        digh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(dhakathree.this,DighirparMosque.class);
                startActivity(intent);
            }
        });
       m6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(dhakathree.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dhakathree, menu);
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
