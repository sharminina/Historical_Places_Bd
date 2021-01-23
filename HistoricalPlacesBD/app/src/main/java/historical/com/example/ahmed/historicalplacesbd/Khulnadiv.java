package historical.com.example.ahmed.historicalplacesbd;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class Khulnadiv extends ActionBarActivity {
ImageButton nxtpage,khan_ja,lalanshah,modhusu,mujib_n,m8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khulnadiv);
        nxtpage=(ImageButton)findViewById(R.id.khulna_one);
        khan_ja=(ImageButton)findViewById(R.id.khaja);
        lalanshah=(ImageButton)findViewById(R.id.lalan);
        modhusu=(ImageButton)findViewById(R.id.madhu);
        mujib_n=(ImageButton)findViewById(R.id.mujib);
       m8=(ImageButton)findViewById(R.id.gotomain8);
        nxtpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Khulnadiv.this,khulnadiv_two.class);
                startActivity(intent);
            }
        });
        khan_ja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Khulnadiv.this,KhanJahan.class);
                startActivity(intent);
            }
        });
        lalanshah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Khulnadiv.this,LalonMajar.class);
                startActivity(intent);
            }
        });
        modhusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Khulnadiv.this,MichaelModhu.class);
                startActivity(intent);
            }
        });
        mujib_n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Khulnadiv.this,DatabaseActivity.class);
                intent.putExtra("Name","Mujibnogor Memorial");
                startActivity(intent);
            }
        });
       m8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Khulnadiv.this,MainActivity.class);

                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_khulnadiv, menu);
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
