package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class LalonMajar extends ActionBarActivity {
TextView show;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lalon_majar);
        show=(TextView)findViewById(R.id.lalon);
        if(flage==1){
            CallData();
            SQLiteDatabase db2=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor=db2.rawQuery("SELECT * FROM LAMAJR",null);
            if(cursor.moveToFirst()){
                do{
                    show.setText(cursor.getString(cursor.getColumnIndex("LMJR")));
                    show.setTextColor(Color.parseColor("#71e11a"));
                }while (cursor.moveToNext());
            }
            db2.close();
        }
    }


    public void CallData(){
        flage=0;
        SQLiteDatabase db=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
        db.execSQL("DROP TABLE IF EXISTS LAMAJR");
        db.execSQL("CREATE TABLE IF NOT EXISTS LAMAJR(LMJR VARCHAR);");
        db.execSQL("INSERT INTO LAMAJR VALUES('Lalon (Bengali: লালন), also known as Lalon Sain, Lalon Shah,or Lalon Fakir (c. 1774–1890),\nwas a Bengali Baul saint, mystic,songwriter, social reformer and thinker.He built\n an institution in cheuria,Kushtia before his death and now he is also resting in peace there.\n\nThe place is now converted into an instution which is just in the shrine premises and here Baul community stays and\n continue the practice of his legacy.')");
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
