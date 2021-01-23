package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class VasuVihar extends ActionBarActivity {
TextView show32;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vasu_vihar);
        show32=(TextView)findViewById(R.id.vv);
        if(flage==1){
            CallData();
            SQLiteDatabase db2=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor=db2.rawQuery("SELECT * FROM VASU",null);
            if(cursor.moveToFirst()){
                do{
                    show32.setText(cursor.getString(cursor.getColumnIndex("VS")));
                    show32.setTextColor(Color.parseColor("#000000"));
                }while (cursor.moveToNext());
            }
            db2.close();
        }

    }


    public void CallData() {
        flage = 0;
        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS VASU");
        db.execSQL("CREATE TABLE IF NOT EXISTS VASU(VS VARCHAR)");
        db.execSQL("INSERT INTO VASU VALUES('Mahasthangarh (Bengali: মহাস্থানগড় Môhasthangôṛ) is one of the earliest urban archaeological\n site so far discovered in Bangladesh.The village Mahasthan in Shibganj\n thana of Bogra District contains the remains of an ancient city.which was \ncalled Pundranagara or Paundravardhanapura in the territory of Pundravardhana ')");
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
