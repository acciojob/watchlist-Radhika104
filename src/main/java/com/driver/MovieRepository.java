package com.driver;

import com.fasterxml.jackson.datatype.jdk8.OptionalDoubleSerializer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepository {

    HashMap<String,Movie> moviesData=new HashMap<>();
    HashMap<String,Director> directorsData=new HashMap<>();
    HashMap<Director,List<Movie>> pairs=new HashMap<>();

    public void addMovie(Movie movie)
    {
        moviesData.put(movie.getName(),movie);
    }

    public void addDirector(Director director)
    {
        directorsData.put(director.getName(),director);
    }

    public void addMovieDirectorPair(Movie movie,Director director)
    {
        if(pairs.containsKey(director))
        {
          pairs.get(director).add(movie);
        }
        else
        {
            List<Movie> list=new ArrayList<>();
            list.add(movie);
            pairs.put(director,list);
        }
    }

    public Movie getMovieByName(String name)
    {
       return moviesData.get(name);
    }

    public Director getDirectorByName(String name)
    {

        return directorsData.get(name);
    }

    public List<Movie> getMoviesByDirectorName(Director director)
    {
         return pairs.get(director);
    }

    public List<Movie> findAllMovies()
    {
        return new ArrayList<Movie>(moviesData.values());
    }

    public void deleteDirectorByName(Director director)
    {
        List<Movie> list=pairs.get(director);
        for(Movie movie:list)
        {
            moviesData.remove(movie.getName());
        }
        pairs.remove(director);
        directorsData.remove(director);
    }

    public void deleteAllDirectors()
    {
        for(String name:directorsData.keySet())
        {
            deleteDirectorByName(getDirectorByName(name));
        }
        pairs.clear();
    }

}
