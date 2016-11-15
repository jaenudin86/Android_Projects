package com.example.gps.app2_gps;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtility {

    private File root;
    private File file;

    public FileUtility() {
        root = Environment.getExternalStorageDirectory();
    }

    public void createFile(Context context, String fileName) {
        try {
            if (root.canWrite()) {
                file = new File(root, "//" + fileName);
                if (!file.exists()) {
                    file.createNewFile();
                }
            }
            else
            {
                file = new File(context.getFilesDir(), "//" + fileName); // File(root, "//" + fileName);
                if (!file.exists()) {
                    file.createNewFile();
                }
            }
        } catch (IOException e) {
            Log.e("Error", "fail to create a new file");
        }

    }

    public String readAll() {
        StringBuilder returnString = new StringBuilder();
        try {
            BufferedReader in;
            FileReader datawriter = new FileReader(file);
            in = new BufferedReader(datawriter);
            if (file.exists()) {
                String str = null;
                while((str=in.readLine())!=null) {
                    returnString.append(str).append("\n");
                }
            }
            in.close();
        } catch (IOException e) {
            Log.e("Error", "fail to write file");
        }
        return returnString.toString();
    }

    public void writeLine(String message) {
        try {
            BufferedWriter out;
            FileWriter datawriter = new FileWriter(file,true);
            out = new BufferedWriter(datawriter);
            if (file.exists()) {
                out.write(message + "\n");
                out.flush();
            }
            out.close();
        } catch (IOException e) {
            Log.e("Error", "fail to write file");
        }
    }

}
