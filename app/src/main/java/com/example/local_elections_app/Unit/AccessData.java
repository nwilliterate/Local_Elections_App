package com.example.local_elections_app.Unit;

import android.content.Context;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AccessData {

    public static byte[] retrieveData(Context ctx, String file) {
        byte[] data = null;
        try {
            int bytesRead = 0;
            FileInputStream fis = ctx.openFileInput(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            while ((bytesRead = fis.read(b)) != -1) {
                bos.write(b, 0, bytesRead);
            }
            data = bos.toByteArray();

        } catch (FileNotFoundException e) {
            Log.e("SE2", "Exception: " + e.getMessage());
        } catch (IOException e) {
            Log.e("SE2", "Exception: " + e.getMessage());
        }
        return data;
    }

    public static void storeData(byte[] data, Context ctx, String file) {

        try {
            FileOutputStream fos = ctx.openFileOutput(file, ctx.MODE_PRIVATE);
            fos.write(data);
            fos.close();
        } catch (FileNotFoundException e) {
            Log.e("SE2", "Exception: " + e.getMessage());
        } catch (IOException e) {
            Log.e("SE2", "Exception: " + e.getMessage());
        }
    }

}
