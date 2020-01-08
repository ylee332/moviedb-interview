package moviedb.domain;

public class MovieDetails {

    private String name;
    private String releaseDate;
    private String overview;

    public String getName() {
        return name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public MovieDetails(String name, String releaseDate, String overview) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.overview = overview;
    }
}
