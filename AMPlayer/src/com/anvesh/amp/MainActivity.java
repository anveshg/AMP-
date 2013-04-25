package com.anvesh.amp;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	int elt,tot;
	Button button;
	MediaPlayer musicplayer;
	TextView textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final Button playButton = (Button) findViewById(R.id.button1);
		final Button pauseButton = (Button) findViewById(R.id.button2);
		final Button stopButton = (Button) findViewById(R.id.button3);
		final Button ffButton = (Button) findViewById(R.id.button5);
		final Button rewButton = (Button) findViewById(R.id.button4);
		final TextView elapsd = (TextView) findViewById(R.id.textView1);
		final TextView totl = (TextView) findViewById(R.id.textView2);

		musicplayer = MediaPlayer.create(getApplicationContext(), R.raw.livey);
		elt= musicplayer.getCurrentPosition();
		tot=musicplayer.getDuration();

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
