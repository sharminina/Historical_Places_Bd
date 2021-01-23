package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class LalmaiMOinamoti extends ActionBarActivity {
TextView show9;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lalmai_moinamoti);
        show9=(TextView)findViewById(R.id.moina);
        if (flage == 1) {
            CallData();
            SQLiteDatabase db2 = openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor = db2.rawQuery("SELECT * FROM MOILL", null);

            if (cursor.moveToFirst()) {
                do {

                    show9.setText(cursor.getString(cursor.getColumnIndex("LMM")));
                    show9.setTextColor(Color.parseColor("#fd079c"));

                } while (cursor.moveToNext());
            }
            db2.close();


        }
    }
    public void CallData() {
        flage = 0;

        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS MOILL");
        db.execSQL("CREATE TABLE IF NOT EXISTS MOILL(LMM VARCHAR);");
        db.execSQL("INSERT INTO MOILL VALUES('Mainamati (Bengali: ময়নামতি Môenamoti) is an isolated low, dimpled range of hills, dotted -with more than 50\n ancient Buddhist settlements of the 8th to 12th century A.D. It is extended through the centre\n of the district of Comilla. Mainamati is located almost 8 miles from the town of Comilla, Bangladesh. It is the home\n of one of the most important Buddhist archaeological sites in the region.Mainamati is named for the Candra queen\n of the same name, mother of the Govindachandra.')");
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
