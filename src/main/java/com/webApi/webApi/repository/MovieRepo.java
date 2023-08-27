package com.webApi.webApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webApi.webApi.models.MovieDetails;

@Repository
public interface MovieRepo extends JpaRepository<MovieDetails, String>{

}
