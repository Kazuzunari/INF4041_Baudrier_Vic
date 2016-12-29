package com.esiea.bauvic.inf4041_baudrier_vic.db_handling;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.esiea.bauvic.inf4041_baudrier_vic.datas.Biere;


public class DBHandler extends SQLiteOpenHelper{


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "BiereQuiRoule";
    private static final String CREATE_TABLE_COUNTRY = "CREATE OR REPLACE TABLE \"COUNTRY\" (\n" +
            "\t`idCountry`\tINTEGER NOT NULL,\n" +
            "\t`AliasCountry`\tTEXT NOT NULL UNIQUE,\n" +
            "\tPRIMARY KEY(`idCountry`)\n" +
            ");";
    private static final String CREATE_TABLE_CATEGORY = "CREATE OR REPLACE TABLE \"CATEGORY\" (\n" +
            "\t`idCategory`\tINTEGER NOT NULL,\n" +
            "\t`AliasCategory`\tTEXT NOT NULL UNIQUE,\n" +
            "\tPRIMARY KEY(`idCategory`)\n" +
            ");";
    private static final String CREATE_TABLE_BIERE = "CREATE OR REPLACE TABLE \"BIERE\" (\n" +
            "\t`idBiere`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "\t`note`\tINTEGER NOT NULL DEFAULT 0,\n" +
            "\t`name`\tTEXT NOT NULL UNIQUE,\n" +
            "\t`descritpion`\tTEXT,\n" +
            "\t`dateCreation`\tTEXT NOT NULL,\n" +
            "\t`pathPhoto`\tTEXT,\n" +
            "\t`idCategory`\tINTEGER,\n" +
            "\t`idCountry`\tINTEGER\n" +
            ");";



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
            "INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (13,'Irish Stout'); COMMIT;"
            ;

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try{
            sqLiteDatabase.execSQL(CREATE_TABLE_CATEGORY);
            //sqLiteDatabase.execSQL(INSERT_CATEGORY);
            sqLiteDatabase.execSQL("INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (1,'Blonde');");
            sqLiteDatabase.execSQL("INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (2,'Blanche');");
            sqLiteDatabase.execSQL("INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (3,'Kriek');");
            sqLiteDatabase.execSQL("INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (4,'Doubme');");
            sqLiteDatabase.execSQL("INSERT INTO `CATEGORY` (idCategory,AliasCategory) VALUES (5,'Bavaroise');");
            sqLiteDatabase.execSQL(CREATE_TABLE_COUNTRY);

            //TODO README IF this doesn't work why does the above doesn't
            ContentValues cv = new ContentValues();
            cv.put("idCountry", 1);
            cv.put("AliasCountry", "'Test'");
            sqLiteDatabase.insert("country", null, cv);

            ContentValues cv2 = new ContentValues();
            cv2.put("idCountry", 2);
            cv2.put("AliasCountry", "Inconnu");
            sqLiteDatabase.insert("country", null, cv2);
            /*sqLiteDatabase.execSQL("INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (1,'Test');");
            sqLiteDatabase.execSQL("INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (2,'Inconnu');");
            sqLiteDatabase.execSQL("INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (3,'Belgique')");
            sqLiteDatabase.execSQL("INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (4,'Pays-bas');");
            sqLiteDatabase.execSQL("INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (5,'Allemagne');");
            sqLiteDatabase.execSQL("INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (6,'Brésil');");
            sqLiteDatabase.execSQL("INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (7,'République Tchèque');");
            sqLiteDatabase.execSQL("INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (8,'Espagne');");
            sqLiteDatabase.execSQL("INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (9,'USA');");
            sqLiteDatabase.execSQL("INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (10,'Italie');");
            sqLiteDatabase.execSQL("INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (11,'Japon');");
            sqLiteDatabase.execSQL("INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (12,'Nord de la France');");
            sqLiteDatabase.execSQL("INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (13,'Mexique');");
            sqLiteDatabase.execSQL("INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (14,'Inde');");
            sqLiteDatabase.execSQL("INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (15,'Hollande');");
            sqLiteDatabase.execSQL("INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (16,'Irlande');");
            sqLiteDatabase.execSQL("INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (17,'Chine');");
            sqLiteDatabase.execSQL("INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (18,'Amérique(Indétérminée)');");
            sqLiteDatabase.execSQL("INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (19,'Thailande');");
            sqLiteDatabase.execSQL("INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (20,'Corée');");
            sqLiteDatabase.execSQL("INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (21,'Grande-Bretagne');");
            sqLiteDatabase.execSQL("INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (22,'Slovénnie');");
            sqLiteDatabase.execSQL("INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (23,'Angleterre');");
            sqLiteDatabase.execSQL("INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (24,'Pays de Galle');");
            sqLiteDatabase.execSQL("INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (25,'Ecosse');");
            sqLiteDatabase.execSQL("INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (26,'Amérindien');");
            sqLiteDatabase.execSQL("INSERT INTO `COUNTRY` (idCountry,AliasCountry) VALUES (27,'Danemark');");
*/
            sqLiteDatabase.execSQL(CREATE_TABLE_BIERE);
            //this.getClass().getClassLoader().getResource("").openStream().re;
            //System.out.println(sqLiteDatabase.inTransaction());
        } catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }

    /*
    public void onOpen(SQLiteDatabase sqLiteDatabase){
       // TODO sqLiteDatabase = getWritableDatabase(); //has to be moved the the mainactivity onOpen
    }
    */

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int nextVersion) {
        destroyEveryting(sqLiteDatabase);
        this.onCreate(sqLiteDatabase);
    }

    private void destroyEveryting (SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS category CASCADE");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS country CASCADE");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS biere CASCADE");
    }

}