package com.example.asynctackdemo;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ProgressBar_DEMO extends AsyncTask<String, Integer, Bitmap> {

    @SuppressLint("StaticFieldLeak")
    private ProgressBar mProgressBar;
    @SuppressLint("StaticFieldLeak")
    private ImageView mImageView;
    private Bitmap mBitmap;

    ProgressBar_DEMO(ProgressBar progressBar, ImageView imageView) {
        mProgressBar = progressBar;
        mImageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        for (int i = 0; i <= 100; i++) {
            publishProgress(i);
            if (i == 100) {
                try {
                    URL url = new URL(strings[0]);
                    InputStream inputStream = url.openConnection().getInputStream();
                    mBitmap = BitmapFactory.decodeStream(inputStream);
                    Log.d("L","DONE");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return mBitmap;
    }

    @Override
    protected void onPreExecute() {
        mProgressBar.setMax(100);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        mImageView.setImageBitmap(mBitmap);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        mProgressBar.setProgress(values[0]);
    }
}
