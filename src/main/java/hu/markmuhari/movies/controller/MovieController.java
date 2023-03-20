package hu.markmuhari.movies.controller;

import hu.markmuhari.movies.model.Movie;
import hu.markmuhari.movies.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovie() {
        return new ResponseEntity<>(movieService.allMovies(), HttpStatus.OK);
    }
}
