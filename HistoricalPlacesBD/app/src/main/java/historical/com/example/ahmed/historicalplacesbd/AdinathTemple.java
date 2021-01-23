package historical.com.example.ahmed.historicalplacesbd;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;

import android.widget.TextView;


public class AdinathTemple extends ActionBarActivity {
TextView adinat;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adinath_temple);
        adinat = (TextView) findViewById(R.id.adin);
        if (flage == 1) {
            CallData();
            SQLiteDatabase db2 = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
            final Cursor cursor = db2.rawQuery("SELECT * FROM ADINATH", null);

            if (cursor.moveToFirst()) {
                do {

                    adinat.setText(cursor.getString(cursor.getColumnIndex("ADI")));
                    adinat.setTextColor(Color.parseColor("#ffaa00"));
                    
                } while (cursor.moveToNext());
            }
            db2.close();


        }


    }
    public void CallData(){
        flage = 0;

        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS ADINATH");
        db.execSQL("CREATE TABLE IF NOT EXISTS ADINATH ( ADI VARCHAR);");
        db.execSQL("INSERT INTO ADINATH VALUES ('Adinath Temple is an ancient shiva Temple. \nSituated on the top of the \nMainak Hill on Moheshkhali Island. A Landowner named\nNur Mohammad Shikdar donated two hundread acres of land\n to reconstruct the age-old Adinath Temple.')");
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
