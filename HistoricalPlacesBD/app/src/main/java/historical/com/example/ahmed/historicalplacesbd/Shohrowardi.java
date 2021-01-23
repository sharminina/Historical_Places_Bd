package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Shohrowardi extends ActionBarActivity {
TextView show24;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shohrowardi);
        show24=(TextView)findViewById(R.id.shoh_g);
        if(flage==1){
            CallData();
            SQLiteDatabase db2=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor=db2.rawQuery("SELECT * FROM SHOUD",null);
            if(cursor.moveToFirst()){
                do{
                    show24.setText(cursor.getString(cursor.getColumnIndex("SHUD")));
                    show24.setTextColor(Color.parseColor("#000000"));
                }while (cursor.moveToNext());
            }
            db2.close();
        }
    }


    public void CallData() {
        flage = 0;
        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS SHOUD");
        db.execSQL("CREATE TABLE IF NOT EXISTS SHOUD(SHUD VARCHAR);");
        db.execSQL("INSERT INTO SHOUD VALUES('Suhrawardy Udyan (Bangla: সোহরাওয়ার্দী উদ্যান) formerly known as Ramna Race Course ground\n is a national memorial located in Dhaka, Bangladesh. It is named\n after Huseyn Shaheed Suhrawardy. Originally it served as the military club of the\n British soldiers stationed in Dhaka.It was then called the Ramna Race\n Course and later Ramna Gymkhana.After the end of colonial rule,the place – sometimes referred to as\n Dhaka Race Course – was used for legal horse racing on Sundays.')");
        db.close();
    }



}
