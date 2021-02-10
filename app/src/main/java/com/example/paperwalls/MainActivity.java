package com.example.paperwalls;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.WallpaperManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    LinearLayout linearLayout;
    LinearLayout soundy;
    TextView textView;
    ImageView imageView;
    RecyclerView recyclerView;
    Adapter customAdapter;


    int imagePosition;
    int on=0;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout=(LinearLayout) findViewById(R.id.setLinear);
        soundy=(LinearLayout) findViewById(R.id.sound);
        imageView=(findViewById(R.id.imageMain));
        recyclerView=(RecyclerView) findViewById(R.id.recyclerview);
        textView=(TextView) findViewById(R.id.textSet);

        Intent intent=getIntent();

        imagePosition = intent.getIntExtra("image",00);

        imageView.setImageResource(imagePosition);


        int [] image= new int[]

                {

                        R.drawable.image1,   R.drawable.image2  ,  R.drawable.image3 , R.drawable.image4

                        , R.drawable.image5, R.drawable.image6,   R.drawable.image7  ,  R.drawable.image8, R.drawable.image9

                        , R.drawable.image10


                };
        int [] sounds=new int[]
                {
                        R.raw.phone, R.raw.flower,R.raw.jungle, R.raw.oceanwave,R.raw.mountain, R.raw.jungle5,R.raw.forest, R.raw.car,R.raw.city_traffic, R.raw.night2
                };



        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayout.HORIZONTAL,false));
        customAdapter=new Adapter(image,sounds,this);

        recyclerView.setAdapter(customAdapter);



        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setAsWallpaper();

            }
        });
        soundy.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View view) {
                int pom=imagePosition;
                int i;
                for(i=0;i<10;i++){
                    if (pom==image[i]) break;
                }
                final int sss=sounds[i];
                MediaPlayer ring = MediaPlayer.create(MainActivity.this, sss);
                ring.start();
            }
        });



    }

    public void SetButton(View view)
    {
        if(on==0)
        {
            on++;
            textView.setVisibility(View.VISIBLE);
            linearLayout.setVisibility(View.VISIBLE);
            soundy.setVisibility(View.VISIBLE);
        }
        else if (on!=0)
        {
            --on;
            textView.setVisibility(View.INVISIBLE);
            linearLayout.setVisibility(View.INVISIBLE);
            soundy.setVisibility(View.INVISIBLE);
        }

    }


    public void setAsWallpaper() {
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(MainActivity.this);

        if (imagePosition != 0) {

            try {
                Toast.makeText(MainActivity.this, "Wallpaper Set", Toast.LENGTH_SHORT).show();
                wallpaperManager.setResource(imagePosition);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (imagePosition == 0) {
            {
                int tempImage= R.raw.image1;

                try {
                    Toast.makeText(MainActivity.this, "Wallpaper Set", Toast.LENGTH_SHORT).show();
                    wallpaperManager.setResource(tempImage);
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }
    }}