package com.bit.movieboard.model;

import lombok.Data;

@Data
public class RatingDTO {
    private int id;
    private int userId;
    private int movieId;
    private double rating;
    private String comment;
}
