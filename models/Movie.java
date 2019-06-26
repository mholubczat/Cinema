package models;


public class Movie {
    String name;
    long duration;
    int number;

    public int getNumber() {
        return number;
    }

    public Movie(String name, long duration, int number) {
        this.name = name;
        this.duration = duration;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public long getDuration() {
        return duration;
    }
}
