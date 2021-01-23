package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class BijoySinghDighi extends ActionBarActivity {
TextView show_biju;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bijoy_singh_dighi);
        show_biju=(TextView)findViewById(R.id.bijoydighi);
        if(flage==1){
            CallData();
            SQLiteDatabase db2=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor=db2.rawQuery("SELECT * FROM BIJOY",null);
            if(cursor.moveToFirst()){
                do{
                    show_biju.setText(cursor.getString(cursor.getColumnIndex("BIJ")));
                    show_biju.setTextColor(Color.parseColor("#6f311c"));

                }while(cursor.moveToNext());
            }

            db2.close();


        }
    }



       public void CallData() {
        flage = 0;

        SQLiteDatabase db = openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);

           db.execSQL("DROP TABLE IF EXISTS BIJOY");
        db.execSQL("CREATE TABLE IF NOT EXISTS BIJOY(BIJ VARCHAR);");
        db.execSQL("INSERT INTO BIJOY VALUES('Feni  is famous for numerous big ponds, which were dug during Britsh era.\n Bijoy Singh  Digi is about 38 acres in size. The pond was dug during the regime\nof Shen Monarchy to ensure drinkable water availability in the then Feni town. Hundreds of people\nvisit this pond.throughout the year. The pond is located just in front of Feni Circuit House in a place\nnamed Bijoy Singh Village.')");
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
