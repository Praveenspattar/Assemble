package com.myapps.assemble;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Pair;
import android.widget.ImageView;

import java.util.ArrayList;

public class Choose_Color extends AppCompatActivity {

    //ImageView image1,image2,image3,image4,image5,image6,image7,image8,image9;
    ImageView completeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_color);

        completeImage = this.findViewById(R.id.completeImage);
        String imagePath = getIntent().getStringExtra("imagePath");
        Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
        completeImage.setImageBitmap(bitmap);
        /*image1 = this.findViewById(R.id.image1);
        image2 = this.findViewById(R.id.image2);
        image3 = this.findViewById(R.id.image3);
        image4 = this.findViewById(R.id.image4);
        image5 = this.findViewById(R.id.image5);
        image6 = this.findViewById(R.id.image6);
        image7 = this.findViewById(R.id.image7);
        image8 = this.findViewById(R.id.image8);
        image9 = this.findViewById(R.id.image9);*/

        /*ArrayList<Pair<Float, Float>> imagePositions = (ArrayList<Pair<Float, Float>>) getIntent().getSerializableExtra("imagePositions");
        for (Pair<Float, Float> position : imagePositions) {
            float xCoordinate = position.first;
            float yCoordinate = position.second;
            // Do something with the coordinates
        }*/

    }
}