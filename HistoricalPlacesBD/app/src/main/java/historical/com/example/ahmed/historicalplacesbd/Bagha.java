package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;




public class Bagha extends ActionBarActivity {
TextView bag;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       setContentView(R.layout.activity_bagha);
        bag=(TextView)findViewById(R.id.bagha_m);
        if (flage == 1) {
            CallData();
            SQLiteDatabase db2 = openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor = db2.rawQuery("SELECT * FROM BAGH", null);

            if (cursor.moveToFirst()) {
                do {

                    bag.setText(cursor.getString(cursor.getColumnIndex("BG")));
                    bag.setTextColor(Color.parseColor("#ffaa00"));

                } while (cursor.moveToNext());
            }
            db2.close();


        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bagha, menu);
        return true;
    }
    public void CallData() {
        flage = 0;

        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS BAGH");
        db.execSQL("CREATE TABLE IF NOT EXISTS BAGH(BG VARCHAR);");
        db.execSQL("INSERT INTO BAGH VALUES('Bagha Mosque situated at Bagha,about 25 miles southeast of Rajshahi\ntown,survives in a fairly good state of preservation. The mosque was built on the western bank\nof a fairly large tank within a brick-walled compound,48.77m square.It is very famous\nto all.')");
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
