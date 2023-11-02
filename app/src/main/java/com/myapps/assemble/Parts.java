package com.myapps.assemble;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Parts extends AppCompatActivity {

    //SCREEN 2

    ImageView imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10;
    ImageView[] images = new ImageView[9];
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parts);

        images[0] = findViewById(R.id.imageView2);
        images[1] = findViewById(R.id.imageView3);
        images[2] = findViewById(R.id.imageView4);
        images[3] = findViewById(R.id.imageView5);
        images[4] = findViewById(R.id.imageView6);
        images[5] = findViewById(R.id.imageView7);
        images[6] = findViewById(R.id.imageView8);
        images[7] = findViewById(R.id.imageView9);
        images[8] = findViewById(R.id.imageView10);

        /*imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);
        imageView10 = findViewById(R.id.imageView10);*/

        next = this.findViewById(R.id.nxt);

        final boolean[] isSelected = new boolean[9];

        boolean[] isImageVisible = new boolean[9];

        for (int i = 0; i < images.length; i++) {
            final int index = i;
            images[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Change the background color of the clicked ImageView
                    if(isSelected[index]){
                        images[index].setBackground(null);
                        isSelected[index] =false;
                        isImageVisible[index] = false;
                    }else {
                        images[index].setBackground(getDrawable(R.drawable.selected_background));
                        isSelected[index] =true;
                        isImageVisible[index] = true;
                    }
                }
            });
        }


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Parts.this,AddImage.class);
                intent.putExtra("imageVisibility", isImageVisible);
                startActivity(intent);
            }
        });

    }
}