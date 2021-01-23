package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Mahasthangarh extends ActionBarActivity {
TextView show10;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasthangarh);
        show10 = (TextView) findViewById(R.id.moha_gor);
        if (flage == 1) {
            CallData();
            SQLiteDatabase db2 = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
            final Cursor cursor = db2.rawQuery("SELECT * FROM MOHAGR", null);
            if (cursor.moveToFirst()) {
                do {
                    show10.setText(cursor.getString(cursor.getColumnIndex("MHGR")));
                    show10.setTextColor(Color.parseColor("#000000"));
                } while (cursor.moveToNext());
            }
            db2.close();
        }
    }
    public void CallData() {
        flage = 0;
        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS MOHAGR");
        db.execSQL("CREATE TABLE IF NOT EXISTS MOHAGR(MHGR VARCHAR);");
        db.execSQL("INSERT INTO MOHAGR VALUES('Mahasthangarh (Bengali: মহাস্থানগড় Môhasthangôṛ) is one of the earliest urban archaeological sites so far discovered\n in Bangladesh.The village Mahasthan in Shibganj thana of Bogra District contains the remains\n of an ancient city which was called Pundranagara or Paundravardhanapura in the territory of\n Pundravardhana. A limestone slab bearing six lines in Prakrit in Brahmi script, discovered in 1931,\n  dates Mahasthangarh to at least the 3rd century BC. The fortified area was in use till \nthe 18th century AD.And now there remains the ruins of all that creationa and also some usable tihngs \ntimed back to then,which are now preserved in museum there.')");
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
