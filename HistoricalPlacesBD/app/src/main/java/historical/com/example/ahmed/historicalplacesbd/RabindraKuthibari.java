package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class RabindraKuthibari extends ActionBarActivity {
TextView show14;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rabindra_kuthibari);
        show14=(TextView)findViewById(R.id.shelaidah);
        if(flage==1){
            CallData();
            SQLiteDatabase db2=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor=db2.rawQuery("SELECT * FROM RABIN",null);
            if(cursor.moveToFirst()){
                do{
                    show14.setText(cursor.getString(cursor.getColumnIndex("RBN")));
                    show14.setTextColor(Color.parseColor("#7905ee"));
                }while (cursor.moveToNext());
            }
            db2.close();
        }
    }



    public void CallData() {
        flage = 0;
        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS RABIN");
        db.execSQL("CREATE TABLE IF NOT EXISTS RABIN(RBN VARCHAR);");
        db.execSQL("INSERT INTO RABIN VALUES('Shilaidaha Kuthi Bari  Shilaidaha Kuthibari, is a tourist attraction.(Bengali: শিলাইদহ) is a place\n in Kumarkhali Upazila of Kushtia District in Bangladesh. The place\n is famous for Kuthi Bari; a country house made by Dwarkanath Tagore\nRabindranath Tagore lived a part of life here and created some of his memorable\n poems while living here. In 1890 Tagore started managing their family estates in\n Shelaidaha. He stayed there for over a dacade at irregular intervals between 1891 to 1901.\n It is a country house build by the father of Rabindranath, Maharshi Debendranath Tagore.')");
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
