package com.webApi.webApi.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;


public class MovieModel {
	
	@JsonProperty
	private String Title; 
	@JsonProperty
	private String Year;
	private String imdbID;
	
	
	public MovieModel(String title, String year, String imdbID) {
		this.Title = title;
		this.Year = year;
		this.imdbID = imdbID;
	}
	
	public MovieModel() {
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String Title) {
		this.Title = Title;
	}
	public String getYear() {
		return Year;
	}
	public void setYear(String Year) {
		this.Year = Year;
	}
	public String getImdbID() {
		return imdbID;
	}
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Title, Year, imdbID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieModel other = (MovieModel) obj;
		return Objects.equals(Title, other.Title) && Objects.equals(Year, other.Year)
				&& Objects.equals(imdbID, other.imdbID);
	}
	
}
