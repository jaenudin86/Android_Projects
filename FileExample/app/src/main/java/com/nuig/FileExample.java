package com.nuig;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

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
		// Write two lines to a file
		file.write("Thomas Reaney (Electronic & Computer Engineering Student)");
		file.write("Darragh Moran (Electronic & Computer Engineering Student)");
		// Close file write operation
		file.close();
		// Read text from a file
		String readOutput = file.read(fileName);
		// Add text to application
		myTextView.setText(readOutput);
		myTextView.setTextColor(Color.BLUE);
		myTextView.setBackgroundColor(Color.GRAY);
	}
}