package com.esiea.bauvic.inf4041_baudrier_vic.datas;

/**
 * Created by Dearth on 13/12/2016.
 */

public class Biere {
	

	private final String category;
	private final String country;
	private final String dateCreation;
	private final String description;
	private final String name;
	private final int note;
	private final String photoPath;
	
	public Biere (String category, String country,
			String dateCreation, String description, String name,
			int note, String photoPath){
		this.category = category;
		this.country = country;
		this.dateCreation = dateCreation;
		this.description = description;
		this.name = name;
		this.note = note;
		this.photoPath = photoPath;
	}
	
	public String getCategory(){
		return this.category;
	}
	
	public String getCountry(){
		return this.country;
	}
	
	public String getDateCreation(){
		return this.dateCreation;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getNote(){
		return this.note;
	}
	
	public String getPhotoPath(){
		return this.getPhotoPath();
	}

    @Override
    public String toString() {
        return "Biere{" +
                "category='" + category + '\'' +
                ", country='" + country + '\'' +
                ", dateCreation='" + dateCreation + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", note=" + note +
                ", photoPath='" + photoPath + '\'' +
                '}';
    }

}
