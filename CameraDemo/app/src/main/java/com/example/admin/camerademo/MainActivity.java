package com.example.admin.camerademo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

import junit.framework.Test;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Uri uri;
    private VideoView vdoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_vdo);
//        findViewForImage();

        findViewForVdo();
    }

    public void findViewForImage() {
        imageView = (ImageView) findViewById(R.id.imageview);
        Button button = (Button) findViewById(R.id.btnclick);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                takePicture();
            }
        });
    }

    public void findViewForVdo() {
        vdoView = (VideoView) findViewById(R.id.vdoView);
        Button button = (Button) findViewById(R.id.btnclick);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                captureVideo();
            }
        });
    }

    private void takePicture() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 100);

    }

    private void captureVideo() {
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        uri = Uri.fromFile(new File(Environment.getExternalStorageDirectory() + "/" + "Test.mp4"));
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startActivityForResult(intent, 200);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 100) {
            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap) bundle.get("data");
            imageView.setImageBitmap(bitmap);
        } else if (requestCode == 200) {
            vdoView.setVideoPath(uri.getPath());
            vdoView.start();
        }

    }
}
