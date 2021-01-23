package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Budhijibi extends ActionBarActivity {
TextView show_int;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budhijibi);
        show_int=(TextView)findViewById(R.id.budhi_soudho);
        if(flage==1){
            CallData();
            SQLiteDatabase db2=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor=db2.rawQuery("SELECT * FROM INTEL", null);
           if(cursor.moveToFirst()){
               do{
                   show_int.setText(cursor.getString(cursor.getColumnIndex("INTL")));
                   show_int.setTextColor(Color.parseColor("#ffaa00"));
               }while (cursor.moveToNext());
           }
            db2.close();
        }
    }

public void CallData(){
    flage=0;
    SQLiteDatabase db1=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
    db1.execSQL("DROP TABLE IF EXISTS INTEL");
    db1.execSQL("CREATE TABLE IF NOT EXISTS INTEL(INTL VARCHAR);");
    db1.execSQL("INSERT INTO INTEL VALUES('Shahid Buddhijibi Graveyard or Martyr Intellectuals' Graveyard is the place\nwere the the remains of intellectuals who were murdered by Pakistan Army and their collaborators in 1971.\nDuring the Liberation War of Bangladesh the retreating Pakistan army,certain of their defeat,chalked out a heinous plan to eliminate\n the Bengali intelligentsia. Killing of Intellectuals was one of the most brutal and savage carnages in the\nhistory of Bangladesh.')");
    db1.close();




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
