package historical.com.example.ahmed.historicalplacesbd;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class Sylhetdiv extends ActionBarActivity {
ImageButton jaint,biju,shaj,shap,m12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sylhetdiv);
        jaint=(ImageButton)findViewById(R.id.jointa);
        biju=(ImageButton)findViewById(R.id.bijoy_king);
        shaj=(ImageButton)findViewById(R.id.shah_j);
        shap=(ImageButton)findViewById(R.id.shah_p);
      m12=(ImageButton)findViewById(R.id.gotomain12);
        jaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Sylhetdiv.this,DatabaseActivity.class);
                intent.putExtra("Name","Stone Monument of Jaintapur");
                startActivity(intent);
            }
        });
        biju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Sylhetdiv.this,BijoysinghPalace.class);
                startActivity(intent);
            }
        });
        shaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Sylhetdiv.this,ShahJalal.class);
                startActivity(intent);
            }
        });
        shap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Sylhetdiv.this,ShahPoran.class);
                startActivity(intent);
            }
        });
       m12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Sylhetdiv.this,MainActivity.class);
                startActivity(intent);
            }
        });
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
