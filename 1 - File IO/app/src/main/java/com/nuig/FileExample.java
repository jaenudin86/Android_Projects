package com.nuig;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import java.security.KeyStore;

public class FileExample extends Activity {

	private TextView myTextView;

	/* Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		myTextView = new TextView(this);
		setContentView(myTextView);
		// Create a new file
		MyFile file = new MyFile();
		String fileName = "Android_Lab1.txt";
		file.createFile(fileName);
		// Write text to a file
		file.write("Name: Thomas Reaney");
		file.write("ID: 13436018");
		file.write("Course: Electronic & Computer Engineering");
		// Close file write operation
		file.close();
		// Read text from a file
		String readOutput = file.read(fileName);
		// Add text to application
		myTextView.setText(readOutput);
		myTextView.setTextColor(Color.MAGENTA);
		myTextView.setBackgroundColor(Color.GRAY);
	}
}