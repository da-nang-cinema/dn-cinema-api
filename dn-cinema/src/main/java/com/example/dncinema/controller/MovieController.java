package com.example.dncinema.controller;

import com.example.dncinema.model.Film;
import com.example.dncinema.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@CrossOrigin("*")
public class MovieController {
    @Autowired
    private IMovieService movieService;

    @GetMapping
    public Page<Film> findAllFilm(@PageableDefault(size = 4) Pageable pageable,
                                  @RequestParam(required = false, defaultValue = "") String search) {
        Page<Film> films = movieService.findAllFilm(search, pageable);
        List<Film> filmList = films.toList();
        return new PageImpl<>(filmList, pageable, films.getTotalElements());
    }

//    @GetMapping("/{id}")

//    public Film findFilmById(@PathVariable Integer id) {
//        return movieService.findFilmById(id);
//    }


    @GetMapping("/detail/{id}")
    public ResponseEntity<?> findFilmById(@PathVariable Integer id) {
        Film film = movieService.findFilmById(id);
        if (film == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(film, HttpStatus.OK);
    }
}
