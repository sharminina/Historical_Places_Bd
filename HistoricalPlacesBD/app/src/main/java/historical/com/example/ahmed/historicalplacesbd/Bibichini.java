package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;



public class Bibichini extends ActionBarActivity {
TextView show_bib;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bibichini);
        show_bib=(TextView)findViewById(R.id.bibi_ch);
        if (flage == 1) {
            CallData();
            SQLiteDatabase db2 = openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor = db2.rawQuery("SELECT * FROM CHINI",null);

            if (cursor.moveToFirst()) {
                do {

                    show_bib.setText(cursor.getString(cursor.getColumnIndex("BIBI")));
                    show_bib.setTextColor(Color.parseColor("#ffaa00"));

                } while (cursor.moveToNext());
            }
            db2.close();


        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bibichini, menu);
        return true;
    }
    public void CallData() {
        flage = 0;

        SQLiteDatabase db = openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
        db.execSQL("DROP TABLE IF EXISTS CHINI");
        db.execSQL("CREATE TABLE IF NOT EXISTS CHINI(BIBI VARCHAR);");
        db.execSQL("INSERT INTO CHINI VALUES('Bibichini Shahi Mosque was built at middle Sultane period in the 15th century the time\nof Ahmad Shah, Jalal al-Din’s son. Bibichini Shahi masjid is located at\nbetagi in Bargun District.Shaw Neyamata was constructed this mosques in 1659\nThe village and the mosque named after the name of his daughter hayache bibicini.')");
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
