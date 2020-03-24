package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button button;
    private int count=0;
    int[] imageArray={R.drawable.number_1,R.drawable.number_2,R.drawable.number_3};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imageView);
        button=findViewById(R.id.imagechangebutton);
        imageView.setImageDrawable(getDrawable(imageArray[count]));
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences=getSharedPreferences("CountPrep",MODE_PRIVATE);
        count=sharedPreferences.getInt("countValue",0);
        imageView.setImageDrawable(getResources().getDrawable(imageArray[count]));

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences=getSharedPreferences("CountPrep",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt("countValue",count);
        editor.apply();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void changeImage(View view) {
        count++;
        if(count==3) {
            count=0;
        }
        imageView.setImageDrawable(getResources().getDrawable(imageArray[count]));
        Log.d("count=",String.valueOf(count));
    }
}
