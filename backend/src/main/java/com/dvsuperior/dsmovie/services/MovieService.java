package com.dvsuperior.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvsuperior.dsmovie.dto.MovieDTO;
import com.dvsuperior.dsmovie.entities.Movie;
import com.dvsuperior.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;

	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {

		//Page<Movie> result = repository.findAll(pageable);
		//Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
		//return page;
		
		return repository.findAll(pageable).map(x -> new MovieDTO(x));
	}

	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {

		Movie movie = repository.findById(id).get();
		return new MovieDTO(movie);
		
		//return new MovieDTO(repository.findById(id).get());
	}

}
