package com.esiea.bauvic.inf4041_baudrier_vic.main;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.esiea.bauvic.inf4041_baudrier_vic.R;
import com.esiea.bauvic.inf4041_baudrier_vic.db_handling.BiereDAO;
import com.esiea.bauvic.inf4041_baudrier_vic.db_handling.DBHandler;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private DBHandler dbh;

    public MainActivity(){
        super();
        dbh = new DBHandler(MainActivity.this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        //if (cm.getActiveNetworkInfo().isConnected())
        //    launch_get_JSON_network();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_item);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        BiereDAO biereDAO = new BiereDAO();
        SQLiteDatabase dhb = dbh.getReadableDatabase();
        System.out.println(dhb);

        int test1 = biereDAO.getIdOfCategory(dhb,"Bavaroise");
        int test2 = biereDAO.getIdOfCountry(dhb,"Belgique");
        System.out.println("Test idCategory : "+test1);
        System.out.println("Test idCountry : "+test2);

    }
/*
    @Override
    protected void onOpen(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase = dbh.getWritableDatabase();
    }
    */
}