package com.nuig;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import android.os.Environment;
import android.util.Log;

public class MyFile
{
	private File root;
	private File file;
	private BufferedWriter out;
	private BufferedReader in;

	public MyFile()
	{
		root = Environment.getExternalStorageDirectory();
	}

	// Method: Used to create new file
	public void createFile(String fileName) {
		try {
			if (root.canWrite()) {
				file = new File(root, "//" + fileName);
				if (!file.exists()) {
					file.createNewFile();
				}
			}
		} catch (IOException e) {
			Log.e("Error", "Failed to create a new file");
		}

	}

	// Method: Used to read the contents of a file
	public String read(String fileName)
	{
		StringBuilder returnString = new StringBuilder();
		try {
			FileReader dataWriter = new FileReader(file);
			in = new BufferedReader(dataWriter);
			if (file.exists()) {
				String str = null;
				while((str = in.readLine()) != null)
				{
					returnString.append(str + "\n");
				}
			}
			in.close();
		} catch (IOException e) {
			Log.e("Error", "Failed to write file");
		}
		return returnString.toString();
	}

	// Method: Used to write text to a file
	public void write(String message) {
		try {
			if (out == null) {
				out = new BufferedWriter(new FileWriter(file));
			}
			if (file.exists()) {
				out.write(message);
				out.newLine();
				out.flush();
			}
		} catch (IOException e) {
			Log.e("Error", "Failed to write file");
		}
	}

	// Method: Used to close the writing operation
	public void close() {
		try {
			out.close();
		} catch (IOException e) {
			Log.e("Error", "Failed to close file");
		}
	}

}
