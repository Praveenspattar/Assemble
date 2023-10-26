package com.myapps.assemble;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AddImage extends AppCompatActivity {

    ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9;
    ImageView[] imageViews = new ImageView[]{};
    /*boolean[] isImageVisible = getIntent().getBooleanArrayExtra("imageVisibility");*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_image);

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
            if (isImageVisible[i]) {
                imageViews[i].setVisibility(View.VISIBLE);
            } else {
                imageViews[i].setVisibility(View.GONE);
            }
        }
    }
}