package moviedb.controller;

import moviedb.domain.MovieDetails;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RestController
@RequestMapping("/moviedb")
public class MovieController {

    private static final String MOVIE_URL = "https://api.themoviedb.org/3/movie/";
    private static final String API_KEY_QUERY = "?api_key=";

    @Value("${movie.apikey}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/movie/{movieId}", method = RequestMethod.GET)
    public MovieDetails getMovieDetails(
            @PathVariable("movieId") String movieId) {
        String jsonString = restTemplate.getForObject(MOVIE_URL + movieId + API_KEY_QUERY + apiKey, String.class);
        JSONObject jsonObject = new JSONObject(jsonString);
        return new MovieDetails(jsonObject.getString("original_title"), jsonObject.getString("release_date"), jsonObject.getString("overview"));
    }

}
