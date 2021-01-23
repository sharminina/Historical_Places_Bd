package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class DighirparMosque extends ActionBarActivity {
TextView show_dighi;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dighirpar_mosque);
        show_dighi=(TextView)findViewById(R.id.dighi_mos);
        if(flage==1){
            CallData();
            SQLiteDatabase db2=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor=db2.rawQuery("SELECT * FROM DIGHI",null);
            if(cursor.moveToFirst()){
                do{
                    show_dighi.setText(cursor.getString(cursor.getColumnIndex("DGHI")));
                    show_dighi.setTextColor(Color.parseColor("#000000"));
                }while(cursor.moveToNext());
            }
            db2.close();
        }
    }

public void CallData(){
    flage=0;
    SQLiteDatabase db1=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
    db1.execSQL("DROP TABLE IF EXISTS DIGHI");
    db1.execSQL("CREATE TABLE IF NOT EXISTS DIGHI(DGHI VARCHAR);");
    db1.execSQL("INSERT INTO DIGHI VALUES('This mosque is also known as ::Majlash_E_Aulia::Mosque.This mosque was built during anytime between\n1393 to 1410.The pundits are assuming that the mosque was built by the great ruler,\nSultan Azam Shah.There was a large Dighi(water tank) was created just near the mosque.\nThe water tank was made to ease the water problem of the peasant\nThats why people used to call the mosque as :Dighir par jame moshjid:')");
    db1.close();
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
