package co.example.um2.aigle.alo.Common.Commerce;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import co.example.um2.aigle.alo.R;

public class VendreActivity extends AppCompatActivity implements LocationListener {

    private EditText itemNom, itemDescription, itemPrix;
    private TextView longitude, lattitude;
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendre);

        itemNom = (EditText) findViewById(R.id.itemNom);
        itemDescription = (EditText) findViewById(R.id.itemDescription);
        itemPrix = (EditText) findViewById(R.id.itemPrix);
        longitude = (TextView) findViewById(R.id.longitude);
        lattitude = (TextView) findViewById(R.id.lattitude);

        locationManager = (LocationManager) this.getApplicationContext().getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        if(locationManager == null){
            Log.d("ERREUR DE NULLISSISME", "NULL");
        }
        try{
            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            longitude.setText(location.getLongitude()+"");
            lattitude.setText(location.getLatitude()+"");
        }catch (Exception e){
            this.finish();
            Log.d("Error ?!!!!!!!!!!!!!", e.getMessage());
        }

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
