package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Josimuddin extends ActionBarActivity {
TextView show5;
    int flage=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_josimuddin);
        show5=(TextView)findViewById(R.id.poet);
        if (flage == 1) {
            CallData();
            SQLiteDatabase db2 = openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor = db2.rawQuery("SELECT * FROM JASM", null);

            if (cursor.moveToFirst()) {
                do {

                    show5.setText(cursor.getString(cursor.getColumnIndex("JSM")));
                    show5.setTextColor(Color.parseColor("#000000"));

                } while (cursor.moveToNext());
            }
            db2.close();


        }

    }


    public void CallData() {
        flage = 0;

        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS JASM");
        db.execSQL("CREATE TABLE IF NOT EXISTS JASM(JSM VARCHAR);");
        db.execSQL("INSERT INTO JASM VALUES('This was the house where the renowned poet JashimUddin ,of our country was born.January 1, 1904\n(Accoding to his Matriculation Certificate, Prof. Aminul Islam, Jasimuddin, 1962), in a small village,\n Tambulkhana, in the Faridpur district of East Bengal.This place now just represents\n that birthplace and withholds some other used material by him.At that time,\nthis place was under east-bengla.')");
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
