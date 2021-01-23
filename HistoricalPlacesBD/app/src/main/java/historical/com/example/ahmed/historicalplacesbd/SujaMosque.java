package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class SujaMosque extends ActionBarActivity {
TextView show33;
    int flage=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suja_mosque);
        show33=(TextView)findViewById(R.id.shujamos);
        if(flage==1){
            CallData();
            SQLiteDatabase db2=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor=db2.rawQuery("SELECT * FROM SUJMOS",null);
            if(cursor.moveToFirst()){
                do{
                    show33.setText(cursor.getString(cursor.getColumnIndex("SJMS")));
                    show33.setTextColor(Color.parseColor("#000000"));
                }while (cursor.moveToNext());
            }
            db2.close();
        }

    }


    public void CallData(){
        flage=0;
        SQLiteDatabase db=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
        db.execSQL("DROP TABLE IF EXISTS SUJMOS");
        db.execSQL("CREATE TABLE IF NOT EXISTS SUJMOS(SJMS VARCHAR);");
        db.execSQL("INSERT INTO SUJMOS VALUES('Suja mosque:Chorgacha, Ghoraghat, Dinajpur. There is no inscription\n was found in this beautiful mosque, depend on the fine and subtile\n stone work and other architectural characterstics some expartes claim that\n it was built during the Husain Shahi period.')");
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
