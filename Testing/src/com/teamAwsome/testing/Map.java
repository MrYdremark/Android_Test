package com.teamAwsome.testing;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class Map extends MapActivity {
	
	MyLocationOverlay me;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);
		
		final MapView mapView = (MapView) findViewById(R.id.mapview);
		mapView.setBuiltInZoomControls(true);
		
		final MapController control = mapView.getController();
		
		LocationManager manager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		
		LocationListener listener = new LocationListener() {
			
			public void onLocationChanged(Location location) {
				GeoPoint point = new GeoPoint((int)(location.getLatitude()*1E6), (int)(location.getLongitude()*1E6));
				control.setCenter(point);
			}

			public void onProviderDisabled(String arg0) {
				// TODO Auto-generated method stub	
			}

			public void onProviderEnabled(String arg0) {
				// TODO Auto-generated method stub	
			}

			public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
				// TODO Auto-generated method stub
			}
		};
		
		manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
		
		List<Overlay> mapOverlays = mapView.getOverlays();
		Drawable drawable = this.getResources().getDrawable(R.drawable.pin);
		MyItemizedOverlay itemizedoverlay = new MyItemizedOverlay(drawable, this);
		// Get coordinates from server and put in GeoPoint to draw pin on map
		// Latitude and longitude position from server into these ints.
		int friendPosLat, friendPosLong;
		friendPosLat = 58395516;
		friendPosLong = 15578195;
		// GeoPoint(Lat, Long)
		GeoPoint point = new GeoPoint(friendPosLat, friendPosLong);
		OverlayItem overlayitem = new OverlayItem(point, "Lunch", "Lunchar på pastavagnen");
		
		itemizedoverlay.addOverlay(overlayitem);
		mapOverlays.add(itemizedoverlay);
		
		me = new MyLocationOverlay(this, mapView);
		mapView.getOverlays().add(me);
		
	}	

	@Override
	protected void onPause() {
		super.onPause();
		me.disableMyLocation();
	}

	@Override
	protected void onResume() {
		super.onResume();
		me.enableMyLocation();
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	     menu.add(1, 1, 0, "Friends").setIcon(R.drawable.friends);
	     menu.add(1, 2, 1, "Groups").setIcon(R.drawable.group);
	     menu.add(1, 3, 2, "Exit").setIcon(R.drawable.exit);
	     menu.add(1, 4, 3, "Settings").setIcon(R.drawable.settings);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case 1:
			Intent friends = new Intent("com.teamAwsome.testing.FRIENDS");
			startActivity(friends);
			return true;	
		case 2:
			Intent groups = new Intent("com.teamAwsome.testing.GROUPS");
			startActivity(groups);
			return true;
		case 3:
			Intent exit = new Intent("com.teamAwsome.testing.LOGIN");
			startActivity(exit);
			return true;
		case 4:
			Intent settings = new Intent("com.teamAwsome.testing.SETTINGS");
			startActivity(settings);
			return true;	
		}
		return super.onOptionsItemSelected(item);
	}
	
}
