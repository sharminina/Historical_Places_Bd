package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class BajraShahi extends ActionBarActivity {
TextView bj;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bajra_shahi);
        bj=(TextView)findViewById(R.id.baj_Sh);
        if (flage == 1) {
            CallData();
            SQLiteDatabase db2 = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
            final Cursor cursor = db2.rawQuery("SELECT * FROM BAJRA", null);

            if (cursor.moveToFirst()) {
                do {

                    bj.setText(cursor.getString(cursor.getColumnIndex("BAJ")));
                    bj.setTextColor(Color.parseColor("#ffaa00"));

                } while (cursor.moveToNext());
            }
            db2.close();


        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bajra_shahi, menu);
        return true;
    }
    public void CallData() {
        flage = 0;

        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS BAJRA");
        db.execSQL("CREATE TABLE IF NOT EXISTS BAJRA(BAJ VARCHAR);");
        db.execSQL("INSERT INTO BAJRA VALUES('Bajra Shahi Mosque  is located on the northern bank of a large pond containing a\nmasonry ghat in the village of Bajra under Begumganj thana of Noakhali district.\nThe mosque, according to an inscription fixed over the central doorway,was erected by one Aman Allah in 1741-42 AD\nduring the reign of the Mughal emperor Muhammad Shah. repaired in the years between 1318 to 1335\nBS by the Bajra Zamindars Khan Bahadur Ali Ahmad and Khan Bahadur Mujir Uddin Ahmad.')");
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
