package com.bit.movieboard.model;

import lombok.Data;

@Data
public class MovieDTO {
    private int id;
    private String title;
    private String director;
    private String content;
    private double overallRating;
    private double criticRating;
    private double userRating;

}
