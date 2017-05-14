package com.shc.SHC_SS.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.shc.SHC_SS.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String KEY_LAT_LONG = "LAT_LONG";

    private GoogleMap mMap;
    private LatLng mLatLng;

    public static void start(Context context, LatLng latLng) {
        Intent starter = new Intent(context, MapsActivity.class);
        starter.putExtra(KEY_LAT_LONG, latLng);
        context.startActivity(starter);
    }

    public static void start(Context context, double lat, double lang) {
        Intent starter = new Intent(context, MapsActivity.class);
        starter.putExtra(KEY_LAT_LONG, new LatLng(lat, lang));
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        if (savedInstanceState != null && savedInstanceState.getParcelable(KEY_LAT_LONG) != null)
            mLatLng = savedInstanceState.getParcelable(KEY_LAT_LONG);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (mMap == null) return;
//        if no lat and long add marker in KSA
        if (mLatLng == null)
            mLatLng = new LatLng(24.774265, 46.738586);
        mMap.addMarker(new MarkerOptions().position(mLatLng).title("Marker in KSA"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mLatLng, 15));
        UiSettings uiSettings = mMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);
        uiSettings.setZoomGesturesEnabled(true);
    }
}
