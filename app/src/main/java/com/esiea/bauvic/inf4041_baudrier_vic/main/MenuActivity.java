package com.esiea.bauvic.inf4041_baudrier_vic.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.esiea.bauvic.inf4041_baudrier_vic.R;

/**
 * Created by Dearth on 29/12/2016.
 */

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Button button = (Button) findViewById(R.id.bList);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, BeerActivity.class);
                startActivity(intent);
            }
        });
    }
}
