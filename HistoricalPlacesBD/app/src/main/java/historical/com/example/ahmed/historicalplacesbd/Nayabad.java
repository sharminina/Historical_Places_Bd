package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Nayabad extends ActionBarActivity {
TextView show13;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nayabad);
        show13=(TextView)findViewById(R.id.naya_m);
        if(flage==1){
            CallData();
            SQLiteDatabase db2=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor=db2.rawQuery("SELECT * FROM NAYAM",null);
            if(cursor.moveToFirst()){
                do{
                    show13.setText(cursor.getString(cursor.getColumnIndex("NAYM")));
                    show13.setTextColor(Color.parseColor("#000000"));
                }while (cursor.moveToNext());
            }
            db2.close();
        }

    }


    public void CallData() {
        flage = 0;
        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS NAYAM");
        db.execSQL("CREATE TABLE IF NOT EXISTS NAYAM(NAYM VARCHAR);");
        db.execSQL("INSERT INTO NAYAM VALUES('Nayabad Mosque is located in the bank of the river Dhepa,just 1.5km south-west of the infamous\n Kantaji Temple at Dinajpur in Bangladesh.The mosque is named after the village “Nayabad\n” in which it stands in the Police Station of Kaharole. According to an inscription found\n on the central doorway,it was constructed at 1793 AD in the reign of Mughal\n Emperor shah alam.')");
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
