package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class IdrakpurFort extends ActionBarActivity {
TextView show3;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idrakpur_fort);
        show3=(TextView)findViewById(R.id.idrakfort);
        if (flage == 1) {
            CallData();
            SQLiteDatabase db2 = openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor = db2.rawQuery("SELECT * FROM IDRA", null);

            if (cursor.moveToFirst()) {
                do {

                    show3.setText(cursor.getString(cursor.getColumnIndex("IDR")));
                    show3.setTextColor(Color.parseColor("#000000"));

                } while (cursor.moveToNext());
            }
            db2.close();


        }
    }

    public void CallData() {
        flage = 0;

        SQLiteDatabase db = openOrCreateDatabase("MYDATA",MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS IDRA");
        db.execSQL("CREATE TABLE IF NOT EXISTS IDRA(IDR VARCHAR);");
        db.execSQL("INSERT INTO IDRA VALUES('This small fortress is situated on the bank of the dried up Ichamoti river at Idrakpur in\n Munshigonj town.It was built by Mir Jumla,the viceroy of Bengal in 1660 A.D.The special feature\nof the fort is a huge solid circular platform or drum,with a diameter of 32.91m. The huge\nplatform evidently was used to mount cannon and also as a watch tower.')");
        db.close();}






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
