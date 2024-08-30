package com.jdbcLearning.DAOs;

import com.jdbcLearning.Models.Movies;

import java.util.List;

public interface MoviesRepository {

    public int insertMovies(Movies movies);

    public List<Movies> getAllMovies();

    public int updateMovies(Movies updatedMovies);

    public int deleteMovies(Movies deletedMovies);



}
