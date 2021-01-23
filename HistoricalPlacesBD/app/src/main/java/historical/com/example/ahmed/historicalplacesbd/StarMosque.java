package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class StarMosque extends ActionBarActivity {
TextView show28;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_mosque);
        show28=(TextView)findViewById(R.id.tara);
        if(flage==1){
            CallData();
            SQLiteDatabase db2=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor=db2.rawQuery("SELECT * FROM STARMSQ",null);
            if(cursor.moveToFirst()){
                do{
                    show28.setText(cursor.getString(cursor.getColumnIndex("STRQ")));
                    show28.setTextColor(Color.parseColor("#000000"));
                }while (cursor.moveToNext());
            }
            db2.close();
        }

    }


    public void CallData() {
        flage = 0;
        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS STARMSQ");
        db.execSQL("CREATE TABLE IF NOT EXISTS STARMSQ(STRQ VARCHAR);");
        db.execSQL("INSERT INTO STARMSQ VALUES('Star Mosque (Bengali: তারা মসজিদ; also known as Tara Masjid), is a mosque located in Armanitola\n area, Dhaka, Bangladesh.The mosque has ornate designs and is decorated with motifs\n of blue stars.It was built in the first half of the 19th century by Mirza Golam Pir\n (Mirza Ahmed Jan).Star Mosque was first built by Mirza Ghulam Pir, as a three \ndomed oblong edifice')");
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
