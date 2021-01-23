package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class SecondWorldWar extends ActionBarActivity {
TextView show17;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_world_war);
        show17=(TextView)findViewById(R.id.cemetry);
        if(flage==1){
            CallData();
            SQLiteDatabase db2=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor=db2.rawQuery("SELECT * FROM SECNDWR",null);
            if(cursor.moveToFirst()){
                do{
                    show17.setText(cursor.getString(cursor.getColumnIndex("SCWR")));
                    show17.setTextColor(Color.parseColor("#f64e16"));
                }while (cursor.moveToNext());
            }
            db2.close();
        }
    }


    public void CallData() {
        flage = 0;
        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS SECNDWR");
        db.execSQL("CREATE TABLE IF NOT EXISTS SECNDWR(SCWR VARCHAR);");
        db.execSQL("INSERT INTO SECNDWR VALUES('  This cemetery was established to show the honor for the soldiers and others who died in\n World War II. The cemetery was created by the British Army, and there were originally\n about 400 burials. Graves have since been transferred to this cemetery from the \nLushai Hills (Assam) and other isolated sites.\n There are now 731 Commonwealth burials of the 1939-45 war here,\n17 of which are unidentified.')");
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
