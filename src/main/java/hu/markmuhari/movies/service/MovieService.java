package hu.markmuhari.movies.service;

import hu.markmuhari.movies.model.Movie;
import hu.markmuhari.movies.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getSingleMovieByImdbId(String id) {
        return movieRepository.findMovieByImdbId(id);
    }


}
