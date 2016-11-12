package com.nuig;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import android.os.Environment;
import android.util.Log;

public class MyFile {

	private File root;
	private File file;
	private BufferedWriter out;

	public MyFile() {
		root = Environment.getExternalStorageDirectory();
	}

	public void createFile(String fileName) {
		try {
			if (root.canWrite()) {
				file = new File(root, "//" + fileName);
				if (!file.exists()) {
					file.createNewFile();
				}
			}
		} catch (IOException e) {
			Log.e("Error", "fail to create a new file");
		}

	}

	public void read(String fileName) {
	}

	public void write(String message) {
		try {
			if (out == null) {
				FileWriter datawriter = new FileWriter(file);
				out = new BufferedWriter(datawriter);
			}
			if (file.exists()) {
				out.write(message);
				out.flush();
			}
		} catch (IOException e) {
			Log.e("Error", "fail to write file");
		}
	}

	public void close() {
		try {
			out.close();
		} catch (IOException e) {
			Log.e("Error", "fail to close file");
		}
	}

}
