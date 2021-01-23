package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class TetuliaJame extends ActionBarActivity {
TextView show31;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tetulia_jame);
        show31=(TextView)findViewById(R.id.tetul_jami);
        if(flage==1){
            CallData();
            SQLiteDatabase db2=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor=db2.rawQuery("SELECT * FROM TETUL",null);
            if(cursor.moveToFirst()){
                do{
                    show31.setText(cursor.getString(cursor.getColumnIndex("TETL")));
                    show31.setTextColor(Color.parseColor("#000000"));
                }while (cursor.moveToNext());
            }
            db2.close();
        }

    }


    public void CallData() {
        flage = 0;
        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS TETUL");
        db.execSQL("CREATE TABLE IF NOT EXISTS TETUL(TETL VARCHAR)");
        db.execSQL("INSERT INTO TETUL VALUES('The Tetulia Jami Mosque, also known as the Khan Bahadur Salamatullah Mosque,\nand the Tetulia Shahi Mosque, is located in village of Tetulia (or Tentulia) in Tala upazila\n in the district of Satkhira in Bangladesh.The founder of the mosque was Khan Bahadur\n Maulvi Qazi Salamatullah Khan,of the zamindar (feudal-lord) Qazi family of Tetulia,\n who was also the founder of the mansion known as Salam Manzil (now in ruins)\n in the vicinity.The six-domed mosque was built Mughal style in 1858-59')");
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
