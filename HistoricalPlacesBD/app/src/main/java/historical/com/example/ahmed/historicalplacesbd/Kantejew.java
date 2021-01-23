package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Kantejew extends ActionBarActivity {
    TextView show6;
    int flage=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kantejew);
        show6=(TextView)findViewById(R.id.kant);
        if(flage == 1) {
            CallData();
            SQLiteDatabase db2 = openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor = db2.rawQuery("SELECT * FROM KNTE", null);

            if (cursor.moveToFirst()) {
                do {

                    show6.setText(cursor.getString(cursor.getColumnIndex("KNT")));
                    show6.setTextColor(Color.parseColor("#ffaa00"));

                } while (cursor.moveToNext());
            }
        db2.close();
    }

    }








public void CallData() {
        flage = 0;

        SQLiteDatabase db = openOrCreateDatabase("MYDATA",MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS KNTE");
        db.execSQL("CREATE TABLE IF NOT EXISTS KNTE(KNT VARCHAR);");
        db.execSQL("INSERT INTO KNTE VALUES('Kantaji Temple (Bengali: কান্তজীউ মন্দির) at Kantanagar,is a late-medieval Hindu temple in Dinajpur, Bangladesh.\n Built by Maharaja Pran Nath,its construction started in 1704 CE and ended in the reign of his\n son Raja Ramnath 1722 CE,during the reign of his son Maharaja Ramnath. It boasts one of the greatest examples \non Terracotta architecture in Bangladesh and once had nine spires, but all were destroyed in an\n earthquake that took place in 1897.')");
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
