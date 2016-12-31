package com.esiea.bauvic.inf4041_baudrier_vic.db_handling;


import android.os.AsyncTask;


import com.esiea.bauvic.inf4041_baudrier_vic.datas.Biere;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UsefullVrac extends AsyncTask<Void, Void, ArrayList<Biere>> {

	//private static final String path = "C:/Users/Dearth/bieres.json";
	private static final String sqlRequestListCategory = "SELECT idCategory, AliasCategory FROM category";
	private static final String sqlRequestListCountry = "SELECT idCountry, Aliascountry FROM country";

	//BLOCK REQUEST NAME
	private static String paramName = "THIS SHIT IS PART OF OUR FUNCTION";
	private static final String sqlRequestBiereFromName =
			"SELECT b.* "
					+ "FROM biere b "
					+ "WHERE " + paramName + " LIKE b.name ";
	//Si la valeur d'id de categ ou country, en fonction, n'est pas null
	/*private static String paramIdCategory = "THIS SHIT IS PART OF OUR FUNCTION";
	private static final String sqlRequestBiereCategory =
			"SELECT ca.aliasCategory "
			+ "FROM category ca "
			+ "JOIN biere b using (idCategory)"
			+ "WHERE b.idCategory = " + paramIdCategory;

	private static String paramIdCountry = "THIS SHIT IS PART OF OUR FUNCTION";
	private static final String sqlRequestBiereCountry =
			"SELECT co.aliasCountry "
			+ "FROM country co "
			+ "JOIN biere b using (idCountry)"
			+ "WHERE b.idCountry = " + paramIdCountry;*/


	//BLOCK REQUEST OTHER
	private static String paramNoteOther = "THIS SHIT IS PART OF OUR FUNCTION";
	private static String paramCategoryOther = "THIS SHIT IS PART OF OUR FUNCTION";
	private static String paramCountryOther = "THIS SHIT IS PART OF OUR FUNCTION";
	private static final String sqlRequestBiereFromOther =
			"SELECT * "
					+ "FROM biere "
					+ "WHERE idCountry = " + paramCountryOther + " "
					+ "AND idCategory = " + paramCategoryOther + " "
					+ "AND note = " + paramName + " ";

	@Override
	protected ArrayList<Biere> doInBackground(Void... v) {
		ArrayList<Biere> listeBiere = null;
		try {
			//Téléchargement du fichier via HTTP
			listeBiere = new ArrayList<Biere>();
			URL website = new URL("http://binouze.fabrigli.fr/bieres.json");
			HttpURLConnection con = (HttpURLConnection) website.openConnection();

			InputStream truc = new BufferedInputStream(con.getInputStream());
			BufferedReader read = new BufferedReader(new InputStreamReader(truc));

			String buff;
			StringBuilder res = new StringBuilder();
			while ((buff = read.readLine()) != null)
				res.append(buff);

			String jsonContent = res.toString();

			//On génère les tables de correspondance des id
			//TODO store in a MAP with id as key sqlRequestListCategory
			//TODO store in a MAP with id as key sqlRequestListCountry

			//Création de la bière par itération sur le JSON
			JSONArray jarray = new JSONArray(jsonContent);
			for (int i = 0; i < jarray.length(); i++) {
				JSONObject jo = (JSONObject) jarray.get(i);
				String idCategory = jo.getString("category_id");
				String idCountry = jo.getString("country_id");
				String dateCreation = jo.getString("created_at");
				String description = jo.getString("description");
				String name = jo.getString("name");
				/*int note = 0;
				if (jo.getString("note") != null)
					note = Integer.getInteger(jo.getString("note"));
*/
				Biere b = new Biere(idCategory, idCountry, dateCreation, description, name, 0, null);
				listeBiere.add(b);
			}


		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeBiere;
	}
}
