package com.webApi.webApi.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.webApi.webApi.Exception.ResourceNotFound;
import com.webApi.webApi.models.MovieDetails;
import com.webApi.webApi.models.MovieModel;
import com.webApi.webApi.models.MoviePageInfo;
import com.webApi.webApi.repository.MovieRepo;
import com.webApi.webApi.service.WebApiService;

@Service
public class WebServiceImpl implements WebApiService {

	@Autowired
	MovieRepo repo;
	
	@Override
	public List<MovieModel> findAll() {
		List<MovieModel> movieList = repo.findAll().stream().map(mo -> new MovieModel(mo.getMovieTitle(),String.valueOf(mo.getRelYear()),mo.getImdbId())).collect(Collectors.toList());
		System.err.println("");
		return movieList;
	}

	@Override
	public ResponseEntity<?> uploadMovies(MoviePageInfo movie) {
		StringBuilder uriExten = new StringBuilder();
		boolean amper = false;
		if (!"".equals(movie.getPage()) && movie.getPage() != null) {
			uriExten.append("page=" + movie.getPage());
			amper = true;
		}
		String title = movie.getData().get(0).getTitle();
		if (!"".equals(title) && title != null) {
			uriExten.append(amper ? "&Title=" + title : "Title=" + title);
			amper = true;
		}
		String year = movie.getData().get(0).getYear();
		if (!"".equals(year) && year != null) {
			uriExten.append(amper ? "&Year=" + year : "Year=" + year);
			amper = true;
		}
		String uri = "https://jsonmock.hackerrank.com/api/movies/search/?" + uriExten;
		RestTemplate template = new RestTemplate();
		MoviePageInfo movieq = template.getForObject(uri, MoviePageInfo.class);
		if (movieq.getData().size() < 1)
			return new ResponseEntity<>(new ResourceNotFound("not records found"), HttpStatus.NO_CONTENT);
		List<MovieModel> mov = movieq.getData();
		List<MovieDetails> movDetail = mov.stream()
				.map(mo -> new MovieDetails(mo.getImdbID(), Integer.parseInt(mo.getYear()), mo.getTitle()))
				.collect(Collectors.toList());
		repo.saveAll(movDetail);
		return new ResponseEntity<>("Records saved success fully", HttpStatus.OK);
	}

	@Override
	public void deleteMovie(String imdbId) {
		Optional<MovieDetails> movie = repo.findById(imdbId);
		if (movie.isPresent()) {
			repo.deleteById(imdbId);
		}

	}

	@Override
	public void updateMovie(MoviePageInfo movie) {
		Optional<MovieDetails> movieDetail = repo.findById(movie.getData().get(0).getImdbID());
		if (movieDetail.isPresent()) {
			MovieDetails mov = new MovieDetails();
			mov.setImdbId(movie.getData().get(0).getImdbID());
			mov.setMovieTitle(movie.getData().get(0).getTitle());
			mov.setRelYear(Integer.valueOf(movie.getData().get(0).getYear()));
			repo.save(mov);
		}

	}

	

}
