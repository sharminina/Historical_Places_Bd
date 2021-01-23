package historical.com.example.ahmed.historicalplacesbd;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class rajdivthree extends ActionBarActivity {
ImageButton sultan,makhdu,balkh,m8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rajdivthree);

        makhdu=(ImageButton)findViewById(R.id.makhdum);
        balkh=(ImageButton)findViewById(R.id.balki);
        m8=(ImageButton)findViewById(R.id.gotomain8);

        makhdu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(rajdivthree.this,DatabaseActivity.class);
                intent.putExtra("Name","Shah Makhdum Mazar");
                startActivity(intent);
            }
        });
        balkh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(rajdivthree.this,Balkhi.class);
                startActivity(intent);
            }
        });
      m8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(rajdivthree.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rajdivthree, menu);
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
