package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class BijoysinghPalace extends ActionBarActivity {
TextView show_bipa;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bijoysingh_palace);
        show_bipa=(TextView)findViewById(R.id.bijoy_place);

        if(flage==1){
            CallData();
            SQLiteDatabase db2=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor=db2.rawQuery("SELECT * FROM BIJOYPAL",null);
            if(cursor.moveToFirst()){
                do{
                    show_bipa.setText(cursor.getString(cursor.getColumnIndex("BIP")));
                    show_bipa.setTextColor(Color.parseColor("#000000"));

                }while(cursor.moveToNext());
            }
            db2.close();
        }
    }


    public void CallData(){
        flage=0;
        SQLiteDatabase db=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
        db.execSQL("DROP TABLE IF EXISTS BIJOYPAL");
        db.execSQL("CREATE TABLE IF NOT EXISTS BIJOYPAL(BIP VARCHAR);");
        db.execSQL("INSERT INTO BIJOYPAL VALUES(' Raja Bijoy Singh was once ruler of this land during the 16th century.In 16th century,\n the king built this palace in tahirpur upzilla.At present there stands the ruins of this palace.')");
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
