package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class ShahJalal extends ActionBarActivity {
TextView show19;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shah_jalal);
        show19=(TextView)findViewById(R.id.shah_majar);
        if(flage==1){
            CallData();
            SQLiteDatabase db2=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor=db2.rawQuery("SELECT * FROM JALAL",null);
            if(cursor.moveToFirst()){
                do{
                    show19.setText(cursor.getString(cursor.getColumnIndex("SJLL")));
                    show19.setTextColor(Color.parseColor("#000000"));
                }while (cursor.moveToNext());
            }
            db2.close();
        }
    }



    public void CallData() {
        flage = 0;
        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS JALAL");
        db.execSQL("CREATE TABLE IF NOT EXISTS JALAL(SJLL VARCHAR);");
        db.execSQL("INSERT INTO JALAL VALUES('Hazrat Shah Jalal (Arabic: شيخ المشايخ‎, Bengali: শাহ জালাল,\n Shāh Jalāl ad-Dīn al-Mujarrad al-Turk al Naqshbandi;is a celebrated Sufi\n Muslim figure in Bengal.The exact date of birth and death of Hazrat Shah Jalal\n is unknown, however some believe that he was born in 1271 and others have\n suggested that he passed away in 1347.Hazrat Shah Jalal\n was buried in Sylhet.His robes and sword are preserved within the mosque,\n but these sacred artifacts are not on display to the public.')");
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
