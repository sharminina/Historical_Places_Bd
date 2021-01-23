package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class DhanbariMosque extends ActionBarActivity {
TextView show_db;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhanbari_mosque);
        show_db=(TextView)findViewById(R.id.dhonbari);
        if(flage==1){
            CallData();
            SQLiteDatabase db2=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor=db2.rawQuery("SELECT * FROM DMOSQ",null);
            if(cursor.moveToFirst()){
                do{
                    show_db.setText(cursor.getString(cursor.getColumnIndex("DMQT")));
                    show_db.setTextColor(Color.parseColor("#000000"));
                }while (cursor.moveToNext());
            }
            db2.close();
        }
    }

public void CallData(){
    flage=0;
    SQLiteDatabase db1=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
    db1.execSQL("DROP TABLE IF EXISTS DMOSQ");
    db1.execSQL("CREATE TABLE IF NOT EXISTS DMOSQ(DMQT VARCHAR);");
    db1.execSQL("INSERT INTO DMOSQ VALUES('Dhanbari Mosque  a historic architectural relic at Dhanbari upazila in Tangail district.\n Mughal generals Ispinjar Khan and Manawar Khan esatablished their zamindari\n at Dhanbari after defeating Dhanapati Singh during the reign of Mughal emperor Jahangir.')");
    db1.close();


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
