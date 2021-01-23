package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class SonaMosque extends ActionBarActivity {
TextView show25;
    int flage=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sona_mosque);
        show25=(TextView)findViewById(R.id.sonamosq);

        if(flage==1){
            CallData();
            SQLiteDatabase db2=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor=db2.rawQuery("SELECT * FROM SHNAMSQ",null);
            if(cursor.moveToFirst()){
                do{
                    show25.setText(cursor.getString(cursor.getColumnIndex("SHNMQ")));
                    show25.setTextColor(Color.parseColor("#000000"));
                }while (cursor.moveToNext());
            }
            db2.close();
        }
    }

    public void CallData() {
        flage = 0;
        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS SHNAMSQ");
        db.execSQL("CREATE TABLE IF NOT EXISTS SHNAMSQ(SHNMQ VARCHAR);");
        db.execSQL("INSERT INTO SHNAMSQ VALUES(' The mosque was built during the reign of Sultan Hussain Shah, it can\n be narrowed down to between the years of 1493 and 1519. The magnificent fifteen domes of\n the mosque were once gilded in gold, giving the mosque the name ::Sona Mosque::in chapai nawabganj. ')");
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
