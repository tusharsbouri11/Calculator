package com.sample.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class About extends AppCompatActivity implements View.OnClickListener {

    ImageView li, gh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().hide();

        li=findViewById(R.id.li);
        gh=findViewById(R.id.gh);

        li.setOnClickListener(this);
        gh.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId())
        {
            case R.id.li:
                openLink("https://www.linkedin.com/in/tsbouri06b777201/");
                break;

            case R.id.gh:
                openLink("https://github.com/tusharsbouri11");
                break;
        }

    }

    public void openLink(String link)
    {
        Uri uri= Uri.parse(link);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}