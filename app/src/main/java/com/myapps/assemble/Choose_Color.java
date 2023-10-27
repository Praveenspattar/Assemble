package com.myapps.assemble;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.Environment;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Choose_Color extends AppCompatActivity {

    //ImageView image1,image2,image3,image4,image5,image6,image7,image8,image9;
    ImageView completeImage;
    Button finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_color);

        finish = this.findViewById(R.id.finish);
        completeImage = this.findViewById(R.id.completeImage);

        //to access image from last activity
        completeImage = this.findViewById(R.id.completeImage);
        String imagePath = getIntent().getStringExtra("imagePath");
        Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
        completeImage.setImageBitmap(bitmap);

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Choose_Color.this,FinalView.class);
                Bitmap bitmap = getBitmapFromView(completeImage);
                saveBitmapToDownloads(getApplicationContext(),bitmap,"my_image");
                String filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/my_image.png";
                intent.putExtra("imagePath", filePath);
                //intent.putExtra("imagePositions", new ArrayList<>(imagePositions));
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

}

