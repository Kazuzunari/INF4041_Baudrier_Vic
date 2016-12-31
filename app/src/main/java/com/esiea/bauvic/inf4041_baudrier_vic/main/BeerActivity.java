/*
* Copyright 2013 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/


package com.esiea.bauvic.inf4041_baudrier_vic.main;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.esiea.bauvic.inf4041_baudrier_vic.R;
import com.esiea.bauvic.inf4041_baudrier_vic.datas.Biere;
import com.esiea.bauvic.inf4041_baudrier_vic.datas.BiereAdapter;
import com.esiea.bauvic.inf4041_baudrier_vic.db_handling.UsefullVrac;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class BeerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.my_beers);
        RecyclerView recList = (RecyclerView) findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        UsefullVrac parser = new UsefullVrac();
        ArrayList<Biere> b = null;
        try{
            b = parser.execute().get();
        }
        catch(ExecutionException | InterruptedException i){
            i.printStackTrace();
        }

        BiereAdapter bieres = new BiereAdapter(b);
        recList.setAdapter(bieres);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private List<Biere> createList(int size) {

        List<Biere> result = new ArrayList<>();
        for (int i=1; i <= size; i++) {
            Biere b = new Biere("cat" + i, "country"+i, "date"+i, "blabla"+i, "bière"+i, i % 6, "photo"+i);
            result.add(b);
        }
        return result;
    }
}
