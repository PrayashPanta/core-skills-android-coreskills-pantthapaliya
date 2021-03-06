package csci.cs.twu.edu.coreskills;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

/**

 Assignment Notes: For this activity, we are embedding the LocationListener
 in this Activity, instead of creating a separate GPS class.  The code is basically
 the same, but is a bit easier to reference here.  You can find more info on
 how to do a LocationListener in the Service example code :

 https://gitlab.com/csci3313sp20/serviceexample


 */

public class GPSActivity extends AppCompatActivity implements LocationListener {

    LocationManager locationManager;
    private static final int TAKE_PHOTO_PERMISSION = 1;

    TextView latTextView;
    TextView lonTextView;

    Double currentLat;
    Double currentLon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        latTextView = (TextView) findViewById(R.id.latTextView);
        lonTextView = (TextView) findViewById(R.id.lonTextView);

        // Here is the code to handle permissions - you should not need to edit this.
        if (Build.VERSION.SDK_INT >= 27 &&
                ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, TAKE_PHOTO_PERMISSION);
        }

    }

    public void startGPS(View view) {


        // Add code here to register the listener with the Location Manager to receive location updates


        locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }


        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, this);




    }


    @Override
    public void onLocationChanged(Location location) {

        // Add code here to do stuff when the location changes
        currentLat = location.getLatitude();
        currentLon = location.getLongitude();

        latTextView.setText("Current Latitude: " + currentLat);
        lonTextView.setText("Current Longitude: " + currentLon);

        try{
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            List<Address> addressList = geocoder.getFromLocation(currentLat,currentLon,1);
            String address = addressList.get(0).getAddressLine(0);
            Toast.makeText(this,"Current Address is: " + address, Toast.LENGTH_LONG).show();


        } catch (Exception e){
            e.printStackTrace();

        }

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {}

    @Override
    public void onProviderEnabled(String s) {}

    @Override
    public void onProviderDisabled(String s) {}
}
