package com.example.asynctackdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mProgressBar = findViewById(R.id.progressBar);
        mImageView = findViewById(R.id.image_loadImage);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.button_start) {
            new ProgressBar_DEMO(mProgressBar, mImageView).execute(getString(R.string.image_ghoul));
        }
    }
}
