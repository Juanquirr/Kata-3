package software.ulpgc.kata3.apps.windows;

import software.ulpgc.kata3.architecture.io.BarchartLoader;
import software.ulpgc.kata3.architecture.io.TsvFileMovieReader;
import software.ulpgc.kata3.architecture.model.Barchart;
import software.ulpgc.kata3.architecture.model.Movie;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CustomBarchartLoader implements BarchartLoader {
    private final Barchart barchart0;
    private final Barchart barchart1;

    public CustomBarchartLoader() {
        this.barchart0 = countMoviesFrom2000();
        this.barchart1 = countTitleTypes();
    }

    @Override
    public Barchart loadBarchart(int id) {
        return switch (id) {
            case 0 -> barchart0;
            case 1 -> barchart1;
            default -> null;
        };
    }
    private Barchart countTitleTypes() {
        Barchart map = new Barchart("Title types", "Title Types", "Count");
        for (Movie movie : fileToListOfTitleTypes())
            map.put(movie.titleType().toString(), map.getOrDefault(movie.titleType().toString(), 0) + 1);
        return map;
    }

    private Barchart countMoviesFrom2000() {
        Barchart map = new Barchart("Movies from 2000s", "Movies", "Count");
        for (Movie movie : fileToListOfTitleTypes()) {
            if ((movie.startYear().getValue()) > 1999 && movie.startYear().getValue() < 2010)
                map.put(movie.startYear().toString(), map.getOrDefault(movie.startYear().toString(), 0) + 1);
        }
        return map;
    }

    private static List<Movie> fileToListOfTitleTypes() {
        return new TsvFileMovieReader(new File("title.basics.tsv")).read();
    }

}
