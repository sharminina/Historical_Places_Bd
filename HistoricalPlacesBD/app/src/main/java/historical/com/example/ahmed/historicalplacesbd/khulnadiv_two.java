package historical.com.example.ahmed.historicalplacesbd;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class khulnadiv_two extends ActionBarActivity {
ImageButton kuthi,sixt,shona,sitar,tetu,m7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khulnadiv_two);
        kuthi=(ImageButton)findViewById(R.id.shilai);
        sixt=(ImageButton)findViewById(R.id.sixty_dom);
        shona=(ImageButton)findViewById(R.id.sona_m);
        sitar=(ImageButton)findViewById(R.id.sita);
        tetu=(ImageButton)findViewById(R.id.tet);
        m7=(ImageButton)findViewById(R.id.gotomain7);
        kuthi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(khulnadiv_two.this,RabindraKuthibari.class);
                        startActivity(intent); }
        });
        sixt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(khulnadiv_two.this,ShaitGombuj.class);
                startActivity(intent);
            }
        });
        shona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(khulnadiv_two.this,SonaMosque.class);
                startActivity(intent);
            }
        });
        sitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(khulnadiv_two.this,DatabaseActivity.class);
                intent.putExtra("Name","Sitaram Palace");
                startActivity(intent);
            }
        });
        tetu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(khulnadiv_two.this,TetuliaJame.class);
                startActivity(intent);
            }
        });
       m7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(khulnadiv_two.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_khulnadiv_two, menu);
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
