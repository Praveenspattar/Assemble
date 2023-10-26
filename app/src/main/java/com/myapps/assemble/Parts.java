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
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parts);

        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);
        imageView10 = findViewById(R.id.imageView10);

        next = this.findViewById(R.id.nxt);

        final boolean[] isSelected = new boolean[9];

        boolean[] isImageVisible = new boolean[9];


        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isSelected[0]){
                    imageView2.setBackground(null);
                    isSelected[0] =false;
                    isImageVisible[0] = false;
                }else {
                    imageView2.setBackground(getDrawable(R.drawable.selected_background));
                    isSelected[0] =true;
                    isImageVisible[0] = true;
                }
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isSelected[1]){
                    imageView3.setBackground(null);
                    isSelected[1] =false;
                    isImageVisible[1] = false;
                }else {
                    imageView3.setBackground(getDrawable(R.drawable.selected_background));
                    isSelected[1] =true;
                    isImageVisible[1] = true;
                }
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isSelected[2]){
                    imageView4.setBackground(null);
                    isSelected[2] =false;
                    isImageVisible[2] = false;
                }else {
                    imageView4.setBackground(getDrawable(R.drawable.selected_background));
                    isSelected[2] =true;
                    isImageVisible[2] = true;
                }
            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isSelected[3]){
                    imageView5.setBackground(null);
                    isSelected[3] =false;
                    isImageVisible[3] = false;
                }else {
                    imageView5.setBackground(getDrawable(R.drawable.selected_background));
                    isSelected[3] =true;
                    isImageVisible[3] = true;
                }
            }
        });
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isSelected[4]){
                    imageView6.setBackground(null);
                    isSelected[4] =false;
                    isImageVisible[4] = false;
                }else {
                    imageView6.setBackground(getDrawable(R.drawable.selected_background));
                    isSelected[4] =true;
                    isImageVisible[4] = true;
                }
            }
        });
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isSelected[5]){
                    imageView7.setBackground(null);
                    isSelected[5] =false;
                    isImageVisible[5] = true;
                }else {
                    imageView7.setBackground(getDrawable(R.drawable.selected_background));
                    isSelected[5] =true;
                    isImageVisible[5] = true;
                }
            }
        });
        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isSelected[6]){
                    imageView8.setBackground(null);
                    isSelected[6] =false;
                    isImageVisible[6] = false;
                }else {
                    imageView8.setBackground(getDrawable(R.drawable.selected_background));
                    isSelected[6] =true;
                    isImageVisible[6] = true;
                }
            }
        });
        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isSelected[7]){
                    imageView9.setBackground(null);
                    isSelected[7] =false;
                    isImageVisible[7] = false;
                }else {
                    imageView9.setBackground(getDrawable(R.drawable.selected_background));
                    isSelected[7] =true;
                    isImageVisible[7] = true;
                }
            }
        });
        imageView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isSelected[8]){
                    imageView10.setBackground(null);
                    isSelected[8] =false;
                    isImageVisible[8] = false;
                }else {
                    imageView10.setBackground(getDrawable(R.drawable.selected_background));
                    isSelected[8] =true;
                    isImageVisible[8] = true;
                }
            }
        });

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