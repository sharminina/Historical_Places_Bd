package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class GandhiAshram extends ActionBarActivity {
TextView show1;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gandhi_ashram);
        show1=(TextView)findViewById(R.id.gan_ash);
        if (flage == 1) {
            CallData();
            SQLiteDatabase db2 = openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor = db2.rawQuery("SELECT * FROM GANDHI", null);

            if (cursor.moveToFirst()) {
                do {

                    show1.setText(cursor.getString(cursor.getColumnIndex("GNDH")));
                    show1.setTextColor(Color.parseColor("#ffaa00"));

                } while (cursor.moveToNext());
            }
            db2.close();


        }
    }

    public void CallData() {
        flage = 0;

        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS GANDHI");
        db.execSQL("CREATE TABLE IF NOT EXISTS GANDHI(GNDH VARCHAR);");
        db.execSQL("INSERT INTO GANDHI VALUES('In 1947, Mahatma Gandhi visited Noakhali, as a developmental and philanthropic foundation had\n been working with the local communities here in regard to rural development since 1946. This brought\nabout the establishment of the Gandhi Ashram Trust that uses the Gandhian philosophy to bring upliftment, peace,\n and better living conditions for the rural communities. The trust was only officially\nfounded in 1975, after Bangladesh gained its independence in the year 1971.')");
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
