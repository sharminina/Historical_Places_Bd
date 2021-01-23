package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Sonargaon extends ActionBarActivity {
TextView show25;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonargaon);
        show25=(TextView)findViewById(R.id.panam);

        if(flage==1){
            CallData();
            SQLiteDatabase db2=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor=db2.rawQuery("SELECT * FROM PANAM",null);
            if(cursor.moveToFirst()){
                do{
                    show25.setText(cursor.getString(cursor.getColumnIndex("PNM")));
                    show25.setTextColor(Color.parseColor("#000000"));
                }while (cursor.moveToNext());
            }
            db2.close();
        }
    }


    public void CallData() {
        flage = 0;
        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS PANAM");
        db.execSQL("CREATE TABLE IF NOT EXISTS PANAM(PNM VARCHAR);");
        db.execSQL("INSERT INTO PANAM VALUES('Sonargaon – The once capital of Bengal, is a place where you can see the country’s\n heritage.The main place to visit here is the Folk Arts and Crafts museum\n located inside the Folk Arts and Crafts Foundation premises,the nearby old city\n from colonial period – Panam, and the beautiful Goaldi Mosque from the\n sultanate period.')");
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
