package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class BoldhaGarden extends ActionBarActivity {
TextView show_bol;
    int flage=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boldha_garden);
        show_bol=(TextView)findViewById(R.id.botan);
        if(flage==1){
            CallData();
            SQLiteDatabase db2=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
            final Cursor cursor=db2.rawQuery("SELECT * FROM BOTANI",null);
            if(cursor.moveToFirst()){
                do{
                    show_bol.setText(cursor.getString(cursor.getColumnIndex("BOTN")));
                    show_bol.setTextColor(Color.parseColor("#ffaa00"));
                }while(cursor.moveToNext());
            }
            db2.close();
        }
    }

public void CallData(){
    flage=0;
    SQLiteDatabase db1=openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
    db1.execSQL("DROP TABLE IF EXISTS BOTANI ");
    db1.execSQL("CREATE TABLE IF NOT EXISTS BOTANI(BOTN VARCHAR);");
    db1.execSQL("INSERT INTO BOTANI VALUES('The history of Boldha garden also known as, botanical gardens is closely linked to the history\n of botany itself.The botanical gardens of the 16th and 17th centuries were medicinal gardens,\nThe National Botanical Garden, Dhaka was established in 1961 covering an area of about 84 ha of land\n located at Mirpur, about 10 km from Dhaka city.It has plants from different endangred species,greenhouse,lake,nursery,tourist\n sitting spot,auditorium.The garden houses nearly 50,000 species of trees, herbs, and shrubs including a large collection of aquatic plants.The garden is\n divided into 57 sections, and is managed by the government through the Department of Forestry, Ministry of Environment and Forests  ')");
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
