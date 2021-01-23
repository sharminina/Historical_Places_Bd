package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class AtiaMosque extends ActionBarActivity {
TextView at;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atia_mosque);
        at=(TextView)findViewById(R.id.atia);
        if (flage == 1) {
            CallData();
            SQLiteDatabase db2 = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
            final Cursor cursor = db2.rawQuery("SELECT * FROM ATIA", null);

            if (cursor.moveToFirst()) {
                do {

                    at.setText(cursor.getString(cursor.getColumnIndex("ATI")));
                    at.setTextColor(Color.parseColor("#000000"));

                } while (cursor.moveToNext());
            }
            db2.close();


        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_atia_mosque, menu);
        return true;
    }
    public void CallData() {
        flage = 0;

        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS ATIA");
        db.execSQL("CREATE TABLE IF NOT EXISTS ATIA(ATI VARCHAR);");
        db.execSQL("INSERT INTO ATIA VALUES('Atia(আটিয়া), a historical four century years of old mosque is located at the\nDelduar Thana(দেলদুয়ার থানা) of Tangail district(টাঙ্গাইল জেলা) of Bangladesh(বাংলাদেশ).The village name is Atia(আটিয়া) and\nthe mosque is known as Atia Jame Moshjid(আটিয়া জমে মসজিদ).\nThis mosque is around 6 kilometers from the Tangail(টাঙ্গাইল) town.There is a small river\nflowing near the mosque, name is Louhojong Nodi(লৌহজং নদী)\n  The mosque is a small one and measure around 18m by 12m.')");
        db.close();
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
