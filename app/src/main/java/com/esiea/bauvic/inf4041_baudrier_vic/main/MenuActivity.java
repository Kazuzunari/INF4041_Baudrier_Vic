package com.esiea.bauvic.inf4041_baudrier_vic.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.esiea.bauvic.inf4041_baudrier_vic.R;

/**
 * Created by Dearth on 29/12/2016.
 */

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        Button button = (Button) findViewById(R.id.bList);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, BeerActivity.class);
                startActivity(intent);
            }
        });

        Button dummy = (Button) findViewById(R.id.dummy);
        dummy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MenuActivity.this, DummyBeer.class);
                startActivity(intent);
            }
        });

        Button toast = (Button) findViewById(R.id.toast);

    }

    public void toast(View tst)
    {
        Toast.makeText(getApplicationContext(),getString(R.string.app_name) + " toast done", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.options, menu);
        return true;
    }
}