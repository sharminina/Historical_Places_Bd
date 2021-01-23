package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;




public class Rayerkathi extends ActionBarActivity {
TextView tv_raer;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rayerkathi);
       tv_raer=(TextView)findViewById(R.id.rakathi);
        if(flage==1){
        CallData();
        SQLiteDatabase db2=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
        final Cursor cursor=db2.rawQuery("SELECT * FROM RAKATH",null);
        if(cursor.moveToFirst()){
            do{
                tv_raer.setText(cursor.getString(cursor.getColumnIndex("RKTH")));
                tv_raer.setTextColor(Color.parseColor("#000000"));
            }while (cursor.moveToNext());
        }
        db2.close();
    }

    }

    public void CallData() {
        flage = 0;
        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS RAKATH");
        db.execSQL("CREATE TABLE IF NOT EXISTS RAKATH(RKTH VARCHAR);");
        db.execSQL("INSERT INTO RAKATH VALUES('About 350 years ago there established a Landlord family. The landlord house known\n as Rayerkati Zamindarbari is situated in three km. north from the Pirojpur main town.\n Perliaement, ball-room, guest house and many hindu temples were built there. There were almost 200 palaces\n. From which about 40-50 were the largest. At 1658 Kaali (Hindu God) mandir or temples were established \nhere. The biggest Shiva Linga is also located here. Which weight is almost about\n thousend kilograms.')");
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
