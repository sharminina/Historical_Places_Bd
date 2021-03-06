package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class WariBoteshwar extends ActionBarActivity {
TextView show33;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wari_boteshwar);
        show33=(TextView)findViewById(R.id.wari);
        if(flage==1){
            CallData();
            SQLiteDatabase db2=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor=db2.rawQuery("SELECT * FROM WARB",null);
            if(cursor.moveToFirst()){
                do{
                    show33.setText(cursor.getString(cursor.getColumnIndex("WAR")));
                    show33.setTextColor(Color.parseColor("#000000"));
                }while (cursor.moveToNext());
            }
            db2.close();
        }
    }


    public void CallData() {
        flage = 0;
        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS WARB");
        db.execSQL("CREATE TABLE IF NOT EXISTS WARB(WAR VARCHAR);");
        db.execSQL("INSERT INTO WARB VALUES('The Wari-Bateshwar region (Bengali: উয়ারী-বটেশ্বর Uari-Bôṭeshshor) in Narsingdi,\nBangladesh is the site of an ancient fort city dating back to 450 BCE.\nThe 2500-year old ruins being unearthed near the old course of the Brahmaputra River \nare a major archaeological discovery in South Asia.It challenges the earlier\n notions of early urban civilization in Bengal.')");
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
