package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MuktijudhoJadughor extends ActionBarActivity {
 TextView show12;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muktijudho_jadughor);
        show12=(TextView)findViewById(R.id.liber_mus);
        if(flage==1){
            CallData();
            SQLiteDatabase db2=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor=db2.rawQuery("SELECT * FROM MUKTIJ",null);
            if(cursor.moveToFirst()){
                do{
                    show12.setText(cursor.getString(cursor.getColumnIndex("MKTJ")));
                    show12.setTextColor(Color.parseColor("#8edbd5"));
                }while (cursor.moveToNext());
            }
            db2.close();
        }




    }

    public void CallData() {
        flage = 0;
        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS MUKTIJ");
        db.execSQL("CREATE TABLE IF NOT EXISTS MUKTIJ(MKTJ VARCHAR);");
        db.execSQL("INSERT INTO MUKTIJ VALUES('Liberation War Museum, Bangladesh established in 1996, commemorates heroic struggle of Bengalee\n nation for democracy and national rights which following genocide unleashed by military rulers of Islamic Republic\n of Pakistan turned into armed struggle with emergence of Bangladesh as Secular Democratic State in \nDecember 1971 Museum is housed in a two-storied building with displays in six galleries. Currently, Museum \ncollection number 10,732(approx)')");
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
