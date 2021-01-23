package historical.com.example.ahmed.historicalplacesbd;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class Rangpurdiv extends ActionBarActivity {
ImageButton lione,bibi,taj,kanti,noye,baro,m11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rangpurdiv);
        //lione=(ImageButton)findViewById(R.id.lion);
        bibi=(ImageButton)findViewById(R.id.bb);
        taj=(ImageButton)findViewById(R.id.tajh);
        kanti=(ImageButton)findViewById(R.id.kanta);
        noye=(ImageButton)findViewById(R.id.noya);
        baro=(ImageButton)findViewById(R.id.door);
        m11=(ImageButton)findViewById(R.id.gotomain11);

        bibi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Rangpurdiv.this,Bibichini.class);
                startActivity(intent);
            }
        });
        taj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Rangpurdiv.this,TajhatPalace.class);
                startActivity(intent);
            }
        });
        kanti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Rangpurdiv.this,Kantejew.class);
                startActivity(intent);
            }
        });
        noye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Rangpurdiv.this,Nayabad.class);
                startActivity(intent);
            }
        });
        baro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Rangpurdiv.this,BaroDurai.class);
                startActivity(intent);
            }
        });
       m11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Rangpurdiv.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rangpurdiv, menu);
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
