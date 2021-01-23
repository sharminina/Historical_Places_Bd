package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Sujabadfort extends ActionBarActivity {
TextView show29;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sujabadfort);
        show29=(TextView)findViewById(R.id.suja);
        if(flage==1){
            CallData();
            SQLiteDatabase db2=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor=db2.rawQuery("SELECT * FROM SJAFRT",null);
            if(cursor.moveToFirst()){
                do{
                    show29.setText(cursor.getString(cursor.getColumnIndex("SJFT")));
                    show29.setTextColor(Color.parseColor("#000000"));
                }while (cursor.moveToNext());
            }
            db2.close();
        }
    }


    public void CallData() {
        flage = 0;
        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS SJAFRT");
        db.execSQL("CREATE TABLE IF NOT EXISTS SJAFRT(SJFT VARCHAR);");
        db.execSQL("INSERT INTO SJAFRT VALUES('History shows that, in the mid-sixteenth century of subedari period, the salimabad\n pargona chandradbip area occupied by the mugs and Portuguese pirates.\n To get safety In the past few years ago, there has been some work to dig the\n soil and then come out the palace ruins.')");
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
