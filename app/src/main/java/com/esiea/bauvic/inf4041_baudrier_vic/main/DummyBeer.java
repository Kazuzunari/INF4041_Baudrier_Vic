package com.esiea.bauvic.inf4041_baudrier_vic.main;

import android.app.Activity;
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

/**
 * Created by Dearth on 30/12/2016.
 */

public class DummyBeer extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.my_beers);
        RecyclerView recList = (RecyclerView) findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        BiereAdapter bieres = new BiereAdapter(createList(30));
        recList.setAdapter(bieres);
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
