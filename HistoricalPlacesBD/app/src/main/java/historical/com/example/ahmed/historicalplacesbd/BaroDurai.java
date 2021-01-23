package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class BaroDurai extends ActionBarActivity {
TextView barod;
    int flage=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baro_durai);
        barod=(TextView)findViewById(R.id.baro_d);
        if (flage == 1) {
            CallData();
            SQLiteDatabase db2 = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
            final Cursor cursor = db2.rawQuery("SELECT * FROM BARODUAR", null);

            if (cursor.moveToFirst()) {
                do {

                    barod.setText(cursor.getString(cursor.getColumnIndex("BARD")));
                    barod.setTextColor(Color.parseColor("#ffaa00"));

                } while (cursor.moveToNext());
            }
            db2.close();


        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_baro_durai, menu);
        return true;
    }
    public void CallData() {
        flage = 0;

        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS BARODUAR");
        db.execSQL("CREATE TABLE IF NOT EXISTS BARODUAR(BARD VARCHAR);");
        db.execSQL("INSERT INTO BARODUAR VALUES('Baraduari Mosque or Barasona Masjid, Maldah,WB,(ad 1526)with the arcaded aisle of its\ncorridor,  this mosque is indeed the most impressive building of gour,\nbuilt by sultan nasrat shah.it is called baradwari, a building with twelve doors but has only 11 openings.')");
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
