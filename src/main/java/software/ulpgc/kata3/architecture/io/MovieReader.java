package software.ulpgc.kata3.architecture.io;

import software.ulpgc.kata3.architecture.model.Movie;

import java.util.List;

public interface MovieReader {
    List<Movie> read();
}
