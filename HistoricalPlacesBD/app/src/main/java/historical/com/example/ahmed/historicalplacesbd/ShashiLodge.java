package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class ShashiLodge extends ActionBarActivity {
TextView show18;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shashi_lodge);
        show18=(TextView)findViewById(R.id.lodge);
        if(flage==1){
            CallData();
            SQLiteDatabase db2=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor=db2.rawQuery("SELECT * FROM SHALOG",null);
            if(cursor.moveToFirst()){
                do{
                    show18.setText(cursor.getString(cursor.getColumnIndex("SHLDG")));
                    show18.setTextColor(Color.parseColor("#000000"));
                }while (cursor.moveToNext());
            }
            db2.close();
        }
    }

    public void CallData() {
        flage = 0;
        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS SHALOG");
        db.execSQL("CREATE TABLE IF NOT EXISTS SHALOG(SHLDG VARCHAR);");
        db.execSQL("INSERT INTO SHALOG VALUES('The name of Maharajah Sashi Kanta Acharya Chaudhury is the penultimate\n in a 55 year history of the administration of Mymensingh,and a large swather\n of other lands in Bangladesh.It is also the name given originally to the\n Oriental Edwardian masterpiece,Sashi Lodge, now known as Mymensingh Rajbari.')");
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
