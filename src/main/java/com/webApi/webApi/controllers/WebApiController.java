package com.webApi.webApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.webApi.webApi.models.MovieModel;
import com.webApi.webApi.models.MoviePageInfo;
import com.webApi.webApi.service.WebApiService;

@RestController
public class WebApiController {
	
	@Autowired
	WebApiService webService;

	@GetMapping("/info")
	public String getInfo() {
		
		
		return null;
	}
	
	@RequestMapping(value = "/uploadMovies", method = RequestMethod.POST)
	public String uplaodMovies(@RequestBody MoviePageInfo movie) {
		webService.uploadMovies(movie);
		return null;
	}
	
	@RequestMapping(value = "/deleteMovie", method = RequestMethod.DELETE)
	public void deleteMovie(@RequestParam String imdbId) {
		webService.deleteMovie(imdbId);
	}public WebApiController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = "/updatemovie", method= RequestMethod.PUT)
	public void updateMovie() {
		
	}
}
