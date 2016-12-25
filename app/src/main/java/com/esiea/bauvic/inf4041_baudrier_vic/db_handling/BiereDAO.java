package com.esiea.bauvic.inf4041_baudrier_vic.db_handling;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.esiea.bauvic.inf4041_baudrier_vic.datas.Biere;

/**
 * Created by Benjamin on 25/12/2016.
 */

public class BiereDAO {

    public void insertNewBiere(SQLiteDatabase sqLiteDatabase, Biere biere){
        StringBuilder sb = new StringBuilder();
        String insertQuery = "insert into `biere` (" +
                "note, name, description, dateCreation, pathPhoto, idCategory, idCountry) " +
                "VALUES ("
                + biere.getNote()+",'"
                + biere.getName()+"','"
                + biere.getDescription()+"','"
                + biere.getDateCreation()+"','"
                + biere.getPhotoPath()+"',"
                + getIdOfCategory(sqLiteDatabase, biere.getCategory())+","
                + getIdOfCountry(sqLiteDatabase, biere.getCategory())
                + ");";
        sqLiteDatabase.execSQL(insertQuery);
    }

    public int getIdOfCategory(SQLiteDatabase sqLiteDatabase, String libelleCategory){
        String query = "SELECT idCategory " +
                "FROM category " +
                "WHERE AliasCategory = '"+libelleCategory+"';";
        System.out.println(query);
        Cursor c = sqLiteDatabase.rawQuery(query, null);
        if (c.moveToFirst()) {
            return c.getInt(0);
        } else {
            return -1;
        }
    }

    public static int getIdOfCountry(SQLiteDatabase sqLiteDatabase, String libelleCountry){
        String query = "SELECT idCountry " +
                "FROM country " +
                "WHERE AliasCountry = '"+libelleCountry+"';";
        System.out.println(query);
        Cursor c = sqLiteDatabase.rawQuery(query, null);
        if (c.moveToFirst()) {
            return c.getInt(0);
        } else {
            return -1;
        }
    }
}
