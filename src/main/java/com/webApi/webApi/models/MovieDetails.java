package com.webApi.webApi.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie_details")
public class MovieDetails {

	@Column(name = "title")
	private String movieTitle;
	@Column(name = "year")
	private int relYear;

	@Id
	@Column(name = "imdbid")
	private String imdbId;

	public MovieDetails() {
	}

	public MovieDetails(String imdbId, int relYear, String movieTitle) {
		super();
		this.movieTitle = movieTitle;
		this.relYear = relYear;
		this.imdbId = imdbId;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public int getRelYear() {
		return relYear;
	}

	public void setRelYear(int relYear) {
		this.relYear = relYear;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(imdbId, movieTitle, relYear);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieDetails other = (MovieDetails) obj;
		return Objects.equals(imdbId, other.imdbId) && Objects.equals(movieTitle, other.movieTitle)
				&& relYear == other.relYear;
	}

}
