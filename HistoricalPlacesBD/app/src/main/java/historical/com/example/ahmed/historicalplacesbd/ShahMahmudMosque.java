package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;


public class ShahMahmudMosque extends ActionBarActivity {
TextView show19;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shah_mahmud_mosque);
        show19=(TextView)findViewById(R.id.sha_mahmud);
        if(flage==1){
            CallData();
            SQLiteDatabase db2=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor=db2.rawQuery("SELECT * FROM MAHMAJ",null);
            if(cursor.moveToFirst()){
                do{
                    show19.setText(cursor.getString(cursor.getColumnIndex("MHMJ")));
                    show19.setTextColor(Color.parseColor("#000000"));
                }while (cursor.moveToNext());
            }
            db2.close();
        }
    }



    public void CallData() {
        flage = 0;
        SQLiteDatabase db = openOrCreateDatabase("MYDATA", MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS MAHMAJ");
        db.execSQL("CREATE TABLE IF NOT EXISTS MAHMAJ(MHMJ VARCHAR);");
        db.execSQL("INSERT INTO MAHMAJ VALUES('Nasiruddin Mahmud Shah (Bengali: প্রথম নাসিরুদ্দিন মাহমুদ শাহ) (reigned: 1435–1459)\n was a Sultan of Bengal.He was a descendant of Sultan Shamsuddin Ilyas\n Shah of Bengal.Nasiruddin took the title of Nasiruddin Abul Muzaffar\n Mahmud Shah when he ascended the power in 1435 AD. It was after twenty years of gap since his dynasty lost the power in the first phase.')");
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
