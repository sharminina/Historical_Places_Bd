package historical.com.example.ahmed.historicalplacesbd;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class Rajshahi extends ActionBarActivity {


        ImageButton next_page,ch_s,moha_s,v_vih,gar_pi,utt,rani_v,m9;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_rajshahi);
            next_page=(ImageButton)findViewById(R.id.rajone);
            ch_s=(ImageButton)findViewById(R.id.golden);
            moha_s=(ImageButton)findViewById(R.id.maha);
            v_vih=(ImageButton)findViewById(R.id.vasu);
            gar_pi=(ImageButton)findViewById(R.id.garud);
            utt=(ImageButton)findViewById(R.id.gono);
            rani_v=(ImageButton)findViewById(R.id.queen);
            m9=(ImageButton)findViewById(R.id.gotomain9);
            ch_s.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(Rajshahi.this,DatabaseActivity.class);
                    intent.putExtra("Name","Choto Sona Mosque");
                    startActivity(intent);

                }
            });
            moha_s.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(Rajshahi.this,Mahasthangarh.class);
                    startActivity(intent);
                }
            });
            v_vih.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(Rajshahi.this,VasuVihar.class);
                    startActivity(intent);
                }
            });
            gar_pi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(Rajshahi.this,GarudPillar.class);
                    startActivity(intent);
                }
            });
            utt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(Rajshahi.this,DatabaseActivity.class);
                    intent.putExtra("Name","Uttora Gononvobon");
                    startActivity(intent);
                }
            });
            next_page.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(Rajshahi.this,rajshahidiv_two.class);
                    startActivity(intent);
                }
            });
            rani_v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(Rajshahi.this,DatabaseActivity.class);
                    intent.putExtra("Name","Rani Vobani Palace");
                    startActivity(intent);
                }
            });
           m9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(Rajshahi.this,MainActivity.class);
                   startActivity(intent);
                }
            });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rajshahi, menu);
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
