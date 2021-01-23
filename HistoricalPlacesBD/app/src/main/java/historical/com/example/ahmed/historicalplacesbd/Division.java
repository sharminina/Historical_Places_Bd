package historical.com.example.ahmed.historicalplacesbd;

import android.content.Intent;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class Division extends ActionBarActivity {
ImageButton dhak,syl,raj,bar,chit,rang,khu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division);
        dhak = (ImageButton) findViewById(R.id.dhaka);
        syl = (ImageButton) findViewById(R.id.sylhet);
        raj = (ImageButton) findViewById(R.id.rajshahi);
        bar=(ImageButton)findViewById(R.id.barishal);
        khu=(ImageButton)findViewById(R.id.khulna);
        chit=(ImageButton)findViewById(R.id.chittagong);
        rang=(ImageButton)findViewById(R.id.rangpur);
        dhak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Division.this, Dhakadiv.class);
                startActivity(intent);
            }
        });
        syl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Division.this, Sylhetdiv.class);
                startActivity(intent);
            }
        });

        raj.setOnClickListener(new View.OnClickListener() {
public void onClick(View v) {
                Intent intent = new Intent(Division.this, Rajshahi.class);
                startActivity(intent);

            }
        });
        khu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Division.this,Khulnadiv.class);
                startActivity(intent);
            }
        });
        bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Division.this,Barishaldiv.class);
                startActivity(intent);
            }
        });
        chit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Division.this,Chittagongdiv.class);
                startActivity(intent);
            }
        });
        rang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent=new Intent(Division.this,Rangpurdiv.class);
                startActivity(intent);
            }
        });












    }


        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_division, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
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
