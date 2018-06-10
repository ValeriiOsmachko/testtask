package com.ratiose.testtask.controller;

import javax.servlet.http.HttpSession;

import com.ratiose.testtask.dto.ActorDto;
import com.ratiose.testtask.service.UserService;
import com.ratiose.testtask.service.tmdb.TmdbApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private UserService userService;

    @Autowired
    private TmdbApi tmdbApi;

    @RequestMapping(value = "/popular", method = POST)
    public ResponseEntity popular(@RequestParam String email,
                                  @RequestParam String password,
                                  HttpSession session) {
        if (userService.findUser(email, password) == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        String popularMovies = tmdbApi.popularMovies();

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(popularMovies);
    }


    @RequestMapping(value = "/actor" , method = POST)
    @Secured("USER")
    public void addFavouriteActor(@RequestBody final ActorDto actorDto) {
        tmdbApi.popularMovies();
    }
}
