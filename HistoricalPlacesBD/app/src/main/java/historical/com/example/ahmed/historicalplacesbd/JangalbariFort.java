package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class JangalbariFort extends ActionBarActivity {
TextView show4;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jangalbari_fort);
        show4=(TextView)findViewById(R.id.jangol);
        if (flage == 1) {
            CallData();
            SQLiteDatabase db2 = openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor = db2.rawQuery("SELECT * FROM JUNG", null);

            if (cursor.moveToFirst()) {
                do {

                    show4.setText(cursor.getString(cursor.getColumnIndex("JN")));
                    show4.setTextColor(Color.parseColor("#ffaa00"));

                } while (cursor.moveToNext());
            }
            db2.close();


        }
    }


    public void CallData() {
        flage = 0;

        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS JUNG");
        db.execSQL("CREATE TABLE IF NOT EXISTS JUNG(JN VARCHAR);");
        db.execSQL("INSERT INTO JUNG VALUES('Jangalbari Fort  is now in ruins and is situated in the village of Jangalbari (Jangalbadi)\nunder Karimganj Upazila of Kishoreganj district. According to local traditions,\n isa khan took over this fort from Laksmana Singh Hajra after mansingh had defeated him in the \nbattle of egarasindhur.')");
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
