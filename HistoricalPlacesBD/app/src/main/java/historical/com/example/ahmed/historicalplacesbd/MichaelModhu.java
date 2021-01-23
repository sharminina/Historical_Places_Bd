package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MichaelModhu extends ActionBarActivity {
TextView show11;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_michael_modhu);
        show11=(TextView)findViewById(R.id.modhusudan);
        if(flage==1){
            CallData();
            SQLiteDatabase db2=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor=db2.rawQuery("SELECT * FROM MODHS",null);
            if(cursor.moveToFirst()){
                do{
                    show11.setText(cursor.getString(cursor.getColumnIndex("MDS")));
                    show11.setTextColor(Color.parseColor("#71e11a"));
                }while (cursor.moveToNext());
            }
            db2.close();
        }
    }


    public void CallData() {
        flage = 0;
        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS MODHS");
        db.execSQL("CREATE TABLE IF NOT EXISTS MODHS(MDS VARCHAR);");
        db.execSQL("INSERT INTO MODHS VALUES('Michael Madhusudan Dutt, or Michael Madhusudan Dutta (Bengali: মাইকেল মধুসূদন দত্ত)(25 January 1824 – 29 June 1873)\n was a popular 19th-century Bengali poet and dramatist.He was born in Sagordari (Bengali: সাগরদাঁড়ি),\n on the bank of Kopotaksho (Bengali: কপোতাক্ষ) River, a village in Keshabpur Upazila, Jessore District, Bengal Presidency,\n East Bengal (now in Bangladesh).He ran away from home to England and then tried to  evolve his writting there\n,but he failed and when he came back to bangladesh he started living there.This house is the mark of that.')");
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
