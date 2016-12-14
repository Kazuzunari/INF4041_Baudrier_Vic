import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UsefullVrac {

	private static final String path = "C:/users/Benjamin/Pictures/bieres.json";
	
	private static final String sqlRequestListCategory = "SELECT idCategory, AliasCategory FROM category";
	private static final String sqlRequestListCountry = "SELECT idCountry, Aliascountry FROM country";
	
	//BLOCK REQUEST NAME
	private static String paramName= "THIS SHIT IS PART OF OUR FUNCTION";
	private static final String sqlRequestBiereFromName = 
			"SELECT b.* "
			+ "FROM biere b "
			+ "WHERE "+paramName+" LIKE b.name ";
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
			+ "WHERE idCountry = "+paramCountryOther+" "
			+ "AND idCategory = "+paramCategoryOther+" "
			+ "AND note = "+paramName+" ";
	

	public static void main(String[] args) {
		try {
			//Télécharment du fichier via HTTP
			URL website = new URL("http://binouze.fabrigli.fr/bieres.json");
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream(path);
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			
			//Preparation du parsing
			File f = new File(path);
			char[] buffer = new char[(int) f.length()];
			FileReader fr = new FileReader(f);
			fr.read(buffer);
			String jsonContent = String.valueOf(buffer);

			//On génère les tables de correspondance des id
			//TODO store in a MAP with id as key sqlRequestListCategory
			//TODO store in a MAP with id as key sqlRequestListCountry
			
			//Création de la bière par itération sur le JSON
			JSONArray jarray = new JSONArray(jsonContent);
			for (int i = 0 ; i<jarray.length() ; i++){
				JSONObject jo = (JSONObject) jarray.get(i);
				String idCategory = jo.getString("category_id");
				String idCountry = jo.getString("country_id");
				String dateCreation = jo.getString("created_at");
				String description = jo.getString("description");
				String name = jo.getString("name");
				String note = jo.getString("note");
				
				//Biere b = new Biere();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
