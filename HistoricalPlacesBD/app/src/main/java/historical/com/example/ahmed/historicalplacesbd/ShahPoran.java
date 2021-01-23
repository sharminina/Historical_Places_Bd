package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class ShahPoran extends ActionBarActivity {
TextView show21;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shah_poran);
        show21=(TextView)findViewById(R.id.shah_poran);
        if(flage==1){
            CallData();
            SQLiteDatabase db2=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor=db2.rawQuery("SELECT * FROM SHAHPRN",null);
            if(cursor.moveToFirst()){
                do{
                    show21.setText(cursor.getString(cursor.getColumnIndex("SHPRN")));
                    show21.setTextColor(Color.parseColor("#71e11a"));
                }while (cursor.moveToNext());
            }
            db2.close();
        }
    }


    public void CallData() {
        flage = 0;
        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS SHAHPRN");
        db.execSQL("CREATE TABLE IF NOT EXISTS SHAHPRN(SHPRN VARCHAR);");
        db.execSQL("INSERT INTO SHAHPRN VALUES('Hazrat Shah Paran (Bengali: শাহপরান, Shah Farhan) was a Sufi saint\nof the Suhrawardiyya and Jalalia order.It is said that he was the\n son of a sister of Shah Jalal and was born in Hadramaut.He was an accomplice of his uncle,\n Shah Jalal, with whom he arrived in India. In 1303 AD.It is unclear\n how and when he died, but he is buried near his khanqah. For centuries, large numbers of\n devotees have been visiting his tomb, a practice which continues even today.\nThere is an ancient mosque by the side of the tomb. The mosque has been modernised\n in 1989-91. About 1500 devout Muslims in a body can now say their prayers there.')");
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
