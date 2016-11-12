package com.nuig;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class FileExample extends Activity {

	private TextView myTextView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		myTextView = new TextView(this);
		setContentView(myTextView);

	}
}