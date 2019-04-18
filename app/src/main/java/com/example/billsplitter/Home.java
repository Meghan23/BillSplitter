package com.example.billsplitter;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.util.Calendar;

public class Home extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;

    private String directoryPathOriginal;
    private String filePathOriginal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button manual, camera;
        manual = findViewById(R.id.manual);
        manual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, Order.class);
                startActivity(i);
            }
        });

        camera = findViewById(R.id.camera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
                }
                else {
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                }
                */
                Intent i = new Intent(Home.this, ocr.class);
                startActivity(i);

            }
        });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_PERMISSION_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(cameraIntent);
                Log.d("pic captured","lolll");
                String temp = cameraIntent.getDataString();
                Log.d("temp",temp);
                Bitmap photo = (Bitmap)cameraIntent.getExtras().get("data");
                Log.d("pic captured","MYpic captured!!");
                imageView.setImageBitmap(photo);
                Log.d("pic captured","pic captured!!");
            } else {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }

        protected void onActivityResult(Intent data)
        {
                /*
                Bitmap photo = (Bitmap)data.getExtras().get("data");
                Log.d("pic captured","MYpic captured!!");
                imageView.setImageBitmap(photo);
                Log.d("pic captured","pic captured!!");


                File directory = null;

                directory = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator );
                if(!directory.exists()) {
                    directory.mkdirs();
                }
                this.filePathOriginal = directory.getAbsolutePath();
                data.putExtra("output", Uri.fromFile(new File(this.filePathOriginal)));
                */


        }


        /*
        private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
        */
    }




