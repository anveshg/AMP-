package com.anvesh.amp;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	int elt,tot;
	Button button;
	MediaPlayer musicplayer;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//Inits
		final Button playButton = (Button) findViewById(R.id.button1);
		final Button pauseButton = (Button) findViewById(R.id.button2);
		final Button stopButton = (Button) findViewById(R.id.button3);
		final Button ffButton = (Button) findViewById(R.id.button5);
		final Button rewButton = (Button) findViewById(R.id.button4);
		final Button weatherButton = (Button) findViewById(R.id.button6);
		musicplayer = MediaPlayer.create(getApplicationContext(), R.raw.livey);
	
	
//Location 
		//reference to the system   location manager  
		LocationManager locatonManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);  
		Location location;
		double latitude; // latitude
	    double longitude; // longitude

 
		LocationListener locationListener = new LocationListener() {  

			@Override  
			public void onStatusChanged(String provider, int status, Bundle extras) {  

				//Toast.makeText(getApplicationContext(), "provider status changed", Toast.LENGTH_LONG).show();  

			}  

			@Override  
			public void onProviderEnabled(String provider) {  

				//Toast.makeText(getApplicationContext(), "Provider enabled", Toast.LENGTH_LONG).show();  

			}  

			@Override  
			public void onProviderDisabled(String provider) {  

				//Toast.makeText(getApplicationContext(), "Provider disabled", Toast.LENGTH_LONG).show();  

			}  

			@Override  
			public void onLocationChanged(Location location) {  

				//Toast.makeText(getApplicationContext(), "New Location", Toast.LENGTH_LONG).show();  
			}};


			weatherButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View vone) {

				}
			});
			//Register location manager with the listener  
			locatonManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);  
			//locatonManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);  


//Media Player
			playButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View vone) {
					Toast.makeText(getApplicationContext(), "Playing", Toast.LENGTH_LONG).show();
					musicplayer.start();
				}
			});

			pauseButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View vtwo) {
					musicplayer.pause();
					Toast.makeText(getApplicationContext(), "Pausing", Toast.LENGTH_LONG).show();
				}
			});

			stopButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View vthree) {
					musicplayer.stop();
					Toast.makeText(getApplicationContext(), "Stopping", Toast.LENGTH_LONG).show();
					musicplayer.prepareAsync();
					musicplayer.seekTo(0);

				}
			});

			rewButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View vfour) {
					if(musicplayer.isPlaying())
					{
						musicplayer.seekTo(musicplayer.getCurrentPosition() - 5000);
					}

				}
			});

			ffButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View vfive) {
					if(musicplayer.isPlaying())
					{
						musicplayer.seekTo(musicplayer.getCurrentPosition() + 5000);
					}

				}
			});

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


}
