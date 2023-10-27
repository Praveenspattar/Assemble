package com.myapps.assemble;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class FinalView extends AppCompatActivity {

    ImageView finalImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_view);

        //to access image from last activity
        finalImg = this.findViewById(R.id.finalImage);
        String imagePath = getIntent().getStringExtra("imagePath");
        Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
        finalImg.setImageBitmap(bitmap);

    }
}