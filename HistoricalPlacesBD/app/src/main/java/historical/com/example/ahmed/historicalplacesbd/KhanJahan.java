package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class KhanJahan extends ActionBarActivity {
TextView show7;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khan_jahan);
        show7 = (TextView) findViewById(R.id.khan_ali);
        if (flage == 1) {
            CallData();
            SQLiteDatabase db2 = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
            final Cursor cursor = db2.rawQuery("SELECT * FROM KHNJA", null);

            if (cursor.moveToFirst()) {
                do {

                    show7.setText(cursor.getString(cursor.getColumnIndex("KHN")));
                    show7.setTextColor(Color.parseColor("#000000"));

                } while (cursor.moveToNext());
            }
            db2.close();
        }
    }

    public void CallData() {
        flage = 0;

        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS KHNJA");
        db.execSQL("CREATE TABLE IF NOT EXISTS KHNJA(KHN VARCHAR);");
        db.execSQL("INSERT INTO KHNJA VALUES('It marks te tomb of Great Emperor Khan Jahan Ali in Bagerhat district of Baangladesh.\n An inscription on the tombstone records the death of Khan Jahan on 27 Zilhajj 863 AH \n(25 October 1459 AD)Apparently, Khan Jahan had probably constructed the building before his death.\n stands on a high artificial mound on the northern bank of the so-called Thakurdighi and is surrounded by an\n outer wall of 67.1 m from east to west and 64.7m from north to south.It is popularly called the dargah complex\n of khan jahan. The Tomb of Khan Jahan, measuring 13.7m a side externally and 9.1m internally,\n is a brick-built square building and forms the nucleus of the complex. The four exterior angles\nof the building are emphasised with solid circular towers.')");
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
