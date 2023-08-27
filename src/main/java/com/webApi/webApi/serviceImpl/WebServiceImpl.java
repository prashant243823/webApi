package com.webApi.webApi.serviceImpl;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webApi.webApi.models.MovieDetails;
import com.webApi.webApi.models.MovieModel;
import com.webApi.webApi.models.MoviePageInfo;
import com.webApi.webApi.repository.MovieRepo;
import com.webApi.webApi.service.WebApiService;

import aj.org.objectweb.asm.TypeReference;

@Service
public class WebServiceImpl implements WebApiService{
	
	@Autowired
	MovieRepo repo;

	@Override
	public void uploadMovies(MoviePageInfo movie) {
		String page = movie.getPage();
//		System.out.println(page+"        "+movie.getMovie().get(0).getTitle());
		String uri = "https://jsonmock.hackerrank.com/api/movies/search/?page=1&Title=Spiderman";
		RestTemplate template = new RestTemplate();
//		Map<String,String> map = new HashMap<String, String>();
//		map = template.getForObject(uri, HashMap.class);
//		Object[] objects = template.getForObject(uri, Object[].class);
		String s = template.getForObject(uri, String.class);
		MoviePageInfo movieq = template.getForObject(uri, MoviePageInfo.class);
		try {
			MovieDetails movie1 = new MovieDetails();
			movie1.setImdbId("tt5861236");
			movie1.setMovieTitle("They Call Me Spiderman");
			movie1.setRelYear(2016);
			
			repo.save(movie1);
			
//			List<MovieModel> mov = movieq.getData();
//			for(MovieModel mo:mov) {
//				System.out.println(mo.getTitle());
//			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
//		List<Map<String, Object>> data = mapper.readValue(resp, new TypeReference<List<Map<String, Object>>>(){});
//		System.out.println(resp);
		
	}

	@Override
	public void deleteMovie(String imdbId) {
		Optional<MovieDetails> movie = repo.findById(imdbId);
		if(movie.isPresent()) {
			repo.deleteById(imdbId);
		}
		
	}

	@Override
	public void updateMovie(MoviePageInfo movie) {
		Optional<MovieDetails> movieDetail = repo.findById(movie.getData().get(0).getImdbID());
		if(movieDetail.isPresent()) {
			MovieDetails mov = new MovieDetails();
			mov.setImdbId(movie.getData().get(0).getImdbID());
			mov.setMovieTitle(movie.getData().get(0).getTitle());
			mov.setRelYear(Integer.valueOf(movie.getData().get(0).getYear()));
			repo.save(mov);
		}
		
	}
	
	

}
