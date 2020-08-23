package com.sda.javarzw11.moviecreator;

public class Movie {
    private String title;
    private String director;
    private String genre;
    private String producer;
    private int releaseYear;

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    public String getProducer() {
        return producer;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String toString() {
        return String.format("Movie:\ntitle: %s\ndirector: %s\nproducer: %s\ngenre: %s\nyear: %d\n",
                title, director, producer, genre, releaseYear);
    }


    public static class MovieCreator {
        String title;
        String director;
        String genre;
        String producer;
        int releaseYear;

        public MovieCreator withTitle(String title) {
            this.title = title;
            return this;
        }

        public MovieCreator withDirector(String director) {
            this.director = director;
            return this;
        }

        public MovieCreator withGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public MovieCreator withProducer(String producer) {
            this.producer = producer;
            return this;
        }

        public MovieCreator withReleaseYear(int releaseYear) {
            this.releaseYear = releaseYear;
            return this;
        }

        public Movie createMovie() {
            Movie movie = new Movie();
            movie.title = this.title;
            movie.director = this.director;
            movie.genre = this.genre;
            movie.producer = this.producer;
            movie.releaseYear = this.releaseYear;
            return movie;
        }
    }

    public static void main(String[] args) {
        MovieCreator creator = new MovieCreator();

        creator.withDirector("Spielberg")
                .withGenre("sport-drama");

        creator.withProducer("Stalone");
        // here something can happen in between
        creator.withTitle("Rocky XII")
                .withReleaseYear(2032);

        Movie movie = creator.createMovie();


        Movie movie2 = new MovieCreator()
                .withDirector("Michael Bay")
                .withGenre("Sci-Fi")
                .withProducer("Michael Bay")
                .withReleaseYear(2012)
                .withTitle("Transformers 3")
                .createMovie();

        System.out.println(movie);
        System.out.println(movie2);
    }
}
