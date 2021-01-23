package historical.com.example.ahmed.historicalplacesbd;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class rajshahidiv_two extends ActionBarActivity {
ImageButton second_page,bagh,behul,chat,ell,m10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rajshahidiv_two);
        second_page=(ImageButton)findViewById(R.id.rajtwo);
        bagh=(ImageButton)findViewById(R.id.bagha);
        behul=(ImageButton)findViewById(R.id.behula);
        chat=(ImageButton)findViewById(R.id.chat_m);
        ell=(ImageButton)findViewById(R.id.ellinor);
        m10=(ImageButton)findViewById(R.id.gotomain10);
        bagh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(rajshahidiv_two.this,Bagha.class);
                startActivity(intent);
            }
        });
        behul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(rajshahidiv_two.this,Behula.class);
                startActivity(intent);
            }
        });
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(rajshahidiv_two.this,DatabaseActivity.class);
                intent.putExtra("Name","Chatmohor Shahi Mosque");
                startActivity(intent);
            }
        });
        ell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(rajshahidiv_two.this,DatabaseActivity.class);
                intent.putExtra("Name","Elliot Bridge");
                startActivity(intent);
            }
        });
        second_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(rajshahidiv_two.this,rajdivthree.class);
                startActivity(intent);
            }
        });
        m10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(rajshahidiv_two.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rajshahidiv_two, menu);
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
