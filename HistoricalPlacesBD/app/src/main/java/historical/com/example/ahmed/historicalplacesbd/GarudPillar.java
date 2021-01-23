package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class GarudPillar extends ActionBarActivity {
TextView show2;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garud_pillar);
        show2=(TextView)findViewById(R.id.gar);
        if (flage == 1) {
            CallData();
            SQLiteDatabase db2 = openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor = db2.rawQuery("SELECT * FROM GARD", null);

            if (cursor.moveToFirst()) {
                do {

                    show2.setText(cursor.getString(cursor.getColumnIndex("GAR")));
                    show2.setTextColor(Color.parseColor("#000000"));

                } while (cursor.moveToNext());
            }
            db2.close();


        }

    }


    public void CallData() {
        flage = 0;

        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS GARD");
        db.execSQL("CREATE TABLE IF NOT EXISTS GARD(GAR VARCHAR);");
        db.execSQL("INSERT INTO GARD VALUES('This Goruda Pillar has a stone inscription of 28 lines.According to the inscription\ndepicted on it,this homage of Gurab Mishra, who was a minister during of the region of Pala\nking Narayan Pala (854-908)king Narayan Pala (854-908)')");
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
