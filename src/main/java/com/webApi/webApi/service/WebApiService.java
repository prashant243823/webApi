package com.webApi.webApi.service;

import com.webApi.webApi.models.MovieModel;
import com.webApi.webApi.models.MoviePageInfo;

public interface WebApiService {
	
	public void uploadMovies(MoviePageInfo movie);
	
	public void deleteMovie(String imdbId);
	
	public void updateMovie(MoviePageInfo movie);

}
