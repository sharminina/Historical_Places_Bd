package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class AhsanMonzill extends ActionBarActivity {
TextView ahsa;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahsan_monzill);
        ahsa=(TextView)findViewById(R.id.ahs);
        if(flage == 1){
            CallData();
            SQLiteDatabase db2 = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
            final Cursor cursor = db2.rawQuery("SELECT * FROM AHSAN", null);

            if(cursor.moveToFirst())
            {
                do{

                    ahsa.setText(cursor.getString(cursor.getColumnIndex("AHM")));
                    ahsa.setTextColor(Color.parseColor("#ffaa00"));
                }while(cursor.moveToNext());
            }
            db2.close();
        }

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ahsan_monzill, menu);
        return true;

    }
    public void CallData() {
        flage = 0;

        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS AHSAN");
        db.execSQL("CREATE TABLE IF NOT EXISTS AHSAN(AHM VARCHAR);");
        db.execSQL("INSERT INTO AHSAN VALUES('Ahsan Manzil was the official residential palace\nand seat of the Dhaka Nawab Family.This magnificent building is\nsituated at Kumartoli along the banks of the Buriganga River in Dhaka, Bangladesh.\nThe construction of this palace was started in 1859 and was\ncompleted in 1872.It was constructed\nin the Indo-Saracenic Revival architecture.')");

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
