package com.esiea.bauvic.inf4041_baudrier_vic.db_handling;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.esiea.bauvic.inf4041_baudrier_vic.datas.Biere;

/**
 * Created by Dearth on 13/12/2016.
 */

public class DBHandler extends SQLiteOpenHelper{


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Biere.db";
    private static final String CREATE_TABLE_COUNTRY = "CREATE TABLE \"COUNTRY\" (\n" +
            "\t`idCountry`\tINTEGER NOT NULL,\n" +
            "\t`AliasCountry`\tTEXT NOT NULL UNIQUE,\n" +
            "\tPRIMARY KEY(`idCountry`)\n" +
            ");";
    private static final String CREATE_TABLE_CATEGORY = "CREATE TABLE \"CATEGORY\" (\n" +
            "\t`idCategory`\tINTEGER NOT NULL,\n" +
            "\t`AliasCategory`\tTEXT NOT NULL UNIQUE,\n" +
            "\tPRIMARY KEY(`idCategory`)\n" +
            ");";
    private static final String CREATE_TABLE_BIERE = "CREATE TABLE \"BIERE\" (\n" +
            "\t`idBiere`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "\t`note`\tINTEGER NOT NULL DEFAULT 0,\n" +
            "\t`name`\tTEXT NOT NULL UNIQUE,\n" +
            "\t`descritpion`\tTEXT,\n" +
            "\t`dateCreation`\tTEXT NOT NULL,\n" +
            "\t`pathPhoto`\tTEXT,\n" +
            "\t`idCategory`\tINTEGER,\n" +
            "\t`idCountry`\tINTEGER\n" +
            ");";

    private static final String INSERT_COUNTRY = "INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (1,'Test');\n" +
            "INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (2,'Inconnu');\n" +
            "INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (3,'Belgique');\n" +
            "INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (4,'Pays-bas');\n" +
            "INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (5,'Allemagne');\n" +
            "INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (6,'Brésil');\n" +
            "INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (7,'République Tchèque');\n" +
            "INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (8,'Espagne');\n" +
            "INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (9,'USA');\n" +
            "INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (10,'Italie');\n" +
            "INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (11,'Japon');\n" +
            "INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (12,'Nord de la France');\n" +
            "INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (13,'Mexique');\n" +
            "INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (14,'Inde');\n" +
            "INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (15,'Hollande');\n" +
            "INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (16,'Irlande');\n" +
            "INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (17,'Chine');\n" +
            "INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (18,'Amérique(Indétérminée)');\n" +
            "INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (19,'Thailande');\n" +
            "INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (20,'Corée');\n" +
            "INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (21,'Grande-Bretagne');\n" +
            "INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (22,'Slovénnie');\n" +
            "INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (23,'Angleterre');\n" +
            "INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (24,'Pays de Galle');\n" +
            "INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (25,'Ecosse');\n" +
            "INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (26,'Amérindien');\n" +
            "INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (27,'Danemark');"
            ;
    private static final String INSERT_CATEGORY = "INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (1,'Blonde');\n" +
            "INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (2,'Blanche');\n" +
            "INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (3,'Kriek');\n" +
            "INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (4,'Doubme');\n" +
            "INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (5,'Bavaroise');\n" +
            "INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (6,'Forte');\n" +
            "INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (7,'Ambrée');\n" +
            "INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (8,'Spéciale');\n" +
            "INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (9,'Irish Red Ale');\n" +
            "INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (10,'Fruit Beer');\n" +
            "INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (11,'India Pale Ale');\n" +
            "INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (12,'Pale Ale');\n" +
            "INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (13,'Irish Stout');"
            ;

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_CATEGORY);
        sqLiteDatabase.execSQL(INSERT_CATEGORY);
        sqLiteDatabase.execSQL(CREATE_TABLE_COUNTRY);
        sqLiteDatabase.execSQL(INSERT_COUNTRY);
        sqLiteDatabase.execSQL(CREATE_TABLE_BIERE);
        //this.getClass().getClassLoader().getResource("").openStream().re;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int nextVersion) {
        destroyEveryting(sqLiteDatabase);
        this.onCreate(sqLiteDatabase);
    }

    private void destroyEveryting (SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS category");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS country");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS biere");
    }

    //TODO MOVE TO DAO
    public void insertNewBiere(SQLiteDatabase sqLiteDatabase, Biere biere){
        StringBuilder sb = new StringBuilder();
        String insertQuery = "insert into `biere` (" +
                "note, name, description, dateCreation, pathPhoto, idCategory, idCountry) " +
                "VALUES ("
                + biere.getNote()+","
                + biere.getName()+","
                + biere.getDescription()+","
                + biere.getDateCreation()+","
                + biere.getPhotoPath()+","
                + getIdOfCategory(biere.getCategory())+","
                + getIdOfCountry(biere.getCategory())+","
                + ");";
    }

    //TODO MOVE TO DAO
    public String getIdOfCategory(String libelleCategory){
        //TODO
        return null;
    }

    //TODO MOVE TO DAO
    public String getIdOfCountry(String libelleCountry){
        //TODO
        return null;
    }
}
