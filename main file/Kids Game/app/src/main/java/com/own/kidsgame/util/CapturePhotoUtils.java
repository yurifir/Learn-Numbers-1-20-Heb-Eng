package com.own.kidsgame.util;

import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.format.Time;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CapturePhotoUtils {
    public static File file;
    public static Uri uriToImage;
    public static Uri url;

    public static final String insertImage(Context context, ContentResolver contentResolver, Bitmap bitmap, String str, String str2) {
        Time time = new Time(Time.getCurrentTimezone());
        time.setToNow();
        File file2 = new File(new ContextWrapper(context).getDir("gallery", 0), (time.year + time.month + 1 + time.monthDay) + "_" + time.hour + time.minute + time.second + ".jpeg");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            file = file2;
            return file2.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
