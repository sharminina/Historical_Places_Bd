package historical.com.example.ahmed.historicalplacesbd;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class Dhakadivtwo extends ActionBarActivity {
ImageButton nxt_one,ahs,lib,son,bol,idr,m5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhakadivtwo);
        nxt_one=(ImageButton)findViewById(R.id.nextpage_two);
        ahs=(ImageButton)findViewById(R.id.ahsan);
        lib=(ImageButton)findViewById(R.id.martyrmusi);
        son=(ImageButton)findViewById(R.id.sonargaon);
        bol=(ImageButton)findViewById(R.id.boldha);
       idr=(ImageButton)findViewById(R.id.idrak);
      m5=(ImageButton)findViewById(R.id.gotomain5);
        ahs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dhakadivtwo.this,AhsanMonzill.class);
                startActivity(intent);
            }
        });
        lib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dhakadivtwo.this,MuktijudhoJadughor.class);
                startActivity(intent);
            }
        });
        son.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dhakadivtwo.this,Sonargaon.class);
                startActivity(intent);
            }
        });
        bol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dhakadivtwo.this,BoldhaGarden.class);
                startActivity(intent);
            }
        });
        idr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dhakadivtwo.this,IdrakpurFort.class);
                startActivity(intent);
            }
        });
        nxt_one.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Intent intent = new Intent(Dhakadivtwo.this, dhakathree.class);
                                           startActivity(intent);
                                       }
                                   }


        );
       m5.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Intent intent = new Intent(Dhakadivtwo.this, MainActivity.class);
                                           startActivity(intent);
                                       }
                                   }


        );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dhakadivtwo, menu);
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
