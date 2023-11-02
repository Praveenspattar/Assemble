package com.myapps.assemble;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.Environment;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class AddImage extends AppCompatActivity {

    RelativeLayout relativeLayout;
    ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9;
    ImageView[] imageViews = new ImageView[]{};

    Button nxtButton;

    private ImageView selectedImage;
    private int offsetX, offsetY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_image);

        nxtButton = this.findViewById(R.id.nxtButton);
        relativeLayout = this.findViewById(R.id.RLayout);

        img1 = findViewById(R.id.imagePart1);
        img2 = findViewById(R.id.imagePart2);
        img3 = findViewById(R.id.imagePart3);
        img4 = findViewById(R.id.imagePart4);
        img5 = findViewById(R.id.imagePart5);
        img6 = findViewById(R.id.imagePart6);
        img7 = findViewById(R.id.imagePart7);
        img8 = findViewById(R.id.imagePart8);
        img9 = findViewById(R.id.imagePart9);

        imageViews = new ImageView[]{img1, img2, img3, img4, img5, img6, img7, img8, img9};

        boolean[] isImageVisible = getIntent().getBooleanArrayExtra("imageVisibility");

        for (int i = 0; i < imageViews.length; i++) {
            assert isImageVisible != null;
            if (isImageVisible[i]) {
                imageViews[i].setVisibility(View.VISIBLE);
            } else {
                imageViews[i].setVisibility(View.GONE);
            }
        }

        List<Pair<Float, Float>> imagePositions = new ArrayList<>();

        View.OnTouchListener onTouchListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        selectedImage = (ImageView) view;
                        offsetX = (int) event.getX();
                        offsetY = (int) event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (selectedImage != null) {
                            int x = (int) event.getRawX();
                            int y = (int) event.getRawY();
                            selectedImage.setX(x - offsetX);
                            selectedImage.setY(y - offsetY);
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        selectedImage = null;
                        break;
                }


                return true;
            }
        };

        img1.setOnTouchListener(onTouchListener);
        img2.setOnTouchListener(onTouchListener);
        img3.setOnTouchListener(onTouchListener);
        img4.setOnTouchListener(onTouchListener);
        img5.setOnTouchListener(onTouchListener);
        img6.setOnTouchListener(onTouchListener);
        img7.setOnTouchListener(onTouchListener);
        img8.setOnTouchListener(onTouchListener);
        img9.setOnTouchListener(onTouchListener);

// Pass the list to the next activity
        nxtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddImage.this, Choose_Color.class);

                Bitmap bitmap = getBitmapFromView(relativeLayout);
                saveBitmapToDownloads(getApplicationContext(),bitmap,"my_image");
                String filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/my_image.png";
                intent.putExtra("imagePath", filePath);

                startActivity(intent);
            }
        });

    }

    private Bitmap getBitmapFromView(View view) {
        //Define Bitmap of same size
        Bitmap returnBitmap = Bitmap.createBitmap(view.getWidth(),view.getHeight(),Bitmap.Config.ARGB_8888);
        //Bind a canvas to it
        Canvas canvas = new Canvas(returnBitmap);
        //Get the background view of layout
        Drawable background = view.getBackground();
        if (background != null){
            background.draw(canvas);
        }else {
            canvas.drawColor(Color.WHITE);
        }
        //drawing view on canvas
        view.draw(canvas);

        return returnBitmap;
    }

    private void saveBitmapToDownloads(Context context, Bitmap bitmap, String fileName) {
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
        File file = new File(path, fileName + ".png");
        FileOutputStream out;
        try {
            out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.flush();
            out.close();
            // MediaScannerConnection is used to scan the file and update media store
            MediaScannerConnection.scanFile(context, new String[]{file.toString()}, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*private void saveLayoutAsImage(RelativeLayout relativeLayout, String fileName) {
            relativeLayout.setDrawingCacheEnabled(true);
            relativeLayout.buildDrawingCache();
            Bitmap bitmap = Bitmap.createBitmap(relativeLayout.getDrawingCache());
            relativeLayout.setDrawingCacheEnabled(false);

            File file = new File(Environment.getExternalStorageDirectory() + File.separator + fileName + ".png");
            FileOutputStream outputStream = null;
            try {
                outputStream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
                outputStream.flush();
                outputStream.close();
                // Add the image to the system gallery
                MediaScannerConnection.scanFile(this, new String[]{file.getAbsolutePath()}, null, null);
                Toast.makeText(this, "Image Saved", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/

}