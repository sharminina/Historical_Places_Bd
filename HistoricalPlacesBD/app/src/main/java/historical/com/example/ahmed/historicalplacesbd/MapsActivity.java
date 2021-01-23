package historical.com.example.ahmed.historicalplacesbd;

import java.io.IOException;
import java.util.List;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import android.app.Dialog;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MapsActivity extends FragmentActivity {

    Button go;

    private static final int GPS_ERRORDIALOGE_REQUEST = 9001;
    GoogleMap mMap;

    private static final double DHAKA_LAT = 23.814013,
            DHAKA_LAN = 90.408854;

    private static float defultzoom = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (servicesOK()) {

            setContentView(R.layout.draw_map);

            if(initMap()){
                Toast.makeText(this, "Ready to Map", Toast.LENGTH_SHORT).show();
                gotoLocation(DHAKA_LAT, DHAKA_LAN, defultzoom);
            }
            else{
                Toast.makeText(this, "Map not avilable", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            setContentView(R.layout.activity_maps);
        }

        go = (Button) findViewById(R.id.go);

        go.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                geoLocate(v);
            }
        });
    }

    private void gotoLocation(double lat, double lng, float zoom) {
        // TODO Auto-generated method stub
        LatLng ll = new LatLng(lat, lng);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(ll, zoom);
        mMap.moveCamera(update);
    }

    public boolean servicesOK(){
        int isAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);

        if (isAvailable == ConnectionResult.SUCCESS){
            return true;
        }
        else if(GooglePlayServicesUtil.isUserRecoverableError(isAvailable)){
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(isAvailable, this, GPS_ERRORDIALOGE_REQUEST);
            dialog.show();
        }
        else{
            Toast.makeText(this, "Google Map not avialable", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    private boolean initMap(){
        if(mMap == null){
            SupportMapFragment mapFrag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
            mMap = mapFrag.getMap();
        }
        return (mMap != null);
    }

    public void geoLocate(View v){
        try{
            hideSoftKeyboard(v);

            EditText et = (EditText) findViewById(R.id.edtloc);
            String loc = et.getText()+"";
            Geocoder gc = new Geocoder(this);
            List<Address> list = gc.getFromLocationName(loc, 1);
            Address add = list.get(0);
            String locality = add.getLocality();
            Toast.makeText(this, locality, Toast.LENGTH_SHORT).show();

            double lat = add.getLatitude();
            double lng = add.getLongitude();

            gotoLocation(lat, lng, defultzoom);

        }catch(Exception e){
            Toast.makeText(this, "Location not found", Toast.LENGTH_SHORT).show();
        }
    }

    private void hideSoftKeyboard(View v) {
        // TODO Auto-generated method stub
        InputMethodManager inputManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
    }

}
