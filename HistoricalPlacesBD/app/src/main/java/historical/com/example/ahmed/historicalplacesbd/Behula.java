package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Behula extends ActionBarActivity {
TextView show;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_behula);
        show=(TextView)findViewById(R.id.behu_de);
        if (flage == 1) {
            CallData();
            SQLiteDatabase db2 = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
            final Cursor cursor = db2.rawQuery("SELECT * FROM BEHUL", null);

            if (cursor.moveToFirst()) {
                do {

                    show.setText(cursor.getString(cursor.getColumnIndex("BEH")));
                    show.setTextColor(Color.parseColor("#ffaa00"));

                } while (cursor.moveToNext());
            }
            db2.close();


        }

    }



    public void CallData(){
        flage=0;
    SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
    db.execSQL("CREATE TABLE IF NOT EXISTS BEHUL(BEH VARCHAR);");
    db.execSQL("INSERT INTO BEHUL VALUES(' situated in the village Gokul, 3 km to the south of the citadel Mahsthangarh. off the Bogra-Rangpur road\n,connected by a narrow motorable road about 1 km. Excavations in 1934–36 revealed a terraced podium with 172\nrectangular blind cells. It is dated 6th–7th century.Local mythology associates it with legendary Lakshmindara-Behula.')");
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
