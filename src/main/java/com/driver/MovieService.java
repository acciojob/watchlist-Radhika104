package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public void addMovie(Movie movie)
    {
        movieRepository.addMovie(movie);
    }

    public void addDirector(Director director)
    {
        movieRepository.addDirector(director);
    }

    public void addMovieDirectorPair(String movieName,String directorName)
    {
        movieRepository.addMovieDirectorPair(movieRepository.getMovieByName(movieName),movieRepository.getDirectorByName(directorName));
    }

    public Movie getMovieByName(String movieName)
    {
        return movieRepository.getMovieByName(movieName);
    }

    public Director getDirectorByName(String directorName)
    {
        return movieRepository.getDirectorByName(directorName);
    }

    public List getMoviesByDirectorName(String directorName)
    {
        return movieRepository.getMoviesByDirectorName(movieRepository.getDirectorByName(directorName));
    }

    public List findAllMovies()
    {
        return movieRepository.findAllMovies();
    }

    public void deleteDirectorByName(String name)
    {
        movieRepository.deleteDirectorByName(movieRepository.getDirectorByName(name));
    }

    public void deleteAllDirectors()
    {
        movieRepository.deleteAllDirectors();
    }
}
