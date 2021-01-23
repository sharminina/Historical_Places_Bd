package historical.com.example.ahmed.historicalplacesbd;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class chittadiv_two extends ActionBarActivity {
ImageButton baj,gandh,lal,m1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chittadiv_two);
        baj=(ImageButton)findViewById(R.id.bajra);
        gandh=(ImageButton)findViewById(R.id.gandh);
        lal=(ImageButton)findViewById(R.id.lalmai);
        m1=(ImageButton)findViewById(R.id.gotomain);
        baj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(chittadiv_two.this,BajraShahi.class);
                startActivity(intent);
            }
        });
gandh.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(chittadiv_two.this,GandhiAshram.class);
        startActivity(intent);
    }
});
        lal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(chittadiv_two.this,LalmaiMOinamoti.class);
                startActivity(intent);
            }
        });

m1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(chittadiv_two.this,MainActivity.class);
        startActivity(intent);
    }
});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chittadiv_two, menu);
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
