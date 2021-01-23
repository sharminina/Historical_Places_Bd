package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.MenuItem;
import android.widget.TextView;


public class Balkhi extends ActionBarActivity {
    TextView blk;
    int flage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balkhi);
        blk=(TextView)findViewById(R.id.balkhi);
        if (flage == 1) {
            CallData();
            SQLiteDatabase db2 = openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor = db2.rawQuery("SELECT * FROM BALKH", null);

            if (cursor.moveToFirst()) {
                do {

                    blk.setText(cursor.getString(cursor.getColumnIndex("BLKH")));
                    blk.setTextColor(Color.parseColor("#ffaa00"));

                } while (cursor.moveToNext());
            }
            db2.close();


        }
    }



    public void CallData() {
        flage = 0;

        SQLiteDatabase db = openOrCreateDatabase("MYDATA",MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS BALKH");
        db.execSQL("CREATE TABLE IF NOT EXISTS BALKH(BLKH VARCHAR);");
        db.execSQL("INSERT INTO BALKH VALUES('Shah Sultan Balkhi Mahisawar was a ruler of Balkh in Central Asia.He was the son of\nShah Ali Asgar, a ruler of Balkh in Tataristan of Central Asia.He was selected as ruler after the death\nof his father.He left his kingship and became a ::dervish:: (spiritual leader).He took lesson from\nHazrat Toufique (R)to become Dervish.In the 14th century he came to Pundravardhana.Thereafter, he moved to Sandwip of Bangla,\nhere he stayed for few years. Later, he came to Mahasthangarh,the Capital of Pundravardhana and defeated Raja Parshuram,\nthe last Hindu king of Mahasthangarh in a battle.')");
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
