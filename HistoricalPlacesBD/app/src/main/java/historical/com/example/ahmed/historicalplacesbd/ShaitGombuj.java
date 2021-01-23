package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class ShaitGombuj extends ActionBarActivity {
    TextView show18;
    int flage=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shait_gombuj);
        show18=(TextView)findViewById(R.id.sixtys);
        if(flage==1){
            CallData();
            SQLiteDatabase db2=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor=db2.rawQuery("SELECT * FROM SIXDOM", null);
            if(cursor.moveToFirst()){
                do{
                    show18.setText(cursor.getString(cursor.getColumnIndex("SXDM")));
                    show18.setTextColor(Color.parseColor("#000000"));
                }while (cursor.moveToNext());
            }
            db2.close();
        }
    }

    public void CallData() {
        flage = 0;
        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS SIXDOM");
        db.execSQL("CREATE TABLE IF NOT EXISTS SIXDOM(SXDM VARCHAR);");
        db.execSQL("INSERT INTO SIXDOM VALUES('Shaitgumbad mosque, or 60-domed mosque, is located about three miles west of\n the present Bagerhat town. The mosque was built by Khan Jahan Ali,\n a muslim sufi saint around 1450 A.D. The mosque, built mainly \nof bricks, measures 192 feet from north to south and 130 feet from east to west.\n The mosque has an architectural style that strongly resembles other pre-mughal\n mosques of Bengal.')");
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
