package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class TajhatPalace extends ActionBarActivity {
TextView show30;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tajhat_palace);
        show30=(TextView)findViewById(R.id.taju);
        if(flage==1){
            CallData();
            SQLiteDatabase db2=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor=db2.rawQuery("SELECT * FROM TAJHAT",null);
            if(cursor.moveToFirst()){
                do{
                    show30.setText(cursor.getString(cursor.getColumnIndex("TJHT")));
                    show30.setTextColor(Color.parseColor("#000000"));
                }while (cursor.moveToNext());
            }
            db2.close();
        }

    }
    public void CallData() {
        flage = 0;
        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS TAJHAT");
        db.execSQL("CREATE TABLE IF NOT EXISTS TAJHAT(TJHT VARCHAR)");
        db.execSQL("INSERT INTO TAJHAT VALUES('Tajhat Palace, Tajhat Rajbari, is a historic palace of Bangladesh, located\n in Tajhat, Rangpur. This palace now has been turned into a museum.\nTajhat Palace is situated three km. south-east of the city of Rangpur,on\n the outskirts of town.The palace was built by Maharaja Kumar Gopal Lal\n Roy in the beginning of the 20th century.')");
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
