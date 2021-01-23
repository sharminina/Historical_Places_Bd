package historical.com.example.ahmed.historicalplacesbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class DatabaseActivity extends ActionBarActivity {

    int flage = 1;
    TextView data,namefield;
    String dtxt_nam,dtxt_info,btxt;

  ImageView songshod,lalbag,armenium,carzon,sriti,shahid,rayer_B,budhi_grave,shat_mosq,mujibtomb,dhakes_tem,etho_mus,jainta,mujibnagar ;//ahsan_m;
ImageView sitaram,vobani,gnvbn,smallsn,chtmhr,ell,mkhdum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        songshod=(ImageView)findViewById(R.id.image_songshod);
        lalbag=(ImageView)findViewById(R.id.image_lalbag);
        armenium=(ImageView)findViewById(R.id.image_armeniium);
        carzon=(ImageView)findViewById(R.id.image_carzon);
        sriti=(ImageView)findViewById(R.id.image_sriti);
        shahid=(ImageView)findViewById(R.id.image_shahidminar);
        //dhaka div3
        rayer_B=(ImageView)findViewById(R.id.image_raer);
        budhi_grave=(ImageView)findViewById(R.id.image_budhijibi);
        shat_mosq=(ImageView)findViewById(R.id.image_7mosque);
//dhakadivision4
        mujibtomb=(ImageView)findViewById(R.id.image_mujibtomb);
        //dhaka5
        dhakes_tem=(ImageView)findViewById(R.id.image_dhakeshori);
//chittagoong
        etho_mus=(ImageView)findViewById(R.id.image_ethono);
        //shylet
        jainta=(ImageView)findViewById(R.id.image_jointa);
        //khulna
        mujibnagar=(ImageView)findViewById(R.id.image_mujibnogor);
        sitaram=(ImageView)findViewById(R.id.image_sitaram);
        //rajshahi
        vobani=(ImageView)findViewById(R.id.image_vobani);
        gnvbn=(ImageView)findViewById(R.id.image_gonovbn);
        smallsn=(ImageView)findViewById(R.id.image_smallsona);
        chtmhr=(ImageView)findViewById(R.id.image_chatmohor);
        ell=(ImageView)findViewById(R.id.image_elli);
        mkhdum=(ImageView)findViewById(R.id.image_mkhdum);

        data = (TextView)findViewById(R.id.txt);
        namefield=(TextView)findViewById(R.id.name_txt);
        //Toast.makeText(getApplicationContext(), "Location not found", Toast.LENGTH_SHORT).show();


        ShowData();

    }

    public void ShowData(){
        if(flage == 1){
            PushData();
        }


        Bundle extra = getIntent().getExtras();
        btxt = extra.getString("Name");
        SetBackground(btxt);


        SQLiteDatabase db2 = openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);
        final Cursor cursor = db2.rawQuery("SELECT * FROM MYTABLE WHERE NAME ='"+btxt+"'", null);

        if (cursor.moveToFirst()) {
            do {
                dtxt_nam = cursor.getString(cursor.getColumnIndex("NAME"));
                dtxt_info = cursor.getString(cursor.getColumnIndex("INFO"));

               // data.append(dtxt_nam+" "+dtxt_info);
                namefield.append(dtxt_nam);
                namefield.setTextColor(Color.parseColor("#000000"));
                data.append(dtxt_info);

                data.setTextColor(Color.parseColor("#000000"));

            } while (cursor.moveToNext());
        }
        db2.close();
    }

    public void PushData(){
        flage =0;
        SQLiteDatabase db = openOrCreateDatabase("MYDATA",MODE_PRIVATE,null);

        db.execSQL("DROP TABLE IF EXISTS MYTABLE");
        db.execSQL("CREATE TABLE IF NOT EXISTS MYTABLE(NAME VARCHAR,INFO VARCHAR);");
        //db.execSQL("INSERT INTO MYTABLE VALUES('Ahsan Manzil','Ahsan Manzil was the official residential palace\nand seat of the Dhaka Nawab Family.This magnificent building is\nsituated at Kumartoli along the banks of the Buriganga River in Dhaka, Bangladesh\nin the Indo-Saracenic Revival architecture.')");
        db.execSQL("INSERT INTO MYTABLE VALUES('Lalbagh Kella','Lalbagh Fort (Fort Aurangabad) is an incomplete Mughal Palace fortress at Dhaka on the Buriganga River\nin the southwestern part of the old city of Dhaka.Prince Muhammad Azam, son of Emperor\n Aurangzeb,began the construction while he was serving as the Viceroy of Bengal.Built\nin 17th Century dated 1678.Main attractions are - Tomb of Pari Bibi, Lalbagh mosque, Audience hall\nand Hammam Khana (bathing place) of Nawab Shaista Khan.')");
      db.execSQL("INSERT INTO MYTABLE VALUES('Shahid Minar',' The Shaheed Minar (Bengali: শহীদ মিনার Shohid Minar lit.::Martyr Memorial::is a national\n monument in Dhaka, Bangladesh,The Shaheed Minar is situated near Dhaka Medical \nCollege Hospital and in the Dhaka University area. It is adjacent to the Mathematics\n Department of Dhaka University.This memorial was built in honour of the martyrs\n who took part in language movement in 1952,and gave up their life to protect our\n motherlanguage.')");
         db.execSQL("INSERT INTO MYTABLE VALUES('Armenium Church','Following the domination of their homeland by Persian powers of the time\nArmenians were  sent by their new rulers to the Bengal region for both political\nand economic reasons.Their presence in Dhaka dates back to the 17th century\n In Dhaka Armenian merchants traded in jute and leather,and profitability in these businesses\nconvinced some to move permanently to Bangladesh.The area where they lived became\nknown as Armanitola.In 1781 the now famous Armenian Church was built on Armenian Street.in Armanitola \n then a thriving business district. Agaminus Catachik an Armenian  gave away\n the land to build the church.')");
        db.execSQL("INSERT INTO MYTABLE VALUES('National Parliament House','Jatiyo Sangsad Bhaban or National Parliament House,\n(Bengali: জাতীয় সংসদ ভবন Jatiyô Sôngsôd Bhôbôn) is the house of the Parliament of Bangladesh, located at Sher-e-Bangla Nagar in the Bangladeshi capital\n of Dhaka.Designed by architect Louis Kahn,the complex, is one of the largest legislative complexes\n in the world,comprising 200 acres (800,000 m²)')");
        db.execSQL("INSERT INTO MYTABLE VALUES('Curzon Hall','The Curzon Hall is a British Raj-era building and home of the Faculty of Science at\nthe University of Dhaka.The building was originally intended to be a town hall and is named\nafter Lord Curzon the Viceroy of India who laid its foundation stone in 1904.\nUpon the establishment of Dacca University in 1921 it became the base of the\n universitys science faculty.')");
       db.execSQL("INSERT INTO MYTABLE VALUES('National Martyr Memorial','Jatiyo Sriti Shoudho (Bengali: জাতীয় স্মৃতি সৌধ Jatio Sriti Shoudho) or National Martyrs Memorial is located\n in Savar, about 35 km north-west of the capital,It was designed\n by Syed Mainul Hossain.The main structure and the artificial lake and other \nfacilities were completed in 1982. It was Inaugurated at 16 December, 1982.')");
        db.execSQL("INSERT INTO MYTABLE VALUES('Rayer Bazar Bodhdhovumi','Rayer Bazaar Bodhdhobhumi is located in Mohammadpur near Beribadh area in Dhaka \nDistrict.This area is mainly an extension of the Turag River\n In the night of 14 December 1971 many of Bangladeshi intellectuals including professors: \n journalists: doctors:artists :engineers: and writers were rounded up in Dhaka. They were taken\n blindfolded to torture cells in Mirpur Mohammadpur Nakhalpara Rajarbagh and other\n locations in different sections of the city. Later they were executed and thrown out in the\n swamps at Rayerbazar.In memory of the martyred intellectuals of 1971  a Memorial is created in there.\n The ::Al-Badr:: and ::Al-Shams:: Group helped the West Pakistan Army to locate the intellectuals\n and slaughtered them and many other innocent peoples at night. After the massacre they\n brought the corpses and left them into the swamps of Rayer Bazaar. After the Liberation War \n the people of Dhaka found out that all the dead bodies of many great intellectuals and innocent\n people are piled up in here.Martyred Intellectuals Memorial is the memorial\n built for the memory of the martyred intellectuals of 1971. The memorial is built\n in the Boddhobhumi at Rayer Bazaar.')");
       db.execSQL("INSERT INTO MYTABLE VALUES('Shat Moshjid','Shat Gombuj Mosjid (Bengali: সাত গম্বুজ মসজিদ: Shat Gombuj Mosque or Seven Domed Mosque)\nwas built in the 17th century.at the north west outskirt of Dhaka\n in present-day Bangladesh.');");
        db.execSQL("INSERT INTO MYTABLE VALUES('Shahid Buddhijibi Graveyard','Shahid Buddhijibi Graveyard or Martyr Intellectuals Graveyard is the place\nwere the the remains of intellectuals who were murdered by Pakistan Army and their collaborators in 1971.\nDuring the Liberation War of Bangladesh the retreating Pakistan army,certain of their defeat,chalked out a heinous plan to eliminate\n the Bengali intelligentsia. Killing of Intellectuals was one of the most brutal and savage carnages in the\nhistory of Bangladesh.')");
        db.execSQL("INSERT INTO MYTABLE VALUES('Sheikh Mujibur Rahmans Tomb','Sheikh Mujibur Rahmans Grave in Tongipara.Following the independence of Bangladesh in\n December 1971, Mujibur was released from custody in Pakistan. He was flown from\nPakistan via London, England and then brought to India. Bangladesh at the time was under Pakistan\n occupation and control. Mujibur was installed as the Prime Minister and later President of the new independent\n state.With virtual no opposition, he was appointed as a president through a constitutional\n amendment due to an unabated political chaos in early 1975  when Pakistani collaborators \n were regrouping and planning for reestablishing their lost power. His declaration \nof one party rule was opposed by the civil society, intellectuals and all political groups.\n The Jatiyo Rakkhi Bahini (National Vanguards) was a highly controversial political\n militia force formed in 1972 with a status of an elite force which was loyal to Mujibur\nColonel (was Major in August 1975) Syed Faruque Rahman, Abdur Rashid, Sharful Haque (Dalim)\n, Raju Ahmed and A.K.M. Raju Ahmed, all majors in the Bangladesh Army and veterans of \nBangladesh Forces.With cue from certain foreign intelligence, they planned to topple the \ngovernment and establish a military government of their own.In the early morning of August\n 15,1975 these conspirators attacked the mujib family and killed all of them on he spot\n apart  from Sheikh Hasina and Sheikh Rehana as both were in West Germany at \nthat time.So the house where they were killed now is now preserved and all the\n family members are resting in peace there.')");
        db.execSQL("INSERT INTO MYTABLE VALUES('Ethnological Museum','The Ethnological Museum of Chittagong.is the only ethnological museum in Bangladesh and is\nlocated in Agrabad,Chittagong.The Museum contains displays featuring the history of Bangladeshs tribal\npeople The Ethnological Museum was established in 1965 and the museum opened to the public in 1974.')");
        db.execSQL("INSERT INTO MYTABLE VALUES('Dhakeshwari Temple','Dhakeshwari National Temple is a Hindu temple in Dhaka, Bangladesh.It is state-owned,\ngiving it the distinction of being Bangladeshs :National Temple:The name :Dhakeshwari: (ঢাকেশ্বরী Ðhakeshshori)\n means:Goddess of Dhaka:Since the destruction of Ramna Kali Mandir in 1971 by the Pakistan\n Army during the Bangladesh  Liberation War,the Dhakeshwari Temple has assumed status as the most important\n Hindu place of worship in Bangladesh.The Dhakeshwari temple was built in the 12th century by\n  Ballal Sen,a king of the Sena dynasty, and many say the city was named after this temple.')");
        db.execSQL("INSERT INTO MYTABLE VALUES('Stone Monument of Jaintapur','Jaintiapur is only 5 km. from Jaflong, a scenic spot amidst tea gardens.\n Jaintapur was the capital of Jainta Kingdome at 18th century.Jainta Rajbari was the palace\nof Kings of Jainta, its just adjacent of Jainta Bazar.Though the condition of this kings palace is already\n damaged enormously but a huge number of tourists visit here due to the historical background of Jainta Kingdom.\nAnd moreover the stone monuments are mark of that palace.')");
        db.execSQL("INSERT INTO MYTABLE VALUES('Mujibnogor Memorial','During the Liberation War, the oath taking of the first interim government of the People s Republic\n of Bangladesh was held on the 17th April, 1971 at the mango grove of Meherpur. To mark this historical\n occasion, an open architectural competition was called in 1983 to design a memorial at the site of\n the oath taking.architectural competition was called in 1983 to design a memorial at the site of\n the oath taking.')");
        db.execSQL("INSERT INTO MYTABLE VALUES('Sitaram Palace','Sitaram came from the Kashyap Das clan, one of the\n nine clans that constitute the Uttar Rarhi Kayasthas.\nThe clan was settled in the Fatehsingh region of Murshidabad.When Mir Jumla \ntransferred the capital back to Dhaka in 1660, Udaynarayan also moved to Dhaka\nIn 1664, Udaynarayan rose to the post of tehsildar and shifted to Bhusna. After a few years,\n he built a residence at Hariharanagar near the banks of Madhumati and brought his family there.\nSitaram spent his childhood at his maternal uncle-s home at Katwa.He built a\n luxurious three storied palace in his zamindari time and now there stands the ruins of that\n palace in natore')");
        db.execSQL("INSERT INTO MYTABLE VALUES('Rani Vobani Palace','Rani Bhabani (Bengali: রাণী ভবাণী) (1716–1795) was a zamindar during the British colonial\n era in what is now of Rajshahi, Bangladesh.Rani Bhabani-s house\n in Natore remains a main tourist attraction in Bangladesh to date.')");
        db.execSQL("INSERT INTO MYTABLE VALUES('Uttora Gononvobon','Uttara Gano Bhaban also known as The Maharaja-s Palace or Dighapatia\n Palace (or Rajbari) is a historic,formerly royal palace in Natore, Bangladesh.\nIt was built by the Raja of Dighapatia but is used as the official residence\n of the heads of states of Bangladesh in North Bengal.In the north, it\n serves as an official Presidential Palace. Various historic meetings took place at\n the palace,during the British Raj, East Pakistan era and finally after the\n independence of Bangladesh. Bangabandhu Sheikh Mujibur Rahman,President of\n Bangladesh declared the Dighapatia Governor House as Uttara Gonobhaban \non February 9, 1972.')");
        db.execSQL("INSERT INTO MYTABLE VALUES('Choto Sona Mosque','Choto Shona Mosque is located in Chapai Nawabganj district of Bangladesh.The mosque\n is situated about 3km south of the Kotwali Gate and 0.5 km to the south-east\nof the Mughal Tahkhana complex in the Firozpur Quarter.The mosque was built during the reign of Sultan\nHussain Shah,between 1493 and 1519.')");
        db.execSQL("INSERT INTO MYTABLE VALUES('Chatmohor Shahi Mosque','This lofty mosque was built during the time of the Great Sultan,the chief of Sayyiads,\nAbdul Fath Muhammad Macum Khan.Mr. Blochman,the author of the Ayne Akbari made the translation of Persian inscription\n of the black epitaph found on the entrance of the mosque. On the other side of this epitaf,there are\ndrawings of Hindu god Shiva,Bishnu and Brahma.The mosque is constructed of red zafri  bricks.\nApproximate Inside Dimensions: Length 51feet,Width 21feet,Height 45feet consists of three domes.')");
        db.execSQL("INSERT INTO MYTABLE VALUES('Elliot Bridge','Eliot Bridge, an architectural heritage of the Sirajganj town, attracts tourists from home and abroad\n  Built over the Baral in the middle of the town during the British rule, the bridge\nwithout pillar is popularly known as ::Boropul::, The bridge connects the eastern part of the town\n with its western part.Sir Charles Eliot, the then government of Bengal and Assam laid the foundation\nof the 180 feet long and 16 feet wide steel arch bridge named after him on August 6. 1882.')");
        db.execSQL("INSERT INTO MYTABLE VALUES('Shah Makhdum Mazar','Among the Sufis of high rank who drew the attention of the people of Bangladesh\n, mention must be made of Hazrat Shah Makhdum R.A. The Shrine of this saint lies\n in the Rajshahi Government College campus. This is called Dariyapara.\nA Persian inscription reveals that his mausoleum was built by Ali Quli Beg,\na servant of Shah Abbas Safavi of Iran (1587-1692 A.D.). A recent\npublication of Bengal Academy of Dhaka, 1961, records the saint-s death in\n1592 A.D. at the age of 117 years.')");
        db.close();
    }
    public void SetBackground(String ptxt){
        if(ptxt.equalsIgnoreCase("Armenium Church")){
            lalbag.setVisibility(View.INVISIBLE);
           songshod.setVisibility(View.INVISIBLE);
            shahid.setVisibility(View.INVISIBLE);
            sriti.setVisibility(View.INVISIBLE);
            carzon.setVisibility(View.INVISIBLE);
            rayer_B.setVisibility(View.INVISIBLE);
            budhi_grave.setVisibility(View.INVISIBLE);
            shat_mosq.setVisibility(View.INVISIBLE);
            mujibtomb.setVisibility(View.INVISIBLE);
            dhakes_tem.setVisibility(View.INVISIBLE);
            jainta.setVisibility(View.INVISIBLE);
            mujibnagar.setVisibility(View.INVISIBLE);
            sitaram.setVisibility(View.INVISIBLE);
            vobani.setVisibility(View.INVISIBLE);
             gnvbn.setVisibility(View.INVISIBLE);
            smallsn.setVisibility(View.INVISIBLE);
            chtmhr.setVisibility(View.INVISIBLE);
ell.setVisibility(View.INVISIBLE);
            mkhdum.setVisibility(View.INVISIBLE);
            etho_mus.setVisibility(View.INVISIBLE);

            View Sview = this.findViewById(R.id.image_armeniium);
            Sview.setBackgroundResource(R.drawable.armanium);
        }
        if(ptxt.equalsIgnoreCase("Shah Makhdum Mazar")){
            lalbag.setVisibility(View.INVISIBLE);
            songshod.setVisibility(View.INVISIBLE);
            shahid.setVisibility(View.INVISIBLE);
            sriti.setVisibility(View.INVISIBLE);
            carzon.setVisibility(View.INVISIBLE);
            rayer_B.setVisibility(View.INVISIBLE);
            budhi_grave.setVisibility(View.INVISIBLE);
            shat_mosq.setVisibility(View.INVISIBLE);
            mujibtomb.setVisibility(View.INVISIBLE);
            dhakes_tem.setVisibility(View.INVISIBLE);
            jainta.setVisibility(View.INVISIBLE);
            mujibnagar.setVisibility(View.INVISIBLE);
            sitaram.setVisibility(View.INVISIBLE);
            vobani.setVisibility(View.INVISIBLE);
            gnvbn.setVisibility(View.INVISIBLE);
            smallsn.setVisibility(View.INVISIBLE);
            chtmhr.setVisibility(View.INVISIBLE);
            ell.setVisibility(View.INVISIBLE);
            armenium.setVisibility(View.INVISIBLE);

            View Sview = this.findViewById(R.id.image_mkhdum);
            Sview.setBackgroundResource(R.drawable.shahmakhdum);
        }
       else if(ptxt.equalsIgnoreCase("Elliot Bridge")){
            lalbag.setVisibility(View.INVISIBLE);
            songshod.setVisibility(View.INVISIBLE);
            shahid.setVisibility(View.INVISIBLE);
            sriti.setVisibility(View.INVISIBLE);
            carzon.setVisibility(View.INVISIBLE);
            rayer_B.setVisibility(View.INVISIBLE);
            budhi_grave.setVisibility(View.INVISIBLE);
            shat_mosq.setVisibility(View.INVISIBLE);
            mujibtomb.setVisibility(View.INVISIBLE);
            dhakes_tem.setVisibility(View.INVISIBLE);
            jainta.setVisibility(View.INVISIBLE);
            mujibnagar.setVisibility(View.INVISIBLE);
            sitaram.setVisibility(View.INVISIBLE);
            vobani.setVisibility(View.INVISIBLE);
            gnvbn.setVisibility(View.INVISIBLE);
            smallsn.setVisibility(View.INVISIBLE);
            chtmhr.setVisibility(View.INVISIBLE);
            armenium.setVisibility(View.INVISIBLE);
            mkhdum.setVisibility(View.INVISIBLE);


            View Sview = this.findViewById(R.id.image_elli);
            Sview.setBackgroundResource(R.drawable.elliot_bridge);
        }
       else if(ptxt.equalsIgnoreCase("Chatmohor Shahi Mosque")){
            lalbag.setVisibility(View.INVISIBLE);
            songshod.setVisibility(View.INVISIBLE);
            shahid.setVisibility(View.INVISIBLE);
            sriti.setVisibility(View.INVISIBLE);
            carzon.setVisibility(View.INVISIBLE);
            rayer_B.setVisibility(View.INVISIBLE);
            budhi_grave.setVisibility(View.INVISIBLE);
            shat_mosq.setVisibility(View.INVISIBLE);
            mujibtomb.setVisibility(View.INVISIBLE);
            dhakes_tem.setVisibility(View.INVISIBLE);
            jainta.setVisibility(View.INVISIBLE);
            mujibnagar.setVisibility(View.INVISIBLE);
            sitaram.setVisibility(View.INVISIBLE);
            vobani.setVisibility(View.INVISIBLE);
            gnvbn.setVisibility(View.INVISIBLE);
            smallsn.setVisibility(View.INVISIBLE);
            armenium.setVisibility(View.INVISIBLE);
            ell.setVisibility(View.INVISIBLE);
            mkhdum.setVisibility(View.INVISIBLE);



            View Sview = this.findViewById(R.id.image_chatmohor);
            Sview.setBackgroundResource(R.drawable.chatmohor_shahi_mosque);
        }
       else if(ptxt.equalsIgnoreCase("Choto Sona Mosque")){
            lalbag.setVisibility(View.INVISIBLE);
            songshod.setVisibility(View.INVISIBLE);
            shahid.setVisibility(View.INVISIBLE);
            sriti.setVisibility(View.INVISIBLE);
            carzon.setVisibility(View.INVISIBLE);
            rayer_B.setVisibility(View.INVISIBLE);
            budhi_grave.setVisibility(View.INVISIBLE);
            shat_mosq.setVisibility(View.INVISIBLE);
            mujibtomb.setVisibility(View.INVISIBLE);
            dhakes_tem.setVisibility(View.INVISIBLE);
            jainta.setVisibility(View.INVISIBLE);
            mujibnagar.setVisibility(View.INVISIBLE);
            sitaram.setVisibility(View.INVISIBLE);
            vobani.setVisibility(View.INVISIBLE);
            gnvbn.setVisibility(View.INVISIBLE);
            armenium.setVisibility(View.INVISIBLE);
            chtmhr.setVisibility(View.INVISIBLE);
            ell.setVisibility(View.INVISIBLE);
            mkhdum.setVisibility(View.INVISIBLE);


            View Sview = this.findViewById(R.id.image_smallsona);
            Sview.setBackgroundResource(R.drawable.choto_sona);
        }
       else if(ptxt.equalsIgnoreCase("Uttora Gononvobon")){
            lalbag.setVisibility(View.INVISIBLE);
            songshod.setVisibility(View.INVISIBLE);
            shahid.setVisibility(View.INVISIBLE);
            sriti.setVisibility(View.INVISIBLE);
            carzon.setVisibility(View.INVISIBLE);
            rayer_B.setVisibility(View.INVISIBLE);
            budhi_grave.setVisibility(View.INVISIBLE);
            shat_mosq.setVisibility(View.INVISIBLE);
            mujibtomb.setVisibility(View.INVISIBLE);
            dhakes_tem.setVisibility(View.INVISIBLE);
            jainta.setVisibility(View.INVISIBLE);
            mujibnagar.setVisibility(View.INVISIBLE);
            sitaram.setVisibility(View.INVISIBLE);
            vobani.setVisibility(View.INVISIBLE);
            armenium.setVisibility(View.INVISIBLE);
            smallsn.setVisibility(View.INVISIBLE);
            chtmhr.setVisibility(View.INVISIBLE);
            ell.setVisibility(View.INVISIBLE);
            mkhdum.setVisibility(View.INVISIBLE);


            View Sview = this.findViewById(R.id.image_gonovbn);
            Sview.setBackgroundResource(R.drawable.uttora_gonovobon);
        }
       else if(ptxt.equalsIgnoreCase("Rani Vobani Palace")){
            lalbag.setVisibility(View.INVISIBLE);
            songshod.setVisibility(View.INVISIBLE);
            shahid.setVisibility(View.INVISIBLE);
            sriti.setVisibility(View.INVISIBLE);
            carzon.setVisibility(View.INVISIBLE);
            rayer_B.setVisibility(View.INVISIBLE);
            budhi_grave.setVisibility(View.INVISIBLE);
            shat_mosq.setVisibility(View.INVISIBLE);
            mujibtomb.setVisibility(View.INVISIBLE);
            dhakes_tem.setVisibility(View.INVISIBLE);
            jainta.setVisibility(View.INVISIBLE);
            mujibnagar.setVisibility(View.INVISIBLE);
            sitaram.setVisibility(View.INVISIBLE);
            armenium.setVisibility(View.INVISIBLE);
            gnvbn.setVisibility(View.INVISIBLE);
            smallsn.setVisibility(View.INVISIBLE);
            chtmhr.setVisibility(View.INVISIBLE);
            ell.setVisibility(View.INVISIBLE);
            mkhdum.setVisibility(View.INVISIBLE);

            View Sview = this.findViewById(R.id.image_vobani);
            Sview.setBackgroundResource(R.drawable.ranivobani);
        }

        else if(ptxt.equalsIgnoreCase("Curzon Hall")){

            lalbag.setVisibility(View.INVISIBLE);
            shahid.setVisibility(View.INVISIBLE);
            sriti.setVisibility(View.INVISIBLE);
            songshod.setVisibility(View.INVISIBLE);
            armenium.setVisibility(View.INVISIBLE);
            rayer_B.setVisibility(View.INVISIBLE);
            budhi_grave.setVisibility(View.INVISIBLE);
            shat_mosq.setVisibility(View.INVISIBLE);
            mujibtomb.setVisibility(View.INVISIBLE);
            dhakes_tem.setVisibility(View.INVISIBLE);
            etho_mus.setVisibility(View.INVISIBLE);
            jainta.setVisibility(View.INVISIBLE);
            mujibnagar.setVisibility(View.INVISIBLE);
            sitaram.setVisibility(View.INVISIBLE);
            vobani.setVisibility(View.INVISIBLE);
            gnvbn.setVisibility(View.INVISIBLE);
            smallsn.setVisibility(View.INVISIBLE);
            chtmhr.setVisibility(View.INVISIBLE);
            ell.setVisibility(View.INVISIBLE);
            mkhdum.setVisibility(View.INVISIBLE);

            View Sview = this.findViewById(R.id.image_carzon);
            Sview.setBackgroundResource(R.drawable.carzonhall);
        }
        else if(ptxt.equalsIgnoreCase("Lalbagh Kella")){

            lalbag.setVisibility(View.INVISIBLE);
            shahid.setVisibility(View.INVISIBLE);
            sriti.setVisibility(View.INVISIBLE);
            songshod.setVisibility(View.INVISIBLE);
            armenium.setVisibility(View.INVISIBLE);
            rayer_B.setVisibility(View.INVISIBLE);
            budhi_grave.setVisibility(View.INVISIBLE);
            shat_mosq.setVisibility(View.INVISIBLE);
            mujibtomb.setVisibility(View.INVISIBLE);
            dhakes_tem.setVisibility(View.INVISIBLE);
            etho_mus.setVisibility(View.INVISIBLE);
            jainta.setVisibility(View.INVISIBLE);
            mujibnagar.setVisibility(View.INVISIBLE);
            sitaram.setVisibility(View.INVISIBLE);
            vobani.setVisibility(View.INVISIBLE);
            gnvbn.setVisibility(View.INVISIBLE);
            smallsn.setVisibility(View.INVISIBLE);
            chtmhr.setVisibility(View.INVISIBLE);
            ell.setVisibility(View.INVISIBLE);
            mkhdum.setVisibility(View.INVISIBLE);

            View Sview = this.findViewById(R.id.image_lalbag);
            Sview.setBackgroundResource(R.drawable.lalbagh_fort);
        }
        else if(ptxt.equalsIgnoreCase("Shahid Minar")){

            carzon.setVisibility(View.INVISIBLE);
            lalbag.setVisibility(View.INVISIBLE);
            sriti.setVisibility(View.INVISIBLE);
            songshod.setVisibility(View.INVISIBLE);
            armenium.setVisibility(View.INVISIBLE);
            rayer_B.setVisibility(View.INVISIBLE);
            budhi_grave.setVisibility(View.INVISIBLE);
            shat_mosq.setVisibility(View.INVISIBLE);
            mujibtomb.setVisibility(View.INVISIBLE);
            dhakes_tem.setVisibility(View.INVISIBLE);
            etho_mus.setVisibility(View.INVISIBLE);
            jainta.setVisibility(View.INVISIBLE);
            mujibnagar.setVisibility(View.INVISIBLE);
            sitaram.setVisibility(View.INVISIBLE);
            vobani.setVisibility(View.INVISIBLE);
            gnvbn.setVisibility(View.INVISIBLE);
            smallsn.setVisibility(View.INVISIBLE);
            chtmhr.setVisibility(View.INVISIBLE);
            ell.setVisibility(View.INVISIBLE);
            mkhdum.setVisibility(View.INVISIBLE);

            View Sview = this.findViewById(R.id.image_shahidminar);
            Sview.setBackgroundResource(R.drawable.shahidminar);
        }
        else if(ptxt.equalsIgnoreCase("National Parliament House")){

            carzon.setVisibility(View.INVISIBLE);
            lalbag.setVisibility(View.INVISIBLE);
            sriti.setVisibility(View.INVISIBLE);
            shahid.setVisibility(View.INVISIBLE);
            armenium.setVisibility(View.INVISIBLE);
            rayer_B.setVisibility(View.INVISIBLE);
            budhi_grave.setVisibility(View.INVISIBLE);
            shat_mosq.setVisibility(View.INVISIBLE);
            mujibtomb.setVisibility(View.INVISIBLE);
            dhakes_tem.setVisibility(View.INVISIBLE);
            etho_mus.setVisibility(View.INVISIBLE);
            jainta.setVisibility(View.INVISIBLE);
            mujibnagar.setVisibility(View.INVISIBLE);
            sitaram.setVisibility(View.INVISIBLE);
            vobani.setVisibility(View.INVISIBLE);
            gnvbn.setVisibility(View.INVISIBLE);
            smallsn.setVisibility(View.INVISIBLE);
            chtmhr.setVisibility(View.INVISIBLE);
            ell.setVisibility(View.INVISIBLE);
            mkhdum.setVisibility(View.INVISIBLE);

            View Sview = this.findViewById(R.id.image_songshod);
            Sview.setBackgroundResource(R.drawable.assemblyvobon);
        }
        else if(ptxt.equalsIgnoreCase("National Martyr Memorial")){

            carzon.setVisibility(View.INVISIBLE);
            lalbag.setVisibility(View.INVISIBLE);
            songshod.setVisibility(View.INVISIBLE);
            shahid.setVisibility(View.INVISIBLE);
            armenium.setVisibility(View.INVISIBLE);
            rayer_B.setVisibility(View.INVISIBLE);
            budhi_grave.setVisibility(View.INVISIBLE);
            shat_mosq.setVisibility(View.INVISIBLE);
            mujibtomb.setVisibility(View.INVISIBLE);
            dhakes_tem.setVisibility(View.INVISIBLE);
            etho_mus.setVisibility(View.INVISIBLE);
            jainta.setVisibility(View.INVISIBLE);
            mujibnagar.setVisibility(View.INVISIBLE);
            sitaram.setVisibility(View.INVISIBLE);
            vobani.setVisibility(View.INVISIBLE);
            gnvbn.setVisibility(View.INVISIBLE);
            smallsn.setVisibility(View.INVISIBLE);
            chtmhr.setVisibility(View.INVISIBLE);
            ell.setVisibility(View.INVISIBLE);
            mkhdum.setVisibility(View.INVISIBLE);

            View Sview = this.findViewById(R.id.image_sriti);
            Sview.setBackgroundResource(R.drawable.sritisoudho);
        }
        else if(ptxt.equalsIgnoreCase("Rayer Bazar Bodhdhovumi")){

            lalbag.setVisibility(View.INVISIBLE);
            shahid.setVisibility(View.INVISIBLE);
            sriti.setVisibility(View.INVISIBLE);
            songshod.setVisibility(View.INVISIBLE);
            armenium.setVisibility(View.INVISIBLE);
            carzon.setVisibility(View.INVISIBLE);
            budhi_grave.setVisibility(View.INVISIBLE);
            shat_mosq.setVisibility(View.INVISIBLE);
            mujibtomb.setVisibility(View.INVISIBLE);
            dhakes_tem.setVisibility(View.INVISIBLE);
            etho_mus.setVisibility(View.INVISIBLE);
            jainta.setVisibility(View.INVISIBLE);
            mujibnagar.setVisibility(View.INVISIBLE);
            sitaram.setVisibility(View.INVISIBLE);
            vobani.setVisibility(View.INVISIBLE);
            gnvbn.setVisibility(View.INVISIBLE);
            smallsn.setVisibility(View.INVISIBLE);
            chtmhr.setVisibility(View.INVISIBLE);
            ell.setVisibility(View.INVISIBLE);
            mkhdum.setVisibility(View.INVISIBLE);

            View Sview = this.findViewById(R.id.image_raer);
            Sview.setBackgroundResource(R.drawable.rayerbajar);
        }
        else if(ptxt.equalsIgnoreCase("Shahid Buddhijibi Graveyard")){

            lalbag.setVisibility(View.INVISIBLE);
            shahid.setVisibility(View.INVISIBLE);
            sriti.setVisibility(View.INVISIBLE);
            songshod.setVisibility(View.INVISIBLE);
            armenium.setVisibility(View.INVISIBLE);
            carzon.setVisibility(View.INVISIBLE);
            rayer_B.setVisibility(View.INVISIBLE);
            shat_mosq.setVisibility(View.INVISIBLE);
            mujibtomb.setVisibility(View.INVISIBLE);
            dhakes_tem.setVisibility(View.INVISIBLE);
            etho_mus.setVisibility(View.INVISIBLE);
            jainta.setVisibility(View.INVISIBLE);
            mujibnagar.setVisibility(View.INVISIBLE);
            sitaram.setVisibility(View.INVISIBLE);
            vobani.setVisibility(View.INVISIBLE);
            gnvbn.setVisibility(View.INVISIBLE);
            smallsn.setVisibility(View.INVISIBLE);
            chtmhr.setVisibility(View.INVISIBLE);
            ell.setVisibility(View.INVISIBLE);
            mkhdum.setVisibility(View.INVISIBLE);

            View Sview = this.findViewById(R.id.image_budhijibi);
            Sview.setBackgroundResource(R.drawable.graveint);
        }

        else if(ptxt.equalsIgnoreCase("Shat Moshjid")){

            lalbag.setVisibility(View.INVISIBLE);
            shahid.setVisibility(View.INVISIBLE);
            sriti.setVisibility(View.INVISIBLE);
            songshod.setVisibility(View.INVISIBLE);
            armenium.setVisibility(View.INVISIBLE);
            carzon.setVisibility(View.INVISIBLE);
            rayer_B.setVisibility(View.INVISIBLE);
            budhi_grave.setVisibility(View.INVISIBLE);
            mujibtomb.setVisibility(View.INVISIBLE);
            dhakes_tem.setVisibility(View.INVISIBLE);
            etho_mus.setVisibility(View.INVISIBLE);
            jainta.setVisibility(View.INVISIBLE);
            mujibnagar.setVisibility(View.INVISIBLE);
            sitaram.setVisibility(View.INVISIBLE);
            vobani.setVisibility(View.INVISIBLE);
            gnvbn.setVisibility(View.INVISIBLE);
            smallsn.setVisibility(View.INVISIBLE);
            chtmhr.setVisibility(View.INVISIBLE);
            ell.setVisibility(View.INVISIBLE);
            mkhdum.setVisibility(View.INVISIBLE);

            View Sview = this.findViewById(R.id.image_7mosque);
            Sview.setBackgroundResource(R.drawable.saatmosque);
        }
        else if(ptxt.equalsIgnoreCase("Sheikh Mujibur Rahmans Tomb")){

            lalbag.setVisibility(View.INVISIBLE);
            shahid.setVisibility(View.INVISIBLE);
            sriti.setVisibility(View.INVISIBLE);
            songshod.setVisibility(View.INVISIBLE);
            armenium.setVisibility(View.INVISIBLE);
            carzon.setVisibility(View.INVISIBLE);
            rayer_B.setVisibility(View.INVISIBLE);
            budhi_grave.setVisibility(View.INVISIBLE);
           shat_mosq.setVisibility(View.INVISIBLE);
            dhakes_tem.setVisibility(View.INVISIBLE);
            etho_mus.setVisibility(View.INVISIBLE);
            jainta.setVisibility(View.INVISIBLE);
            mujibnagar.setVisibility(View.INVISIBLE);
            sitaram.setVisibility(View.INVISIBLE);
            vobani.setVisibility(View.INVISIBLE);
            gnvbn.setVisibility(View.INVISIBLE);
            smallsn.setVisibility(View.INVISIBLE);
            chtmhr.setVisibility(View.INVISIBLE);
            ell.setVisibility(View.INVISIBLE);
            mkhdum.setVisibility(View.INVISIBLE);

            View Sview = this.findViewById(R.id.image_mujibtomb);
            Sview.setBackgroundResource(R.drawable.sheikh_tomb);
        }
        else if(ptxt.equalsIgnoreCase("Dhakeshwari Temple")){

            lalbag.setVisibility(View.INVISIBLE);
            shahid.setVisibility(View.INVISIBLE);
            sriti.setVisibility(View.INVISIBLE);
            songshod.setVisibility(View.INVISIBLE);
            armenium.setVisibility(View.INVISIBLE);
            carzon.setVisibility(View.INVISIBLE);
            rayer_B.setVisibility(View.INVISIBLE);
            budhi_grave.setVisibility(View.INVISIBLE);
            shat_mosq.setVisibility(View.INVISIBLE);
            mujibtomb.setVisibility(View.INVISIBLE);
            etho_mus.setVisibility(View.INVISIBLE);
            jainta.setVisibility(View.INVISIBLE);
            mujibnagar.setVisibility(View.INVISIBLE);
            sitaram.setVisibility(View.INVISIBLE);
            vobani.setVisibility(View.INVISIBLE);
            gnvbn.setVisibility(View.INVISIBLE);
            smallsn.setVisibility(View.INVISIBLE);
            chtmhr.setVisibility(View.INVISIBLE);
            ell.setVisibility(View.INVISIBLE);
            mkhdum.setVisibility(View.INVISIBLE);

            View Sview = this.findViewById(R.id.image_dhakeshori);
            Sview.setBackgroundResource(R.drawable.dhakeshwari_mondir);
        }
        else if(ptxt.equalsIgnoreCase("Ethnological Museum")){

            lalbag.setVisibility(View.INVISIBLE);
            shahid.setVisibility(View.INVISIBLE);
            sriti.setVisibility(View.INVISIBLE);
            songshod.setVisibility(View.INVISIBLE);
            armenium.setVisibility(View.INVISIBLE);
            carzon.setVisibility(View.INVISIBLE);
            rayer_B.setVisibility(View.INVISIBLE);
            budhi_grave.setVisibility(View.INVISIBLE);
            shat_mosq.setVisibility(View.INVISIBLE);
            mujibtomb.setVisibility(View.INVISIBLE);
            dhakes_tem.setVisibility(View.INVISIBLE);
            jainta.setVisibility(View.INVISIBLE);
            sitaram.setVisibility(View.INVISIBLE);
            mujibnagar.setVisibility(View.INVISIBLE);
            vobani.setVisibility(View.INVISIBLE);
            gnvbn.setVisibility(View.INVISIBLE);
            smallsn.setVisibility(View.INVISIBLE);
            chtmhr.setVisibility(View.INVISIBLE);
            ell.setVisibility(View.INVISIBLE);
            mkhdum.setVisibility(View.INVISIBLE);

            View Sview = this.findViewById(R.id.image_ethono);
            Sview.setBackgroundResource(R.drawable.chittagong_ethnological_museum);

        }
        else if(ptxt.equalsIgnoreCase("Stone Monument of Jaintapur")){

            lalbag.setVisibility(View.INVISIBLE);
            shahid.setVisibility(View.INVISIBLE);
            sriti.setVisibility(View.INVISIBLE);
            songshod.setVisibility(View.INVISIBLE);
            armenium.setVisibility(View.INVISIBLE);
            carzon.setVisibility(View.INVISIBLE);
            rayer_B.setVisibility(View.INVISIBLE);
            budhi_grave.setVisibility(View.INVISIBLE);
            shat_mosq.setVisibility(View.INVISIBLE);
            mujibtomb.setVisibility(View.INVISIBLE);
            dhakes_tem.setVisibility(View.INVISIBLE);
etho_mus.setVisibility(View.INVISIBLE);
            mujibnagar.setVisibility(View.INVISIBLE);
            sitaram.setVisibility(View.INVISIBLE);
            vobani.setVisibility(View.INVISIBLE);
            gnvbn.setVisibility(View.INVISIBLE);
            smallsn.setVisibility(View.INVISIBLE);
            chtmhr.setVisibility(View.INVISIBLE);
            ell.setVisibility(View.INVISIBLE);
            mkhdum.setVisibility(View.INVISIBLE);

            View Sview = this.findViewById(R.id.image_jointa);
            Sview.setBackgroundResource(R.drawable.jaintapur);
        }
        else if(ptxt.equalsIgnoreCase("Mujibnogor Memorial")){

            lalbag.setVisibility(View.INVISIBLE);
            shahid.setVisibility(View.INVISIBLE);
            sriti.setVisibility(View.INVISIBLE);
            songshod.setVisibility(View.INVISIBLE);
            armenium.setVisibility(View.INVISIBLE);
            carzon.setVisibility(View.INVISIBLE);
            rayer_B.setVisibility(View.INVISIBLE);
            budhi_grave.setVisibility(View.INVISIBLE);
            shat_mosq.setVisibility(View.INVISIBLE);
            mujibtomb.setVisibility(View.INVISIBLE);
            dhakes_tem.setVisibility(View.INVISIBLE);
            etho_mus.setVisibility(View.INVISIBLE);
            jainta.setVisibility(View.INVISIBLE);
            sitaram.setVisibility(View.INVISIBLE);
            vobani.setVisibility(View.INVISIBLE);
            gnvbn.setVisibility(View.INVISIBLE);
            smallsn.setVisibility(View.INVISIBLE);
            chtmhr.setVisibility(View.INVISIBLE);
            ell.setVisibility(View.INVISIBLE);
            mkhdum.setVisibility(View.INVISIBLE);

            View Sview = this.findViewById(R.id.image_mujibnogor);
            Sview.setBackgroundResource(R.drawable.mujibnagar_memorial);
        }
        else if(ptxt.equalsIgnoreCase("Sitaram Palace")){

            lalbag.setVisibility(View.INVISIBLE);
            shahid.setVisibility(View.INVISIBLE);
            sriti.setVisibility(View.INVISIBLE);
            songshod.setVisibility(View.INVISIBLE);
            armenium.setVisibility(View.INVISIBLE);
            carzon.setVisibility(View.INVISIBLE);
            rayer_B.setVisibility(View.INVISIBLE);
            budhi_grave.setVisibility(View.INVISIBLE);
            shat_mosq.setVisibility(View.INVISIBLE);
            mujibtomb.setVisibility(View.INVISIBLE);
            dhakes_tem.setVisibility(View.INVISIBLE);
            etho_mus.setVisibility(View.INVISIBLE);
            jainta.setVisibility(View.INVISIBLE);
            mujibnagar.setVisibility(View.INVISIBLE);
            vobani.setVisibility(View.INVISIBLE);
            gnvbn.setVisibility(View.INVISIBLE);
            smallsn.setVisibility(View.INVISIBLE);
            chtmhr.setVisibility(View.INVISIBLE);
            ell.setVisibility(View.INVISIBLE);

            mkhdum.setVisibility(View.INVISIBLE);
            View Sview = this.findViewById(R.id.image_sitaram);
            Sview.setBackgroundResource(R.drawable.sitarampur);
        }

    }


}
