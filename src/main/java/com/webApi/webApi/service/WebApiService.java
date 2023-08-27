package com.webApi.webApi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.webApi.webApi.models.MovieModel;
import com.webApi.webApi.models.MoviePageInfo;

public interface WebApiService {
	
	public List<MovieModel> findAll();
	
	public ResponseEntity<?> uploadMovies(MoviePageInfo movie);
	
	public void deleteMovie(String imdbId);
	
	public void updateMovie(MoviePageInfo movie);

}
