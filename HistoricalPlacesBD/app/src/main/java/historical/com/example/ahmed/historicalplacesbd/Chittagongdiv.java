package historical.com.example.ahmed.historicalplacesbd;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class Chittagongdiv extends ActionBarActivity {
    ImageButton nxt_two, atiamos, sujamos, ethono, sec, adina, bij, m2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chittagongdiv);
        nxt_two = (ImageButton) findViewById(R.id.chtnxtone);
        atiamos = (ImageButton) findViewById(R.id.atia);
        sujamos = (ImageButton) findViewById(R.id.suja);
        ethono = (ImageButton) findViewById(R.id.ethon);
        sec = (ImageButton) findViewById(R.id.second);
        adina = (ImageButton) findViewById(R.id.temple_adi);
        m2 = (ImageButton) findViewById(R.id.gotomain1);
        bij = (ImageButton) findViewById(R.id.bijuy);
        nxt_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chittagongdiv.this, chittadiv_two.class);
                startActivity(intent);
            }
        });
        atiamos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chittagongdiv.this, AtiaMosque.class);
                startActivity(intent);
            }
        });
        sujamos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chittagongdiv.this, SujaMosque.class);
                startActivity(intent);
            }
        });
        ethono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chittagongdiv.this, DatabaseActivity.class);
                intent.putExtra("Name", "Ethnological Museum");
                startActivity(intent);
            }
        });
        sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chittagongdiv.this, SecondWorldWar.class);
                startActivity(intent);
            }
        });
        adina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chittagongdiv.this, AdinathTemple.class);
                startActivity(intent);
            }
        });
        bij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chittagongdiv.this, BijoySinghDighi.class);
                startActivity(intent);

            }
        });
        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chittagongdiv.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}





