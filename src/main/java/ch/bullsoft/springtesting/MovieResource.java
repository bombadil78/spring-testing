package ch.bullsoft.springtesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieResource {

    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Movie> getAll() {
        try {
            return movieRepository.findAll();
        } catch (Exception ex) {
            return Collections.EMPTY_LIST;
        }
    }

    public MovieRepository getMovieRepository() {
        return movieRepository;
    }
}
