package com.example.androidservices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn_web, btn_maps, btn_dial, btn_call, btn_text, btn_email;
    EditText et_data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_web = findViewById(R.id.btn_web);
        btn_call = findViewById(R.id.btn_call);
        btn_dial = findViewById(R.id.btn_dial);
        btn_email = findViewById(R.id.btn_email);
        btn_text = findViewById(R.id.btn_text);
        btn_maps = findViewById(R.id.btn_maps);

        et_data = findViewById(R.id.et_data);


       btn_web.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               openWebPage( et_data.getText().toString());

           }
       });


    }

    private void openWebPage(String url) {


            if (!url.startsWith("http://") || !url.startsWith("https://"))
                url = "http://" + url;
            Uri webpage = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    }

