package com.example.newspaper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoView;

import java.security.Key;

public class DetailActivity extends AppCompatActivity {



    PhotoView newsImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        newsImage = (PhotoView) findViewById(R.id.ivImage2);

        getSupportActionBar().hide();
        getSupportActionBar().setTitle("Full Screen Image");

        Bundle mBundle = getIntent().getExtras();

        if(mBundle!=null){


            newsImage.setImageResource(mBundle.getInt( "image"));

        }else{
            Toast.makeText(this, "Null", Toast.LENGTH_SHORT).show();
        }
    }
}
